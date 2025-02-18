package Controller;

import Model.Charakteren;
import Model.Produkten;
import Repository.CharaktereRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CharaktereController implements IController<Charakteren, Integer> {
    private final CharaktereRepository charaktereRepository;

    public CharaktereController(CharaktereRepository charaktereRepository) {
        this.charaktereRepository = charaktereRepository;
    }

    public List<Charakteren> filterByX(String x) {
        return getAll().stream()
                .filter(charaktere -> Objects.equals(charaktere.getHerkunftsdorf(), x))
                .toList();
    }

//    public List<Charakteren> aufgabe4(String x) {
//        return getAll().stream()
//                .filter(charaktere -> charaktere.getProdukte().stream()
//                        .anyMatch(produkte -> Objects.equals(produkte.getHerkunftsregion(), x)))
//                .toList();
//    }

//    public List<Produkten> aufgabe5(int id, int sort) {
//        Charakteren selectedCharaktere = charaktereRepository.get(id);
//
//        List<Produkten> produkte = selectedCharaktere.getProdukte();
//        if(sort == 1) {
//            produkte.sort(Comparator.comparingInt(Produkten::getPreis));
//        } else {
//            produkte.sort((p1, p2) -> Integer.compare(p2.getPreis(), p1.getPreis()));
//        }
//        return produkte;
//    }

    @Override
    public void add(Charakteren entity) {
        charaktereRepository.add(entity);
    }

    @Override
    public void delete(Integer entity) {
        charaktereRepository.delete(entity);
    }

    @Override
    public void update(Charakteren entity1, Charakteren entity2) {
        charaktereRepository.update(entity1, entity2);
    }

    @Override
    public Charakteren get(Integer entity) {
        return charaktereRepository.get(entity);
    }

    @Override
    public List<Charakteren> getAll() {
        return charaktereRepository.getAll();
    }
}
