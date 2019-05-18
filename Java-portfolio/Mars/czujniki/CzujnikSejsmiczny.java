package czujniki;

public class CzujnikSejsmiczny extends Czujnik {

    public CzujnikSejsmiczny(String nazwa) throws BrakPołączenia {
        super(nazwa);
    }

    @Override
    public int mierz() throws BłądCzujnika {
        int wyn = dane[k % dane.length];
        k++;
        if (wyn == -1) {
            throw new BłądOdczytu();
        }
        return wyn;
    }
}
