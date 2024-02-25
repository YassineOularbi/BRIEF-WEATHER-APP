import java.sql.SQLException;
import java.util.Scanner;

public class CityService {
    Scanner scanner = new Scanner(System.in);

    public void cityInterface(City city) {
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez l'identification de la ville : ");
        city.setCityId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez le nom de la ville : ");
        city.setCityName(scanner.nextLine());
        System.out.println("| - Entrez la température actuelle : ");
        city.setCurrentTemperature(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez l'humidité actuelle : ");
        city.setCurrentHumidity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez la vitesse du vent actuelle : ");
        city.setCurrentWindSpeed(scanner.nextInt());
        scanner.nextLine();
    }

    public void addCity() throws SQLException {
        City city = new City();
        System.out.println("+-------------------------------------+");
        System.out.println("|          Ajouter une ville          |");
        cityInterface(city);
        if (DatabaseManagement.checkCity(city.getCityName())) {
            System.out.println("+-------------------------------------+");
            System.out.println("|  Impossible d'ajouter cette ville ! |");
            System.out.println("+-------------------------------------+");
        } else if (DatabaseManagement.setDataCity(city)){
            System.out.println("+-----------------------------------------+");
            System.out.println("|  Le numéro d'identification existe déjà |");
            System.out.println("+-----------------------------------------+");
        } else {
            System.out.println("+---------------------------------------+");
            System.out.println("|  La ville a été ajoutée avec succès ! |");
            System.out.println("+---------------------------------------+");
        }
    }

    public void updateCity() throws SQLException {
        City city = new City();
        System.out.println("+-------------------------------------+");
        System.out.println("|          Modifier une ville         |");
        cityInterface(city);
        if (!DatabaseManagement.checkCity(city.getCityName())){
            System.out.println("+---------------------------------------+");
            System.out.println("|  Impossible de modifier cette ville ! |");
            System.out.println("+---------------------------------------+");
        } else if (DatabaseManagement.updateDataCity(city)){
            System.out.println("+---------------------------------------------+");
            System.out.println("|  Le numéro d'identification est incorrect ! |");
            System.out.println("+---------------------------------------------+");
        } else {
            System.out.println("+----------------------------------------+");
            System.out.println("|  La ville a été modifiée avec succès ! |");
            System.out.println("+----------------------------------------+");
        }
    }

    public void deleteCity() throws  SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|         Supprimer une ville         |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez le nom de la ville à supprimer :");
        String deleteName = scanner.nextLine();
        if (DatabaseManagement.checkCity(deleteName)){
            DatabaseManagement.deleteDataCity(deleteName);
            System.out.println("+-------------------------------------+");
            System.out.println("|  La ville a été supprimée avec succès ! |");
            System.out.println("+-------------------------------------+");
        } else {
            System.out.println("+---------------------------------------------+");
            System.out.println("|  Aucune ville n'a été trouvée pour ce nom ! |");
            System.out.println("+---------------------------------------------+");
        }
    }

    public void searchCity() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|   Rechercher la météo d'une ville   |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez le nom de la ville à chercher :");
        String searchName = scanner.nextLine();
        if(DatabaseManagement.checkCity(searchName)){
            DatabaseManagement.searchDataCity(searchName);
        } else {
            System.out.println("+---------------------------------------------+");
            System.out.println("|  Aucune ville n'a été trouvée pour ce nom ! |");
            System.out.println("+---------------------------------------------+");
        }
    }

    public void displayCity() throws SQLException {
        if (DatabaseManagement.getDataCity().isEmpty()){
            System.out.println("+-------------------------------------+");
            System.out.println("|    La base de données est vide      |");
            System.out.println("+-------------------------------------+");
        } else {
            System.out.println("+-------------------------------------+");
            System.out.println("|  Informations météo des villes     |");
            System.out.println("+-------------------------------------+");
            DatabaseManagement.getDataCity().forEach(city -> System.out.println(city.toString()));
        }
    }
}
