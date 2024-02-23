import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CityService cityService = new CityService();
    CityHistoryService cityHistoryService = new CityHistoryService();
    public void menuInterface() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|     Bienvenue dans WEATHER-APP      |");
        System.out.println("+-------------------------------------+");
        System.out.println("|     - Administrateur - > (Admin)    |");
        System.out.println("|     - Utilisateur    - > (User)     |");
        System.out.println("+------------------------------------+");
        System.out.print("          Entrez un choix : ");
        String choix = scanner.nextLine();
            switch (choix) {
                case "Admin" :
                    adminInterface();
                    break;
                case "User" :
                    break;
                default:
                    break;
            }
    }
    public void adminInterface() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|         Page administrateur         |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Gestion météo actuelle -> (City)  |");
        System.out.println("| - Gestion d'historiques -> (History)|");
        System.out.println("+------------------------------------+");
        System.out.print("          Entrez un choix : ");
        String choixAdmin = scanner.nextLine();
        switch (choixAdmin) {
            case "City" :
                int choixCity;
                do {
                    System.out.println("+-------------------------------------+");
                    System.out.println("|Gestion de la météo actuelle de ville|");
                    System.out.println("+-------------------------------------+");
                    System.out.println("|  1 . Ajouter la météo d'une ville   |");
                    System.out.println("|  2 . Modifier la météo d'une ville  |");
                    System.out.println("|  3 . Supprimer la météo d'une ville |");
                    System.out.println("|  4 . Rechercher une ville           |");
                    System.out.println("|  5 . Afficher les villes            |");
                    System.out.println("|  6 . Retourner a l'acceuil          |");
                    System.out.println("+-------------------------------------+");
                    System.out.print("          Entrez un choix : ");
                    choixCity = scanner.nextInt();
                    switch (choixCity) {
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
                            adminInterface();
                            break;
                        default:
                            break;
                    }
                }while (choixCity!=6);
                break;
            case "History" :
                int choixHistory;
                do {
                    System.out.println("+-------------------------------------+");
                    System.out.println("| Gestion des historiques des villes  |");
                    System.out.println("+-------------------------------------+");
                    System.out.println("|  1 . Ajouter un historique          |");
                    System.out.println("|  2 . Modifier un historique         |");
                    System.out.println("|  3 . Supprimer un historique        |");
                    System.out.println("|  4 . Rechercher un historique       |");
                    System.out.println("|  5 . Afficher les historiques       |");
                    System.out.println("|  6 . Retourner a l'acceuil          |");
                    System.out.println("+-------------------------------------+");
                    System.out.print("          Entrez un choix : ");
                    choixHistory = scanner.nextInt();
                    switch (choixHistory) {
                        case 1 :
                            cityHistoryService.addCityHistory();
                            break;
                        case 2:
                            cityHistoryService.updateCityHistory();
                            break;
                        case 3 :
                            cityHistoryService.deleteCityHistory();
                            break;
                        case 4 :
                            cityHistoryService.searchCityHistory();
                            break;
                        case 5 :
                            cityHistoryService.displayCityHistory();
                            break;
                        case 6 :
                            adminInterface();
                            break;
                        default:
                            break;
                    }
                }while (choixHistory!=6);
                break;
            default:
                break;
        }

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
