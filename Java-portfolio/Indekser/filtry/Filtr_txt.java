package filtry;

public class Filtr_txt extends FiltrAbstr {

    public Filtr_txt(String regex) {
        super(regex);
    }

    public String dajSłowo() {
        if (linia.size()==0){
            if (scan.hasNextLine()){
                for (String i: scan.nextLine().split(regex)){
                    linia.add(i);
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