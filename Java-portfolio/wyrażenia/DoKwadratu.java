package wyrażenia;

public class DoKwadratu extends WyrażenieJednoarg{


    public DoKwadratu(Wyrażenie arg) {
        super(arg);
    }

    @Override
    public String toString() {
        return  "(" + arg + ")^2" ;
    }


    @Override
    public double wartośćWPunkcie(double x) {
        return arg.wartośćWPunkcie(x)*arg.wartośćWPunkcie(x);
    }

    @Override
    public Wyrażenie pochodna() {
        return new Mnożenie(new Stała(2), arg);
    }
}
