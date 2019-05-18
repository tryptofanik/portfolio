package mikołaje;

public class Wybredny extends Mikołaj {

    public Wybredny(int ileMaks, int pojemność) {
        super(ileMaks, pojemność);
    }


    @Override
    public String toString() {
        return "Mikołaj{Wybredny, " + worek + "}";
    }

    @Override
    public boolean czyBraćPrezent(Prezent prezent){ //bierze tylko te prezenty, które są lekkie (współczynnik wagi do wielkości jest mniejszy od 1)
        return (l_prez +1 <= ileMaks && worek.getZapełnienie() + prezent.getWielkość() <= pojemność && prezent.getWaga()/prezent.getWielkość() < 1);
    }

}
