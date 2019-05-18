package mikołaje;

abstract public class Mikołaj implements Mikołaje {


    protected int ileMaks;
    protected int pojemność;
    protected int l_prez = 0;
    protected Worek worek;

    public Mikołaj(int ileMaks, int pojemność) {
        this.ileMaks = ileMaks;
        this.pojemność = pojemność;
        this.worek = new Worek(pojemność, ileMaks);
    }


    public abstract boolean czyBraćPrezent(Prezent prezent);

    public void zabierzPrezent(Prezent prezent){
        this.worek.dodajZawartość(prezent);
    }

}