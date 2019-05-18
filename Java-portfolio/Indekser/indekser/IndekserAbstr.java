package indekser;

import filtry.BrakPliku;
import filtry.Filtr;

import java.util.*;

abstract public class IndekserAbstr {

    ArrayList<String> jakieŻródła;
    HashSet<String> wszystkieSłowa;

    IndekserAbstr() {
        jakieŻródła = new ArrayList<>();
        wszystkieSłowa = new HashSet<>();
    }

    abstract public void wczytajDane(String ścieżka, Filtr filtr) throws BrakPliku;

    abstract public int wIluPlikach(String słowo);

    abstract public String dajPlikiZeSłowem(String słowo);

    abstract public String dajPlikiZeSłowami(List<String> słowa);

    public ArrayList<String> jakieŻródła() {
        return jakieŻródła;
    }

    abstract public int ileSłów();

}
