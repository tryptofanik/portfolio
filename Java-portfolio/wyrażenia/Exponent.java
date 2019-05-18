package wyrażenia;

public class Exponent extends WyrażenieJednoarg {

    public Exponent(Wyrażenie arg) {
        super(arg);
    }

    @Override
    public String toString() {
        return "Exp("  + arg + ')';
    }

    @Override
    public double wartośćWPunkcie(double x){
        return Math.exp(x);
    }

    @Override
    public Wyrażenie pochodna(){
        return new Exponent(arg);
    }
}
