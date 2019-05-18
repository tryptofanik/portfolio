package czujniki;

public class CzujnikTemperatury extends Czujnik {

    public CzujnikTemperatury(String nazwa) throws BrakPołączenia {
        super(nazwa);

    }

    @Override
    public int mierz() throws BłądCzujnika {
        int wyn = dane[k % dane.length];
        k++;
        if (wyn < -160 || wyn > 40) {
            throw new BłądZakresu();
        }
        return wyn;
    }
}
