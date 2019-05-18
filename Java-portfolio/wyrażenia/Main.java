package wyrażenia;

public class Main {

    public static void main(String[] args){
//        Wyrażenie x = new Stała(5);
//
//        Wyrażenie g = new Zmienna("x");
//
//
//        Wyrażenie xx = new Dzielenie(x,new DoKwadratu (new Zmienna("x")));
//
//        System.out.println(xx);
//        System.out.println(xx.pochodna());
//
//
//        System.out.println(xx.pochodna().wartośćWPunkcie(1));

//        System.out.println(xx.pochodna());

        Wyrażenie c = new Dodawanie(new Stała(0), new Stała(1));

        System.out.println(c);
        System.out.println(((Dodawanie) c).uprość());


        Wyrażenie d = new Odejmowanie(new Stała(10), new Stała(0));

        System.out.println(d);
        System.out.println(((Odejmowanie) d).uprość());

        Wyrażenie m = new Mnożenie(new Stała(1), new Mnożenie(new Zmienna("x"), new Stała(4)));
        System.out.println(m);
        System.out.println(((Mnożenie) m).uprość());


        Wyrażenie dz = new Dzielenie(new Stała(4), new Stała(8));

        System.out.println(dz);
        System.out.println(((Dzielenie) dz).uprość());

    }
}
