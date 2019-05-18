package wyrażenia;

public class Dodawanie extends WyrażenieDwuarg {

    public Dodawanie(Wyrażenie arg1, Wyrażenie arg2) {
        super(arg1, arg2);
    }

    @Override
    public String toString() {
        return "(" +arg1 + ")" + "+" + "(" + arg2 + ")";
    }

    @Override
    public double wartośćWPunkcie(double x){
        return arg1.wartośćWPunkcie(x) + arg2.wartośćWPunkcie(x);
    }

    @Override
    public Wyrażenie pochodna(){
        return new Dodawanie(arg1.pochodna() , arg2.pochodna());
    }

//    @Override
    public Wyrażenie uprość(){
        // jeśli arg1 = (10x-10x) lub (5-5) lub 0 lub (0+0)

        /* na początek upraszam argumenty
        Wyrażenie arg1 = arg1.uprość()
        Wyrażenie arg2 = arg2.uprość()
        */

        if (arg1 instanceof Stała && arg2 instanceof Stała && (arg1.wartośćWPunkcie(0) + arg2.wartośćWPunkcie(0)==0)) {
            return new Stała(0);
        }
        if (arg1 instanceof Stała && arg1.wartośćWPunkcie(0)==0){
            return arg2;
        }
        if (arg2 instanceof Stała && arg2.wartośćWPunkcie(0)==0) {
            return arg1;
        }


        return this;
    }
}
