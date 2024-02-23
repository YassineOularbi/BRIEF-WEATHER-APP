import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CityService cityService = new CityService();
    CityHistoryService cityHistoryService = new CityHistoryService();
    public void menuInterface() throws SQLException {
        int choix;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|     Bienvenue dans WEATHER-APP      |");
            System.out.println("+-------------------------------------+");
            System.out.println("|   Vous etes Admin clickez sur : 1   |");
            System.out.println("|Vous etes Utilisateur clickez sur : 2|");
            System.out.println("|     Pour quitter clickez sur : 3    |");
            System.out.println("+------------------------------------+");
            System.out.print("          Entrez un choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1 :
                    adminInterface();
                    break;
                case 2:
                    break;
                case 3 :
                    break;
                default:
                    break;
            }
        }while (choix!=3);
    }
    public void adminInterface() throws SQLException {
        int choixAdmin;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|     Admin Interface WEATHER-APP     |");
            System.out.println("+-------------------------------------+");
            System.out.println("|  1 . Ajouter une nouvelle instance  |");
            System.out.println("|  2 . Modifier une  instance         |");
            System.out.println("|  3 . Supprimer une instance         |");
            System.out.println("|  4 . Rechercher une instance        |");
            System.out.println("|  5 . Afficher les instances         |");
            System.out.println("|  6 . Retourner a l'acceuil          |");
            System.out.println("+-------------------------------------+");
            System.out.print("          Entrez un choix : ");
            choixAdmin = scanner.nextInt();
            switch (choixAdmin) {
                case 1 :
                    cityService.addCity();
                    break;
                case 2:
                    cityService.updateCity();
                    break;
                case 3 :
                    cityService.deleteCity();
                    break;
                case 4 :
                    cityService.searchCity();
                    break;
                case 5 :
                    cityService.displayCity();
                    break;
                case 6 :
                    break;
                default:
                    break;
            }
        }while (choixAdmin!=6);
    }
    public void userInterface() throws SQLException {
        int choixUser;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|   Utilisateur Interface WEATHER-APP |");
            System.out.println("+-------------------------------------+");
            System.out.println("|  1 . Rechercher une ville           |");
            System.out.println("|  2 . Afficher l'historique          |");
            System.out.println("|  3 . Retourner a l'acceuil          |");
            System.out.println("+-------------------------------------+");
            System.out.print("          Entrez un choix : ");
            choixUser = scanner.nextInt();
            switch (choixUser) {
                case 1 :
                    break;
                case 2:
                    break;
                case 3 :
                    menuInterface();
                    break;
                default:
                    break;
            }
        }while (choixUser!=5);
    }
}
