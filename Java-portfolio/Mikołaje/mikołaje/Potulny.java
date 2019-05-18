package mikołaje;

public class Potulny extends Mikołaj {

    public Potulny(int ileMaks, int pojemność) {
        super(ileMaks, pojemność);
    }


    @Override
    public String toString() {
        return "Mikołaj{Potulny, " + worek + "}";
    }

    @Override
    public boolean czyBraćPrezent(Prezent prezent){
        return (l_prez +1 <= ileMaks && worek.getZapełnienie() + prezent.getWielkość() <= pojemność);
    }

}
