package gwiazdka;

import mikołaje.*;

import java.util.Arrays;

public class Dane {

    private Mikołaj[] mikołaje;
    private Prezent[] prezenty;


    public Dane(Prezent[] p, Mikołaj[] m) {
        this.mikołaje = m;
        this.prezenty = p;
    }

    @Override
    public String toString() {
        return "Dane{" + "\n" +
                "prezenty = " + Arrays.toString(prezenty) + "\n" +
                "mikołaje = " + Arrays.toString(mikołaje) +
                '}';
    }

    public Mikołaj[] mikołaje() {
        return mikołaje;
    }

    public Prezent[] prezenty() {
        return prezenty;
    }
}