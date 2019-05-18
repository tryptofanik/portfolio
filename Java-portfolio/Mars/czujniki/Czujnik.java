package czujniki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract public class Czujnik implements Czujniki {

    String nazwa;
    int[] dane;
    int k = 0;

    public Czujnik(String nazwa) throws BrakPołączenia {
        this.nazwa = nazwa;
        dane = wczytaj(nazwa + ".txt");
    }


    abstract public int mierz() throws BłądCzujnika;


    public int[] wczytaj(String nazwa) throws BrakPołączenia {
        Scanner plik;
        try {
            // Wczytanie danych z pliku
            plik = new Scanner(new File(nazwa), "UTF-8");
            List<Integer> danePom = new ArrayList<>();
            while (plik.hasNextInt()) {
                danePom.add(plik.nextInt());
            }
            plik.close();

            // Zamiana na tablicę
            int[] wyn = new int[danePom.size()];
            for (int i = 0; i < danePom.size(); i++)
                wyn[i] = danePom.get(i);

            // Przekazanie wyniku
            return wyn;
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku <" + nazwa + ">");
            throw new BrakPołączenia();
        }
    }

    public String getNazwa() {
        return nazwa;
    }
}
