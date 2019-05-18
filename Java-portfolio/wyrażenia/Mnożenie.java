package wyrażenia;

public class Mnożenie  extends WyrażenieDwuarg{

    public Mnożenie(Wyrażenie arg1, Wyrażenie arg2) {
        super(arg1, arg2);
    }

    @Override
    public double wartośćWPunkcie(double x) {
        return arg1.wartośćWPunkcie(x)*arg2.wartośćWPunkcie(x);
    }


    @Override
    public String toString() {
        return "(" +arg1 + ")" + "*" + "(" + arg2 + ")";
    }

    @Override
    public Wyrażenie pochodna() {
        return new Dodawanie (new Mnożenie(arg1.pochodna(), arg2), (new Mnożenie(arg1, arg2.pochodna()))  );
    }

    //@Override
    public Wyrażenie uprość(){
        /* na początek upraszam argumenty
        Wyrażenie arg1 = arg1.uprość()
        Wyrażenie arg2 = arg2.uprość()
        */
        if (arg1 instanceof Stała && arg2 instanceof Stała) {
            double wart1 = arg1.wartośćWPunkcie(0);
            double wart2 = arg2.wartośćWPunkcie(0);
            return new Stała(wart1*wart2);

        }

        else if (arg1 instanceof Stała || arg2 instanceof Stała) {
//            if (arg2 instanceof Stała){
//
//            }
            // arg1 jest stałą, a arg 2 czyms innym
            double wart1 = arg1.wartośćWPunkcie(0);
            if (wart1 == 0 ){
                return new Stała(0);
            }
            if (wart1==1 ){
                return arg2;
            }
            return this;
        }

        return this;

    }
}
