package wyrażenia;

public class Dzielenie extends WyrażenieDwuarg {

    public Dzielenie(Wyrażenie arg1, Wyrażenie arg2) {
        super(arg1, arg2);
//        if arg2.uprość().wartośćWPunkcie(0)==0:
//            sout(Nie dziel przez zero)
    }

    @Override
    public double wartośćWPunkcie(double x) {
        return arg1.wartośćWPunkcie(x)/arg2.wartośćWPunkcie(x);
    }


    @Override
    public String toString() {
        return "(" +arg1 + ")" + "/" + "(" + arg2 + ")";

    }

    @Override
    public Wyrażenie pochodna() {
        return new Dzielenie(  new Odejmowanie (new Mnożenie(arg1.pochodna(), arg2), (new Mnożenie(arg1, arg2.pochodna()))  ),
                new DoKwadratu(arg2) );
    }

    //@Override
    public Wyrażenie uprość() {
        /* na początek upraszam argumenty
        Wyrażenie arg1 = arg1.uprość()
        Wyrażenie arg2 = arg2.uprość()
        */
        if (arg1 instanceof Stała && arg2 instanceof Stała) {
            double wart1 = arg1.wartośćWPunkcie(0);
            double wart2 = arg2.wartośćWPunkcie(0);
            return new Stała(wart1/wart2);
        }
        if (arg2 instanceof Stała && arg2.wartośćWPunkcie(0)==0){
            return arg1;
        }
        return this;
    }
}
