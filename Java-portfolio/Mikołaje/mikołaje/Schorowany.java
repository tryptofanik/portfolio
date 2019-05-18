package mikołaje;

public class Schorowany extends Mikołaj {

    private int ciężarOstatniego;


    public Schorowany(int ileMaks, int pojemność) {
        super(ileMaks, pojemność);
    }


    @Override
    public String toString() {
        return "Mikołaj{Schorowany, " +  worek + "}";
    }

    @Override
    public boolean czyBraćPrezent(Prezent prezent){ // bierze coraz lżejsze prezenty, tzn. pierwszy oferowany zawsze, ale kolejne tylko wtedy, gdy są lżejsze od poprzedniego,
        if (worek.getZapełnienie() == 0) { // czyli jest to pierwszy prezent
            return true;
        }
        if (prezent.getWaga() >= ciężarOstatniego){
            return false;
        }
        return (l_prez +1 <= ileMaks && worek.getZapełnienie() + prezent.getWielkość() <= pojemność);
    }

}
