package ba.unsa.etf.rpr;

public class RadnoMjesto {
    private String naziv;
    private double koeficijent;
    private Radnik radnik;

    public RadnoMjesto() {
        naziv = "";
        koeficijent=0;
        radnik=null;
    }

    public RadnoMjesto(String naziv, double koeficijent, Radnik radnik) {
        this.naziv = naziv;
        this.koeficijent = koeficijent;
        this.radnik = radnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(double koeficijent) {
        this.koeficijent = koeficijent;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadnoMjesto)) return false;

        RadnoMjesto that = (RadnoMjesto) o;

        if (Double.compare(that.getKoeficijent(), getKoeficijent()) != 0) return false;
        return getNaziv() != null ? getNaziv().equals(that.getNaziv()) : that.getNaziv() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getNaziv() != null ? getNaziv().hashCode() : 0;
        temp = Double.doubleToLongBits(getKoeficijent());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RadnoMjesto{" +
                "naziv='" + naziv + '\'' +
                ", koeficijent=" + koeficijent +" , Radnik= "+radnik+
                '}';
    }
}
