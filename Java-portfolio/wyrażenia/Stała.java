package wyrażenia;

public class Stała extends Wyrażenie{

    private double wartość;

    public Stała(double w){
        this.wartość = w;
    }

    public double wartośćWPunkcie(double x){
        return wartość;
    }

    @Override
    public double całkaOznaczona(double a, double b){
        return (b-a)*wartość;
    }

    @Override
    public String toString(){
        return Double.toString(wartość);
    }


    @Override
    public Wyrażenie pochodna(){
        return new Stała(0);
    }


}
