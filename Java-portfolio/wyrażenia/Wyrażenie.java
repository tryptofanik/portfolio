package wyrażenia;

abstract class Wyrażenie {

    private int intervals = 1000;
    private int maxd = 1;

    @Override
    public abstract String toString();

    public abstract double wartośćWPunkcie(double x);

    public abstract Wyrażenie pochodna();

//    public abstract Wyrażenie uprość();

    public double całkaOznaczona(double a, double b){
        double d = (b-a)/intervals;
        while (d > maxd) {
            d /= 2;
        }
        double całka = 0.5 * (this.wartośćWPunkcie(a)+this.wartośćWPunkcie(b)) * d;

        for (double x = a+d; x < b; x+=d ){
            całka += this.wartośćWPunkcie(x)*d;
        }
        return całka;
    }


}
