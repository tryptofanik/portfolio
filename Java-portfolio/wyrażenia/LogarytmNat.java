package wyrażenia;

public class LogarytmNat extends WyrażenieJednoarg {

    public LogarytmNat(Wyrażenie arg) {
        super(arg);
    }

    @Override
    public String toString() {
        return "Ln(" + arg + ")";
    }

    @Override
    public double wartośćWPunkcie(double x){
        return Math.log(x);
    }

    @Override
    public Wyrażenie pochodna(){
        return new Dzielenie(new Stała(1), arg);
    }

}
