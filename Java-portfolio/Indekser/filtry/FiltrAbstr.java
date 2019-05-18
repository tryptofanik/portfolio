package filtry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class FiltrAbstr implements Filtr{

    String regex;
    Scanner scan;
    ArrayList<String> linia = new ArrayList<>();


    public FiltrAbstr(String regex) {
        this.regex = regex;
    }

    abstract public String dajSłowo();

    public void otwórz_plik(String nazwa) throws BrakPliku{
        try {
            File file = new File(nazwa);
            scan = new Scanner(file, "UTF-8");
            scan.useDelimiter(regex);
        } catch (FileNotFoundException e){
            throw new BrakPliku();
        }
    }

    @Override
    public void zamknij_plik(){
        scan.close();
    }
}
