package gwiazdka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mikołaje.*;

public class Main {

    public static void main(String[] args) {

        assert false: "Odkomentuj tę instrukcję";  // <---- Pierwsze uruchomienie programu nie powinno się powieść!!!

        Main m = new Main();

        System.out.println("*** Początek programu - wczytywanie danych ***\n");

        Dane dane = m.wczytajDane("dane0.txt");

        System.out.println("\n*** Po wczytaniu danych, dane = ***\n\n" + dane + "\n");

        m.rozdziel(dane);

        System.out.println("\n*** Mikołaje po podziale prezentów ***\n");
        for(Mikołaj mik: dane.mikołaje())
            System.out.println(mik);

        System.out.println("\n*** Koniec programu ***");
    }


    public static void przesuńKolejkę(Mikołaj[] mikołaje, int n) {
            // przesuwam cyklicznie o n pozycji w prawo

            for (int shift = 0; shift < n; shift++) {
                Mikołaj first = mikołaje[0];
                System.arraycopy( mikołaje, 1, mikołaje, 0, mikołaje.length - 1 );
                mikołaje[mikołaje.length - 1] = first;
            }
        }


        private void rozdziel(Dane dane) {

        Mikołaj[] mikołaje = dane.mikołaje();

        for (int nrPrezentu = 0; nrPrezentu < dane.prezenty().length; nrPrezentu++) {
            int ileSpytanych = 0;
            boolean czyZabrany = false;

            for (int nrMikołaja = 0; nrMikołaja < mikołaje.length; nrMikołaja++) {

                ileSpytanych++;

                if (mikołaje[nrMikołaja].czyBraćPrezent(dane.prezenty()[nrPrezentu])) {
                    mikołaje[nrMikołaja].zabierzPrezent(dane.prezenty()[nrPrezentu]);
                    czyZabrany = true;
                    break;
                }

            }
            if (czyZabrany == false) {
                System.out.println("Nikt nie wziął prezentu " + dane.prezenty()[nrPrezentu] + "\n");
            }
            przesuńKolejkę(mikołaje, ileSpytanych);
        }



    }


    Dane wczytajDane(String nazwa) {
        try {
            File file = new File(nazwa);
            Scanner dane = new Scanner(file);
            // Czytam prezenty, kończą się pustym wierszem

            ArrayList<Prezent> prezenty = new ArrayList<Prezent>();

            int nrWiersza = 0;
            int ileP = 0;
            String napis;
            while (dane.hasNextLine() && ((napis = dane.nextLine()).length() > 0)) {
                nrWiersza++;
                Scanner wiersz = new Scanner(napis);

                assert wiersz.hasNextInt() : "Brak wielkośći prezentu w wierszu: " + nrWiersza + ": " + wiersz;
                int wielkość = Integer.parseInt(wiersz.next());

                assert wiersz.hasNextInt() : "Brak wagi prezentu w wierszu: " + nrWiersza + ": " + wiersz;
                int waga = Integer.parseInt(wiersz.next());

                assert wiersz.hasNextInt() : "Brak ceny prezentu w wierszu: " + nrWiersza + ": " + wiersz;
                int cena = Integer.parseInt(wiersz.next());

                prezenty.add(new Prezent(wielkość, waga, cena));
            } // while

            ileP = nrWiersza;
            nrWiersza++; //Pusry wiersz

            System.out.println("Liczba wcztanych prezentów: " + ileP);

//             Czytam Mikołajów

            ArrayList<Mikołaj> mikołaje = new ArrayList<Mikołaj>();

            while (dane.hasNextLine()) {
                nrWiersza++;
                Scanner wiersz = new Scanner(dane.nextLine());

                assert wiersz.hasNext(".") : "Brak kodu Mikołaja w wierszu: " + nrWiersza + ": " + wiersz;
                String kod = wiersz.next();

                assert wiersz.hasNextInt() : "Brak maksymalnej liczby prezentów mieszczących się do worka w wierszu: " + nrWiersza + ": " + wiersz;
                int ileMaks = Integer.parseInt(wiersz.next());

                assert wiersz.hasNextInt() : "Brak pojemności worka w wierszu: " + nrWiersza + ": " + wiersz;
                int pojemność = Integer.parseInt(wiersz.next());

                switch (kod) {
                    case "P":
                        mikołaje.add(new Potulny(ileMaks, pojemność));
                        break;
                    case "O":
                        mikołaje.add(new Ostrożny(ileMaks, pojemność));
                        break;
                    case "S":
                        mikołaje.add(new Schorowany(ileMaks, pojemność));
                        break;
                    case "B":
                        mikołaje.add(new Skromny(ileMaks, pojemność));
                        break;
                    case "W":
                        mikołaje.add(new Wybredny(ileMaks, pojemność));
                        break;
                    case "M":
                        mikołaje.add(new Matematyk(ileMaks,pojemność));
                        break;


                    default:
                        assert false : "Niepoprawny kod Mikołaja w wierszu: " + nrWiersza + ": " + wiersz;
                }
            } // while

            int ileM = nrWiersza - ileP - 1;
            System.out.println("Liczba wczytanych Mikołajów: " + ileM);


            Prezent[] p = prezenty.toArray(new Prezent[0]);
            Mikołaj[] m = mikołaje.toArray(new Mikołaj[0]);

            return new Dane(prezenty.toArray(new Prezent[0]), mikołaje.toArray(new Mikołaj[0]));

        } catch (FileNotFoundException e) {
            System.out.println("Nie odczytano pliku");
            assert false : "Nie można otworzyć pliku: " + nazwa;
            return null; // Tylko dla spokoju ducha kompilatora, nigdy tu nie dojdziemy (przy -ea)
        }

    }
}