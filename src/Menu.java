import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CityService cityService = new CityService();
    CityHistoryService cityHistoryService = new CityHistoryService();

    public void menuInterface() throws SQLException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("+-------------------------------------+");
        System.out.println("|      Bienvenue dans WEATHER-APP     |");
        System.out.println("+-------------------------------------+");
        System.out.println("|     - Administrateur - > (Admin)    |");
        System.out.println("|     - Utilisateur    - > (User)     |");
        System.out.println("+-------------------------------------+");
        System.out.print("          Entrez un choix : ");
        String choix = scanner.nextLine();
        switch (choix) {
            case "Admin":
                System.out.println("+-------------------------------------+");
                System.out.println("|         Connexion Administrateur    |");
                System.out.println("+-------------------------------------+");
                System.out.print("Entrez votre nom d'utilisateur : ");
                String username = scanner.nextLine();
                System.out.print("Entrez votre mot de passe : ");
                String password = scanner.nextLine();
                if(DatabaseManagement.checkLogin(username, password)){
                    adminInterface();
                } else {
                    System.out.println("+-------------------------------------+");
                    System.out.println("|          Accès interdit !           |");
                    System.out.println("+-------------------------------------+");
                    menuInterface();
                }
                break;
            case "User":
                System.out.println("+-------------------------------------+");
                System.out.println("|        Connexion Utilisateur        |");
                System.out.println("+-------------------------------------+");
                System.out.println("| 1. Se connecter                     |");
                System.out.println("| 2. Créer un nouveau compte          |");
                System.out.println("+-------------------------------------+");
                System.out.print("          Entrez un choix : ");
                int choixLogin = scanner.nextInt();
                switch (choixLogin){
                    case 1 :
                        System.out.println("+-------------------------------------+");
                        System.out.println("|         Connexion Utilisateur       |");
                        System.out.println("+-------------------------------------+");
                        System.out.print("Entrez votre nom d'utilisateur : ");
                        String usernameU = scanner1.nextLine();
                        System.out.print("Entrez votre mot de passe : ");
                        String passwordU = scanner1.nextLine();
                        if(DatabaseManagement.checkLogin(usernameU, passwordU)){
                            userInterface();
                        } else {
                            System.out.println("+-------------------------------------+");
                            System.out.println("|          Accès interdit !           |");
                            System.out.println("+-------------------------------------+");
                            menuInterface();
                        }
                        break;
                    case 2 :
                        System.out.println("+-------------------------------------+");
                        System.out.println("|     Création d'un nouveau compte    |");
                        System.out.println("+-------------------------------------+");
                        System.out.print("Entrez votre nom d'utilisateur : ");
                        String usernameC = scanner1.nextLine();
                        System.out.print("Entrez votre mot de passe : ");
                        String passwordC = scanner1.nextLine();
                        DatabaseManagement.userSignUp(usernameC, passwordC);
                        System.out.println("+-------------------------------------+");
                        System.out.println("|      Compte créé avec succès !      |");
                        System.out.println("+-------------------------------------+");
                        userInterface();
                        break;
                }
                break;
            default:
                System.out.println("+-------------------------------------+");
                System.out.println("|         Choix invalide !            |");
                System.out.println("+-------------------------------------+");
                menuInterface();
                break;
        }
    }

    public void adminInterface() throws SQLException {
        int choixAdmin;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|        Page administrateur          |");
            System.out.println("+-------------------------------------+");
            System.out.println("| - Gestion météo actuelle - > (1)    |");
            System.out.println("| - Gestion d'historiques  - > (2)    |");
            System.out.println("| - Se déconnecter         - > (3)    |");
            System.out.println("+-------------------------------------+");
            System.out.print("          Entrez un choix : ");
            choixAdmin = scanner.nextInt();
            switch (choixAdmin) {
                case 1:
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
                        System.out.println("|  6 . Retourner à l'accueil          |");
                        System.out.println("+-------------------------------------+");
                        System.out.print("          Entrez un choix : ");
                        choixCity = scanner.nextInt();
                        switch (choixCity) {
                            case 1:
                                cityService.addCity();
                                break;
                            case 2:
                                cityService.updateCity();
                                break;
                            case 3:
                                cityService.deleteCity();
                                break;
                            case 4:
                                cityService.searchCity();
                                break;
                            case 5:
                                cityService.displayCity();
                                break;
                            case 6:
                                adminInterface();
                                break;
                            default:
                                System.out.println("+-------------------------------------+");
                                System.out.println("|         Choix invalide !            |");
                                System.out.println("+-------------------------------------+");
                                break;
                        }
                    } while (choixCity != 6);
                    break;
                case 2:
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
                        System.out.println("|  6 . Retourner à l'accueil          |");
                        System.out.println("+-------------------------------------+");
                        System.out.print("          Entrez un choix : ");
                        choixHistory = scanner.nextInt();
                        switch (choixHistory) {
                            case 1:
                                cityHistoryService.addCityHistory();
                                break;
                            case 2:
                                cityHistoryService.updateCityHistory();
                                break;
                            case 3:
                                cityHistoryService.deleteCityHistory();
                                break;
                            case 4:
                                cityHistoryService.searchCityHistory();
                                break;
                            case 5:
                                cityHistoryService.displayCityHistory();
                                break;
                            case 6:
                                adminInterface();
                                break;
                            default:
                                System.out.println("+-------------------------------------+");
                                System.out.println("|         Choix invalide !            |");
                                System.out.println("+-------------------------------------+");
                                break;
                        }
                    } while (choixHistory != 6);
                    break;
                case 3 :
                    menuInterface();
                    break;
                default:
                    System.out.println("+-------------------------------------+");
                    System.out.println("|         Choix invalide !            |");
                    System.out.println("+-------------------------------------+");
                    break;
            }
        } while (choixAdmin != -100);
    }

    public void userInterface() throws SQLException {
        int choixUser;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|             WEATHER-APP             |");
            System.out.println("|   Votre compagnon vers l'avenir     |");
            System.out.println("+-------------------------------------+");
            System.out.println("|  1 . Accéder à la météo actuelle    |");
            System.out.println("|  2 . Rechercher la météo d'une ville|");
            System.out.println("|  3 . Accéder à l'historique de météo|");
            System.out.println("|  4 . Rechercher un historique       |");
            System.out.println("|  5 . Se déconnecter                 |");
            System.out.println("+-------------------------------------+");
            System.out.print("          Entrez un choix : ");
            choixUser = scanner.nextInt();
            switch (choixUser) {
                case 1:
                    cityService.displayCity();
                    break;
                case 2:
                    cityService.searchCity();
                    break;
                case 3:
                    cityHistoryService.displayCityHistory();
                    break;
                case 4:
                    cityHistoryService.searchCityHistory();
                    break;
                case 5:
                    System.out.println("+-------------------------------------+");
                    System.out.println("|            Au revoir !              |");
                    System.out.println("+-------------------------------------+");
                    menuInterface();
                    break;
                default:
                    System.out.println("+-------------------------------------+");
                    System.out.println("|         Choix invalide !            |");
                    System.out.println("+-------------------------------------+");
                    break;
            }
        } while (choixUser != -100);
    }
}
