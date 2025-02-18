import Controller.CharaktereController;
import Controller.ProdukteController;
import Model.Charakteren;
import Model.Produkten;
import Repository.CharaktereRepository;
import Repository.ProdukteRepository;
import UI.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class of program
 */
public class Main {
    public static void main(String[] args) {
        CharaktereRepository charaktereRepository = new CharaktereRepository();
        ProdukteRepository produkteRepository = new ProdukteRepository();
        CharaktereController charaktereController = new CharaktereController(charaktereRepository);
        ProdukteController produkteController = new ProdukteController(produkteRepository);

        List<Produkten> produkte = new ArrayList<>();
        produkte.add(new Produkten("Kunai", 50.0, "Konoha"));
        produkte.add(new Produkten("Shuriken", 30.0, "Konoha"));
        produkte.add(new Produkten("Schwert", 200.0, "Kirigakure"));
        produkte.add(new Produkten("Heiltrank", 100.0, "Sunagakure"));
        produkte.add(new Produkten("Sprengsiegel", 75.0, "Iwagakure"));
        produkte.add(new Produkten("Riesenfächer", 300.0, "Sunagakure"));
        produkte.add(new Produkten("Giftklinge", 150.0, "Kirigakure"));
        produkte.add(new Produkten("Explosionskugel", 250.0, "Iwagakure"));
        produkte.add(new Produkten("Schattendolch", 180.0, "Konoha"));
        produkte.add(new Produkten("Wasserperle", 90.0, "Kirigakure"));

        // Initialisierung der Charaktere
        List<Charakteren> charaktere = new ArrayList<>();

        Charakteren c1 = new Charakteren(1, "Naruto Uzumaki", "Konoha");
        c1.kaufeProdukt(produkte.get(0)); // Kunai
        c1.kaufeProdukt(produkte.get(3)); // Heiltrank
        c1.kaufeProdukt(produkte.get(8)); // Schattendolch
        c1.kaufeProdukt(produkte.get(5)); // Riesenfächer

        Charakteren c2 = new Charakteren(2, "Gaara", "Sunagakure");
        c2.kaufeProdukt(produkte.get(2)); // Schwert
        c2.kaufeProdukt(produkte.get(4)); // Sprengsiegel
        c2.kaufeProdukt(produkte.get(6)); // Giftklinge
        c2.kaufeProdukt(produkte.get(1)); // Shuriken

        Charakteren c3 = new Charakteren(3, "Kisame Hoshigaki", "Kirigakure");
        c3.kaufeProdukt(produkte.get(1)); // Shuriken
        c3.kaufeProdukt(produkte.get(2)); // Schwert
        c3.kaufeProdukt(produkte.get(3)); // Heiltrank
        c3.kaufeProdukt(produkte.get(7)); // Explosionskugel
        c3.kaufeProdukt(produkte.get(9)); // Wasserperle

        Charakteren c4 = new Charakteren(4, "Deidara", "Iwagakure");
        c4.kaufeProdukt(produkte.get(0)); // Kunai
        c4.kaufeProdukt(produkte.get(4)); // Sprengsiegel
        c4.kaufeProdukt(produkte.get(7)); // Explosionskugel
        c4.kaufeProdukt(produkte.get(9)); // Wasserperle

        Charakteren c5 = new Charakteren(5, "Itachi Uchiha", "Konoha");
        c5.kaufeProdukt(produkte.get(8)); // Schattendolch
        c5.kaufeProdukt(produkte.get(6)); // Giftklinge
        c5.kaufeProdukt(produkte.get(2)); // Schwert
        c5.kaufeProdukt(produkte.get(7)); // Explosionskugel

        charaktere.add(c1);
        charaktere.add(c2);
        charaktere.add(c3);
        charaktere.add(c4);
        charaktere.add(c5);

        for(Charakteren charakter : charaktere) {
            charaktereRepository.add(charakter);
        }

        for(Produkten produkten : produkte) {
            produkteRepository.add(produkten);
        }

        UI ui = new UI(produkteController, charaktereController);
        ui.menu();
    }
}
