package mikołaje;

public class Ostrożny extends Mikołaj{

    public Ostrożny(int ileMaks, int pojemność) {
        super(ileMaks, pojemność);
    }


    @Override
    public String toString() {
        return "Mikołaj{Ostrożny, " + worek + "}";
    }

    public boolean czyBraćPrezent(Prezent prezent){ //  bierze prezenty dopóki ich objętość nie przekracza połowy pojemności worka
        return (l_prez +1 <= ileMaks && worek.getZapełnienie() + prezent.getWielkość() <= pojemność/2);
    }


}
