package wyrażenia;

public class Odejmowanie extends WyrażenieDwuarg {

    public Odejmowanie(Wyrażenie arg1, Wyrażenie arg2) {
        super(arg1, arg2);
    }

    @Override
    public String toString() {
        return "(" +arg1 + ")" + "-" + "(" + arg2 + ")";
    }

    @Override
    public double wartośćWPunkcie(double x){
        return arg1.wartośćWPunkcie(x) - arg2.wartośćWPunkcie(x);
    }

    @Override
    public Wyrażenie pochodna(){
        return new Odejmowanie(arg1.pochodna() , arg2.pochodna());
    }


    //    @Override
    public Wyrażenie uprość(){

        /* na początek upraszam argumenty
        Wyrażenie arg1 = arg1.uprość()
        Wyrażenie arg2 = arg2.uprość()
        */

        if (arg2 instanceof Stała && arg2.wartośćWPunkcie(0)==0){
            return arg1;
        }
        return this;
    }
}
