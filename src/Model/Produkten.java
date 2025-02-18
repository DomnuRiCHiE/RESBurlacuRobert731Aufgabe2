package Model;

public class Produkten {
    private String name;
    private double preis;
    private String herkunftsregion;

    public Produkten(String name, double preis, String herkunftsregion) {
        this.name = name;
        this.preis = preis;
        this.herkunftsregion = herkunftsregion;
    }

    public Produkten() {
        this.name = null;
        this.preis = 0;
        this.herkunftsregion = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "Produkte{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", herkunftsregion='" + herkunftsregion + '\'' +
                '}';
    }
}
