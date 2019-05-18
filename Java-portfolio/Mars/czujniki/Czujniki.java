package czujniki;

public interface Czujniki {

    int mierz() throws BłądCzujnika;

    int[] wczytaj(String nazwa) throws BrakPołączenia;

    String getNazwa();
}
