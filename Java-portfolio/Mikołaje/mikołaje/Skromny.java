package mikołaje;

public class Skromny extends Mikołaj {

    public Skromny(int ileMaks, int pojemność) {
        super(ileMaks, pojemność);
    }


    @Override
    public String toString() {
        return "Mikołaj{Potulny, " + worek + "}";
    }

    @Override
    public boolean czyBraćPrezent(Prezent prezent){ //bierze tylko prezenty ze złota (można je poznać po tym, że ich współczynnik cena/wielkość jest większy od 10)
        return (l_prez +1 <= ileMaks && worek.getZapełnienie() + prezent.getWielkość() <= pojemność && prezent.getCena()/prezent.getWielkość() > 10);
    }



}
