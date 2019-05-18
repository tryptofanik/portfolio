package czujniki;

import czujniki.*;

public class Sonda {

    private Czujnik[] czujniki;

    public Sonda(Czujnik[] czujniki) {
        this.czujniki = czujniki;
    }


    public void działaj(int ile){

        for (int i = 0; i<ile; i++){
            System.out.print(i + ": " );
            for (int j=0; j<czujniki.length; j++){
                try {
                    System.out.print(czujniki[j].getNazwa() + ": ");
                    System.out.print(czujniki[j].mierz() + ", ");
                }
                catch (BłądOdczytu o){
                    System.out.print("B_Odcz"+ ", ");
                }
                catch (BłądZakresu z){
                    System.out.print("B_Zakr"+ ", ");
                }
                catch (BłądCzujnika c){
                    System.out.println("B_Czuj" + ", ");
                }
            }
            System.out.print("\n");
        }
    }
}
