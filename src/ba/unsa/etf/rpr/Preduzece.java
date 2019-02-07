package ba.unsa.etf.rpr;

import java.util.*;
import java.util.function.Function;

public class Preduzece {
    private int osnovica;
    private ArrayList<RadnoMjesto> radnaMjesta;

    public Preduzece(int osnovica) {
        String mes = ("Neispravna osnovica "+osnovica);
        if(osnovica<1)throw new NeispravnaOsnovica( mes);
        this.osnovica = osnovica;
        this.radnaMjesta = new ArrayList<>();
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
        radnaMjesta.add(radnoMjesto);
    }

    public Map<RadnoMjesto, Integer> sistematizacija() {
        Map<RadnoMjesto,Integer> result = new HashMap<>();
        for(RadnoMjesto element:radnaMjesta){
            if (!result.containsKey(element)) {
                result.put(element,0);
            }
        }
        for(Map.Entry<RadnoMjesto,Integer> element : result.entrySet()){
            for(RadnoMjesto radnoMjesto : radnaMjesta){
                if(element.getKey().equals(radnoMjesto)){
                    element.setValue(element.getValue()+1);
                }
            }
        }
        return result;
    }

    public void zaposli(Radnik radnik, String pozicija) {
        boolean zaposlen = false;
        for(RadnoMjesto element : radnaMjesta){
            if(element.getNaziv().equals(pozicija)){
                if(element.getRadnik() == null){
                    element.setRadnik(radnik);
                    zaposlen = true;
                    break;
                }
            }
        }
        if(!zaposlen){
            throw new IllegalStateException("Nijedno radno mjesto tog tipa nije slobodno");
        }
    }

    public Set<Radnik> radnici() {
        Set<Radnik> result = new TreeSet<>();
        for(RadnoMjesto element : radnaMjesta){
            if(element.getRadnik()!=null) {
                result.add(element.getRadnik());
            }
        }
        return result;
    }

    public double iznosPlate() {
        double result=0;
        for(RadnoMjesto element:radnaMjesta){
            if (element.getRadnik() != null) {
                result+=osnovica*element.getKoeficijent();
            }
        }
        return result;
    }

    public void obracunajPlatu() {
        for(RadnoMjesto element:radnaMjesta){
            if (element.getRadnik() != null) {
                element.getRadnik().dodajPlatu(osnovica*element.getKoeficijent());
            }
        }
    }

    public List<Radnik> filterRadnici(Function<Radnik,Boolean> function) {
        return null;
    }

    public List<Radnik> vecaProsjecnaPlata(double referentna) {
        return null;
    }
}
