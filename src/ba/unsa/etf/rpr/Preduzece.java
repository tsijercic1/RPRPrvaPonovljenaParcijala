package ba.unsa.etf.rpr;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Preduzece {
    private int osnovica;


    public Preduzece(int osnovica) {
        this.osnovica = osnovica;
    }


    public int dajOsnovicu() {
        return osnovica;
    }

    public void postaviOsnovicu(int osnovica) {
        String mes = ("Neispravna osnovica "+osnovica);
        if(osnovica<1)throw new NeispravnaOsnovica( mes);
        this.osnovica=osnovica;
    }

    public void novoRadnoMjesto(RadnoMjesto radnoMjesto) {


    }

    public Map<RadnoMjesto, Integer> sistematizacija() {
        return null;
    }

    public void zaposli(Radnik radnik, String pozicija) {

    }

    public Set<Radnik> radnici() {
        return null;
    }

    public double iznosPlate() {
        return 0;
    }

    public void obracunajPlatu() {

    }

    public List<Radnik> filterRadnici(Function<Radnik,Boolean> function) {
        return null;
    }

    public List<Radnik> vecaProsjecnaPlata(double referentna) {
        return null;
    }
}
