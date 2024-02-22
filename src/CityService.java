import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CityService {
    Scanner scanner = new Scanner(System.in);
    public City setAddUpdateCity() {
        City city = new City();
        System.out.println("| - Entrez le nom de la ville : ");
        city.setCityName(scanner.nextLine());
        System.out.println("| - Entrez l'identification de la ville : ");
        city.setCityId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez la température actuelle : ");
        city.setCurrentTemperature(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez l'humidité actuelle : ");
        city.setCurrentHumidity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez la vitesse du vent actuelle : ");
        city.setCurrentWindSpeed(scanner.nextInt());
        scanner.nextLine();
        return city;
    }
    public void addCity() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|          Ajouter une ville          |");
        System.out.println("+-------------------------------------+");
        DatabaseManagement.setDataCity(setAddUpdateCity());
    }
    public void updateCity() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|          Modifier une ville         |");
        System.out.println("+-------------------------------------+");
        DatabaseManagement.updateDataCity(setAddUpdateCity());
    }
    public void deleteCity() throws  SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|         Supprimer une ville         |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez le nom du ville à supprimer :");
        String deleteName = scanner.nextLine();
        DatabaseManagement.deleteDataCity(DatabaseManagement.getDataCity().stream().filter(city1 -> city1.getCityName().equals(deleteName)).collect(Collectors.toList()).get(0).getCityName());

    }
    public void searchCity() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|   Rechercher la météo d'une ville   |");
        System.out.println("+-------------------------------------+");
        System.out.println("City Name : ");
        String searchName = scanner.nextLine();
        System.out.println(DatabaseManagement.getDataCity().stream().filter(city1 -> city1.getCityName().equals(searchName)).collect(Collectors.toList()).get(0));
    }
}
