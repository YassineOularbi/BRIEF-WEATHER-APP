import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void menuInterface() {
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
    public void adminInterface(){
        int choixAdmin;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|     Admin Interface WEATHER-APP     |");
            System.out.println("+-------------------------------------+");
            System.out.println("|  1 . Ajouter une nouvelle instance  |");
            System.out.println("|  2 . Modifier une  instance         |");
            System.out.println("|  3 . Supprimer une instance         |");
            System.out.println("|  4 . Afficher les instances         |");
            System.out.println("|  5 . Retourner a l'acceuil          |");
            System.out.println("+-------------------------------------+");
            System.out.print("          Entrez un choix : ");
            choixAdmin = scanner.nextInt();
            switch (choixAdmin) {
                case 1 :
                    break;
                case 2:
                    break;
                case 3 :
                    break;
                case 4 :
                    break;
                case 5 :
                    menuInterface();
                    break;
                default:
                    break;
            }
        }while (choixAdmin!=5);
    }
    public void userInterface(){
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
