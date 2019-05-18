package indekser;

import filtry.BrakPliku;
import filtry.Filtr;

import java.util.*;

public class Indekser extends IndekserAbstr{


    // słownik w którym kluczem jest ścieżka tekstu, a wartością zbiór słów w danym tekście
    private Map<String, HashSet<String>> map = new HashMap<>();

    public void wczytajDane(String ścieżka, Filtr filtr) throws BrakPliku {
        // najpierw otwieram zadany plik
        filtr.otwórz_plik(ścieżka);

        // dodaje nazwę pliku do listy
        jakieŻródła.add(ścieżka);

        // tworzę zbiór do którego następnie po kolei dodaje kolejne słowa pobierane z filtru
        HashSet<String> set = new HashSet<>();
        int line = 0;
        while (true) {
            String s = filtr.dajSłowo();
            if (s == null) {
                break;
            }
            if (s.equals("\n")){
                continue;
            }
            set.add(s.replace("\n", ""));
        }

        // nazwę ścieżki i zbiór dodaje do słownika
        map.put(ścieżka, set);

        // zamykam plik
        filtr.zamknij_plik();
    }

    public int wIluPlikach(String słowo) {
        int i = 0;
        // dla każdego zbioru w wartościach sprawdzam czy występuje w nim zadane słowo
        for (Set set : map.values()) {
            if (set.contains(słowo)) {
                i++;
            }
        }
        return i;
    }

    public String dajPlikiZeSłowem(String słowo) {
        List<String> pliki = new ArrayList<>();
        // dla każdej pary elementów słownika sprawdzam czy w zbiorze znajduje się zadane słowo,
        // jeśli tak to dopisuje klucz (ścieżkę tekstu do listy)
        for (Map.Entry<String, HashSet<String>> pair : map.entrySet()) {
            if (pair.getValue().contains(słowo))
                pliki.add(pair.getKey());
        }
        return pliki.toString();
    }

    public String dajPlikiZeSłowami(List<String> słowa) {
        List<String> pliki = new ArrayList<>();
        // to samo co poprzednio tyle że dla listy słów
        for (Map.Entry<String, HashSet<String>> pair : map.entrySet()) {
            if (pair.getValue().containsAll(słowa))
                pliki.add(pair.getKey());
        }
        return pliki.toString();
    }

    public ArrayList<String> jakieŻródła() {
        return jakieŻródła;
    }

    public int ileSłów() {
        // sumuje wszystkie zbiory do jednego zbioru, a potem zwracam jego długość
        for (Set set : map.values()) {
            wszystkieSłowa.addAll(set);
        }
        return wszystkieSłowa.size();
    }


}