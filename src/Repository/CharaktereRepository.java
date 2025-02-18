package Repository;

import Model.Charakteren;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharaktereRepository implements IRepository<Charakteren, Integer> {
    private final List<Charakteren> charaktere;

    public CharaktereRepository(List<Charakteren> charaktere) {
        this.charaktere = charaktere;
    }

    public CharaktereRepository() {
        this.charaktere = new ArrayList<>();
    }

    @Override
    public void add(Charakteren entity) {
        charaktere.add(entity);
    }

    @Override
    public void delete(Integer entity) {
        charaktere.removeIf(charakter -> Objects.equals(charakter.getId(), entity));
    }

    @Override
    public void update(Charakteren entity1, Charakteren entity2) {
        if(charaktere.remove(entity1)) {
            charaktere.add(entity2);
        }
    }

    public Charakteren getCharaktere(String id) {
        for(Charakteren charakter : charaktere) {
            if(Objects.equals(charakter.getName(), id)) {
                return charakter;
            }
        }
        return null;
    }

    @Override
    public Charakteren get(Integer entity) {
        for(Charakteren charakter : charaktere) {
            if(Objects.equals(charakter.getId(), entity)) {
                return charakter;
            }
        }
        return null;
    }

    @Override
    public List<Charakteren> getAll() {
        return charaktere;
    }
}
