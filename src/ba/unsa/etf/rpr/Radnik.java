package ba.unsa.etf.rpr;

public class Radnik implements Comparable {
    private String imePrezime;
    private String jmbg;
    private double[] plate;
    private int brojPlata;

    public Radnik(String imePrezime, String jmbg) {
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
        this.plate = new double[1000];
        this.brojPlata = 0;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }


    public void dodajPlatu(double plata) {
        if(brojPlata==1000){
            throw new IllegalArgumentException("Ne možete registrovati više od 1000 plata za radnika "+imePrezime);
        }
        plate[brojPlata]=plata;
        brojPlata++;
    }


    public double prosjecnaPlata() {
        if(brojPlata!=0){
            double result=0;
            for(int i=0;i<brojPlata;i++){
                result+=plate[i];
            }
            result/=brojPlata;
            return result;
        }
        return 0;
    }


    @Override
    public int compareTo(Object o) {
        Radnik r = (Radnik)o;
        return Double.compare(r.prosjecnaPlata(), this.prosjecnaPlata());
    }
}
