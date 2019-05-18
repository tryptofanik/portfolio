package filtry;

public interface Filtr {
    public void otwórz_plik(String nazwa) throws BrakPliku;
    public String dajSłowo();
    public void zamknij_plik();
}