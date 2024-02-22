import java.sql.SQLException;
import java.util.Scanner;

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
}
