package Model;

import java.util.ArrayList;
import java.util.List;

public class Charakteren {
    private int id;
    private String name;
    private String herkunftsdorf;
    private List<Produkten> produkte;

    public Charakteren(int id, String name, String herkunftsdorf, List<Produkten> produkte) {
        this.id = id;
        this.name = name;
        this.herkunftsdorf = herkunftsdorf;
        this.produkte = produkte;
    }

    public Charakteren(int id, String name, String herkunftsdorf) {
        this.id = id;
        this.name = name;
        this.herkunftsdorf = herkunftsdorf;
        this.produkte = new ArrayList<>();
    }

    public Charakteren() {
        this.id = 0;
        this.name = null;
        this.herkunftsdorf = null;
        this.produkte = new ArrayList<>();
    }

    public void kaufeProdukt(Produkten produkten) {
        this.produkte.add(produkten);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsdorf() {
        return herkunftsdorf;
    }

    public void setHerkunftsdorf(String herkunftsdorf) {
        this.herkunftsdorf = herkunftsdorf;
    }

    public List<Produkten> getProdukte() {
        return produkte;
    }

    public void setProdukte(List<Produkten> produkte) {
        this.produkte = produkte;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", herkunftsort='" + herkunftsdorf + '\'' +
                ", produkte=" + produkte +
                '}';
    }
}
