package indekser;

import filtry.BrakPliku;
import filtry.Filtr;

import java.util.*;

public class IndekserLinie extends Indekser {

    private Map<String, HashMap<Integer, HashSet<String>>> linemap = new HashMap<>();

    public IndekserLinie() {
        super();
    }

    @Override
    public void wczytajDane(String ścieżka, Filtr filtr) throws BrakPliku {
        // najpierw otwieram zadany plik
        filtr.otwórz_plik(ścieżka);

        // dodaje nazwę pliku do listy
        jakieŻródła.add(ścieżka);

        HashSet<String> lineset = new HashSet<>();
        HashMap<Integer, HashSet<String>> allLines = new HashMap<>();
        int line = 0;
        while (true) {
            String s = filtr.dajSłowo();
            if (s == null) {
                break;
            }
            else if (s.equals("\n")){
                line++;
            }
            else if (s.contains("\n")) {
                lineset.add(s.replace("\n", ""));
                allLines.put(line, new HashSet<>(lineset));
                line++;
                lineset.clear();
            } else if(!s.equals("")) {
                lineset.add(s.replace("\n", ""));
            }
        }

        linemap.put(ścieżka, allLines);

        // zamykam plik
        filtr.zamknij_plik();
    }

    public ArrayList<Integer> wKtórejLinii(String plik, String słowo) {
        ArrayList<Integer> lines = new ArrayList<>();
        for (Map.Entry<String, HashMap<Integer, HashSet<String>>> pair : linemap.entrySet()) {
            if (pair.getKey().equals(plik)){
                for (Map.Entry<Integer, HashSet<String>> line: pair.getValue().entrySet()){
                    if (line.getValue().contains(słowo)){
                        lines.add(line.getKey());
                    }
                }
            }
        }

        return lines;
    }

    @Override
    public int wIluPlikach(String słowo) {
        int i=0;
        for (Map.Entry<String, HashMap<Integer, HashSet<String>>> plik: linemap.entrySet()){
            for (Map.Entry<Integer, HashSet<String>> lines: plik.getValue().entrySet()){
                if (lines.getValue().contains(słowo)){
                    i++;
                    break;
                }
            }
        }
        return i;
    }

    @Override
    public String dajPlikiZeSłowem(String słowo) {
        ArrayList<String> lista = new ArrayList<>();
        for (Map.Entry<String, HashMap<Integer, HashSet<String>>> plik: linemap.entrySet()){
            for (Map.Entry<Integer, HashSet<String>> lines: plik.getValue().entrySet()){
                if (lines.getValue().contains(słowo)){
                    lista.add(plik.getKey());
                    break;
                }
            }
        }
        return lista.toString();
    }

    @Override
    public String dajPlikiZeSłowami(List<String> słowa) {
        ArrayList<String> lista = new ArrayList<>();
        for (Map.Entry<String, HashMap<Integer, HashSet<String>>> plik: linemap.entrySet()){
            for (Map.Entry<Integer, HashSet<String>> lines: plik.getValue().entrySet()){
                if (lines.getValue().containsAll(słowa)){
                    lista.add(plik.getKey());
                    break;
                }
            }
        }
        return lista.toString();
    }

    @Override
    public int ileSłów() {
        int i = 0;
        for (Map.Entry<String, HashMap<Integer, HashSet<String>>> plik: linemap.entrySet()){
            for (Map.Entry<Integer, HashSet<String>> lines: plik.getValue().entrySet()){
                wszystkieSłowa.addAll(lines.getValue());
            }
        }
        return wszystkieSłowa.size();
    }
}
