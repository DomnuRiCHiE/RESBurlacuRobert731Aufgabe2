package Repository;

import Model.Produkten;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProdukteRepository implements IRepository<Produkten, String> {
    private final List<Produkten> produkte;
    public ProdukteRepository(List<Produkten> produkte) {
        this.produkte = produkte;
    }

    public ProdukteRepository() {this.produkte = new ArrayList<>();}

    @Override
    public void add(Produkten entity) {
        produkte.add(entity);
    }

    @Override
    public void delete(String entity) {
        produkte.removeIf(medkament -> Objects.equals(medkament.getName(), entity));
    }

    @Override
    public void update(Produkten entity1, Produkten entity2) {
        if(produkte.remove(entity1)) {
            produkte.add(entity2);
        }
    }

    @Override
    public Produkten get(String entity) {
        for(Produkten p : produkte) {
            if(Objects.equals(p.getName(), entity)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produkten> getAll() {
        return produkte;
    }
}
