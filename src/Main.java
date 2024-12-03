import java.util.Scanner;
import entity.*;
import controller.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int choice1;
        int choice2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1)Sport \n 2)Atleta \n 3) Exit");
            System.out.println("Inserisci la tua scelta");
            choice1 = scanner.nextInt();
            scanner.nextLine();
            if (choice1 == 1) {
                System.out.println("Classe Sport");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo SPORT");
                System.out.println("2. Aggiorna unO SPORT");
                System.out.println("3. Visualizza la lista degli sport");
                System.out.println("4. Elimina uno sport");
                System.out.println("5. Visualizza gli sport di squadra");
                System.out.println("6. Visualizza gli sport e il numero degli atleti che lo praticano");
                System.out.println("7. Visualizza gli sport che hanno almeno due atleti che lo praticano");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                SportController sportController = new SportController();
                switch (choice2) {
                    case 1:
                        sportController.createSport();
                        break;
                    case 2:
                        sportController.updateSport();
                        break;
                    case 3:
                        sportController.readSport();
                        break;
                    case 4:
                        sportController.deleteSport();
                        break;
                    case 5:
                        sportController.readSportSquadra();
                        break;
                    case 6:
                        sportController.readSportNatleti();
                        break;
                    case 7:
                        sportController.readSport2Atleti();
                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            } else if (choice1 == 2) {
                System.out.println("Classe Atleta");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo ATLETA");
                System.out.println("2. Aggiorna un ATLETA");
                System.out.println("3. Visualizza la lista degli ATLETI ");
                System.out.println("4. Elimina un ATLETA");
                System.out.println("5. Visualizza gli ATLETI che giocano a tennis nati a partire dal 2000");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                AtletaController atletaController = new AtletaController();
                switch (choice2) {
                    case 1:
                        atletaController.creatAtleta();
                        break;
                    case 2:
                        atletaController.updateAtleta();
                        break;
                    case 3:
                        atletaController.readAtleta();
                        break;
                    case 4:
                        atletaController.deleteAtleta();
                    case 5:
                        atletaController.readAtletiTennis2000();
                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
        } while (choice1 != 3);
    }
}
