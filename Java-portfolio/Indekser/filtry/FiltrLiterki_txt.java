package filtry;

import java.util.Locale;

public class FiltrLiterki_txt extends FiltrAbstr {

    public FiltrLiterki_txt(String regex) {
        super(regex);
    }

    public String dajSłowo() {
        if (linia.size()==0){
            if (scan.hasNextLine()){
                for (String i: scan.nextLine().split(regex)){
                    linia.add(i.toLowerCase(Locale.forLanguageTag("PL")));
                }
            }else{
                return null;
            }
        }

        if (linia.size()==1){
            String pom = linia.get(0);
            linia.remove(0);
            return pom + "\n";
        }
        else if (linia.size() > 1) {
            String pom = linia.get(0);
            linia.remove(0);
            return pom;
        }
        return "";
    }
}