import Controller.CharaktereController;
import Controller.ProdukteController;
import Repository.CharaktereRepository;
import Repository.ProdukteRepository;
import UI.UI;

/**
 * Main class of program
 */
public class Main {
    public static void main(String[] args) {
        CharaktereRepository charaktereRepository = new CharaktereRepository();
        ProdukteRepository produkteRepository = new ProdukteRepository();
        CharaktereController charaktereController = new CharaktereController(charaktereRepository);
        ProdukteController produkteController = new ProdukteController(produkteRepository);
        UI ui = new UI(produkteController, charaktereController);
        ui.menu();
    }
}
