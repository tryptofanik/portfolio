package wyrażenia;

public class Zmienna extends Wyrażenie{

    private String wartość;

    public Zmienna(String x){
        this.wartość = x;
    }

    public double wartośćWPunkcie(double x){
        return x;
    }

    @Override
    public String toString(){
        return wartość;
    }


    @Override
    public Wyrażenie pochodna(){
        return new Stała(1);
    }


}
