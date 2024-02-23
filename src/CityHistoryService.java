import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class CityHistoryService {
    Scanner scanner = new Scanner(System.in);
    public CityHistory setAddUpdateCityHistory() {
        CityHistory cityHistory = new CityHistory();
        System.out.println("| - Entrez l'identification de l'Historique du ville : ");
        cityHistory.setHistoricalDataId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez l'identification de la ville : ");
        cityHistory.setCityId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez la date de l'événement : ");
        String eventDate = scanner.nextLine();
        cityHistory.setEventDate(LocalDate.parse(eventDate));
        System.out.println("| - Entrez la température actuelle : ");
        cityHistory.setHistoricalTemperature(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez l'humidité actuelle : ");
        cityHistory.setHistoricalHumidity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez la vitesse du vent actuelle : ");
        cityHistory.setHistoricalWindSpeed(scanner.nextInt());
        scanner.nextLine();
        return cityHistory;
    }
    public void addCityHistory() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|     Ajouter un Historique ville     |");
        System.out.println("+-------------------------------------+");
        DatabaseManagement.setDataCityHistory(setAddUpdateCityHistory());
    }
    public void updateCityHistory() throws SQLException, SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|     Modifier un historique ville    |");
        System.out.println("+-------------------------------------+");
        DatabaseManagement.updateDataCityHistory(setAddUpdateCityHistory());
    }
    public void deleteCityHistory() throws  SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|    Supprimer un histrorique ville   |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez l'identification de l'historique :");
        Integer deleteId = scanner.nextInt();
        DatabaseManagement.deleteDataCityHistory(DatabaseManagement.getDataCityHistory().stream().filter(city1 -> city1.getHistoricalDataId().equals(deleteId)).collect(Collectors.toList()).get(0).getHistoricalDataId());

    }
    public void searchCityHistory() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|   Rechercher un historique ville    |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez l'identification de la ville :");
        Integer searchId = scanner.nextInt();
        System.out.println(DatabaseManagement.getDataCityHistory().stream().filter(cityHistory -> cityHistory.getHistoricalDataId().equals(searchId)).collect(Collectors.toList()).get(0));
    }
    public void displayCityHistory() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|        Historique des villes        |");
        System.out.println("+-------------------------------------+");
        DatabaseManagement.getDataCityHistory().forEach(cityHistory -> System.out.println(cityHistory.toString()));
    }
}
