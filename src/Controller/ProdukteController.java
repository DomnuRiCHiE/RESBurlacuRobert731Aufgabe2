package Controller;

import Model.Produkten;
import Repository.ProdukteRepository;

import java.util.List;

public class ProdukteController implements IController<Produkten, String> {
    private final ProdukteRepository produkteRepository;

    public ProdukteController(ProdukteRepository produkteRepository) {
        this.produkteRepository = produkteRepository;
    }

    @Override
    public void add(Produkten entity) {
        produkteRepository.add(entity);
    }

    @Override
    public void delete(String entity) {
        produkteRepository.delete(entity);
    }

    @Override
    public void update(Produkten entity1, Produkten entity2) {
        produkteRepository.update(entity1, entity2);
    }

    @Override
    public Produkten get(String entity) {
        return produkteRepository.get(entity);
    }

    @Override
    public List<Produkten> getAll() {
        return produkteRepository.getAll();
    }
}
