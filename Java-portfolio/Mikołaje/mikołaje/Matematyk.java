package mikołaje;

public class Matematyk extends Mikołaj {

    public Matematyk(int ileMaks, int pojemność) {
        super(ileMaks, pojemność);
    }


    @Override
    public String toString() {
        return "Mikołaj{Matematyk, " + worek + "}";
    }

    @Override
    public boolean czyBraćPrezent(Prezent prezent){ // bierze tylko takie prezenty, których kolejne atrybuty tworzą rosnący ciąg geometryczny
        return (l_prez +1 <= ileMaks && worek.getZapełnienie() + prezent.getWielkość() <= pojemność
                && czyTworzyCiągGeometryczny(prezent.getWielkość(), prezent.getWaga(),prezent.getCena()));
    }

    private boolean czyTworzyCiągGeometryczny(int a, int b, int c){
        if ((a*c)/(b*b) == 1)
            return true;
        return false;
    }

}