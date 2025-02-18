package UI;

import Controller.CharaktereController;
import Controller.ProdukteController;
import Model.Charakteren;
import Model.Produkten;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * User Interface class that interacts with the controllers of the program
 */
public class UI {
    private final Scanner scanner;
    private final CharaktereController charaktereController;
    private final ProdukteController produkteController;

    public UI(ProdukteController produkteController, CharaktereController charaktereController) {
        this.charaktereController = charaktereController;
        this.produkteController = produkteController;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Menu of the application
     */
    public void menu() {
        while (true) {
            System.out.println();
            System.out.println("1. Task 1");
            System.out.println("2. Task 2");
            System.out.println("3. Task 3");
            System.out.println("4. Task 4");
            System.out.println("5. Task 5");
            System.out.println("6. Exit");
            System.out.println("Choose: ");
            System.out.println();
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    menuCRUD();
                    switchCrudProdukte();
                    break;

                case "2":
                    menuCRUD();
                    switchCrudCharaktere();
                    break;

                case "3":
                    System.out.println();
                    System.out.println("Give a place: ");
                    String place = scanner.nextLine();
                    System.out.println();
                    //System.out.println(charaktereController.filterByX(place));
                    break;

                case "4":
                    System.out.println();
                    System.out.println("Give a place: ");
                    String place1 = scanner.nextLine();
                    System.out.println();
                    //System.out.println(charaktereController.aufgabe4(place1));
                    break;

                case "5":
                    System.out.println();
                    System.out.println("Choose a charakter id: ");
                    int input1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("1 - Ascending OR 2 - Descending");
                    int input2 = scanner.nextInt();
                    scanner.nextLine();
                    //System.out.println(charaktereController.aufgabe5(input1, input2));
                    break;

                case "6":
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void menuCRUD() {
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Read all");
        System.out.println("6. Exit");
        System.out.println("Choose: ");
    }

    public void switchCrudProdukte() {
        String input = scanner.nextLine();
        while (true) {
            String name, herkunftsregion;
            int preis;
            Produkten produkte;
            switch (input) {
                case "1":
                    System.out.println("Name: ");
                    name = scanner.nextLine();

                    System.out.println("Herkunftsregion: ");
                    herkunftsregion = scanner.nextLine();

                    System.out.println("Preis: ");
                    preis = scanner.nextInt();
                    scanner.nextLine();

                    produkteController.add(new Produkten(name, preis, herkunftsregion));
                    return;

                case "2":
                    System.out.println("Name: ");
                    name = scanner.nextLine();

                    produkte = produkteController.get(name);
                    if(produkte == null) {
                        System.out.println("Produkte not found");
                    }
                    else {
                        System.out.println(produkte);
                    }
                    return;

                case "3":
                    System.out.println("Name: ");
                    name = scanner.nextLine();

                    produkte = produkteController.get(name);
                    if(produkte == null) {
                        System.out.println("Produkte not found");
                    }
                    else {
                        System.out.println(produkte);
                        System.out.println();

                        System.out.println("New name: ");
                        String newName = scanner.nextLine();

                        System.out.println("New herkunftsregion: ");
                        String newHerkunftsregion = scanner.nextLine();

                        System.out.println("New preis: ");
                        int newPrice = scanner.nextInt();
                        scanner.nextLine();

                        produkteController.update(produkte, new Produkten(newName, newPrice, newHerkunftsregion));
                    }
                    return;

                case "4":
                    System.out.println("Name: ");
                    name = scanner.nextLine();

                    produkteController.delete(name);
                    return;

                case "5":
                    List<Produkten> produkteList = produkteController.getAll();
                    for(Produkten produkt : produkteList) {
                        System.out.println(produkt);
                    }

                case "6":
                    return;

                default:
                    System.out.println("Invalid option");
                    return;
            }
        }
    }

    public void switchCrudCharaktere() {
        String input = scanner.nextLine();
        while (true) {
            String name, herkunftsort;
            List<Produkten> produkteList;
            int id;
            Charakteren charaktere;

            switch (input) {
                case "1":
                    System.out.println("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Name: ");
                    name = scanner.nextLine();

                    System.out.println("Herkunftsort: ");
                    herkunftsort = scanner.nextLine();

                    produkteList = new ArrayList<>();

                    charaktereController.add(new Charakteren(id, name, herkunftsort, produkteList));
                    return;

                case "2":
                    System.out.println("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    charaktere = charaktereController.get(id);
                    if(charaktere == null) {
                        System.out.println("Charaktere not found");
                    }
                    else {
                        System.out.println(charaktere);
                    }
                    return;

                case "3":
                    System.out.println("Charaktere id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    charaktere = charaktereController.get(id);
                    if(charaktere == null) {
                        System.out.println("Charaktere not found");
                    }
                    else {
                        System.out.println(charaktere);
                        System.out.println();

                        System.out.println("New Id: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("New Name: ");
                        String newName = scanner.nextLine();

                        System.out.println("New Herkunftsort: ");
                        String newHerkunftsort = scanner.nextLine();

                        produkteList = new ArrayList<>();
                        System.out.println("Select produkte with their name: (to finish selection enter a space in prompt)");
                        System.out.println();

                        List<Produkten> allProdukte = produkteController.getAll();
                        for(Produkten produkte : allProdukte) {
                            System.out.println(produkte);
                        }
                        System.out.println();

                        String inputParameter = "";
                        while (!Objects.equals(inputParameter, " ")) {
                            inputParameter = scanner.nextLine();
                            Produkten searchedProdukte = produkteController.get(inputParameter);
                            if(searchedProdukte == null) {
                                System.out.println("Produkte not found");
                            }
                            else {
                                produkteList.add(searchedProdukte);
                                System.out.println("Produkte added to charaktere list");
                            }
                        }
                        charaktereController.update(charaktere, new Charakteren(newId, newName, newHerkunftsort, produkteList));
                    }
                    return;

                case "4":
                    System.out.println("Charaktere id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    charaktereController.delete(id);
                    return;

                case "5":
                    List<Charakteren> charaktereList = charaktereController.getAll();
                    for(Charakteren charaktere1 : charaktereList) {
                        System.out.println(charaktere1);
                    }
                    return;

                case "6":
                    return;

                default:
                    System.out.println("Invalid option");
                    return;
            }
        }
    }
}
