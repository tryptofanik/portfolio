package mikołaje;

public class Prezent {

    private int wielkość;
    private int waga;
    private int cena;

    public Prezent(int wielkość, int waga, int cena) {
        this.wielkość = wielkość;
        this.waga = waga;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Prezent{" +
                "wielkość=" + wielkość +
                ", waga=" + waga +
                ", cena=" + cena +
                '}';
    }

    public int getWielkość() {
        return wielkość;
    }

    public int getWaga() {
        return waga;
    }

    public int getCena() {
        return cena;
    }
}
