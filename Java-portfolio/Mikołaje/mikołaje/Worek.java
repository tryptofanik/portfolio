package mikołaje;

import java.util.*;

public class Worek {

    private int zapełnienie = 0; // jaka objętość została już wykorzystana ( mus być <= pojemność)
    private int pojemność;
    private int ileMaks;
    Prezent[] zawartość;
    private int l_prez = 0; // liczba prezentów (na sztuki) (musi być <= ileMaks)

    public Worek(int pojemność, int ileMaks) {
        this.pojemność = pojemność;
        this.ileMaks = ileMaks;
        this.zawartość = new Prezent[ileMaks];
    }

    @Override
    public String toString() {
        String wyn = "worek = Worek{pojemność=" + Integer.toString(pojemność) + ", l.prez.=" +
                Integer.toString(l_prez) + "/" + Integer.toString(ileMaks) + ", zawartość=(";
        for (int i = 0; i < zawartość.length; i++) {
            if (zawartość[i] != null) {
                wyn += zawartość[i] + ",";
            }
        }
        return wyn + ")}";
    }

    public void dodajZawartość(Prezent prezent) {
        zawartość[l_prez] = prezent;
        l_prez++;
        zapełnienie += prezent.getWielkość();

    }

    public int getZapełnienie() {
        return zapełnienie;
    }
}
