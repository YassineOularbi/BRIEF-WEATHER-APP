import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;

public class CityHistoryService {
    Scanner scanner = new Scanner(System.in);

    public void interfaceCityHistory(CityHistory cityHistory) {
        System.out.println("| - Entrez le nom de la ville : ");
        cityHistory.setCityName(scanner.nextLine());
        System.out.println("| - Entrez la date exacte de l'événement : ");
        String eventDate = scanner.nextLine();
        cityHistory.setEventDate(LocalDate.parse(eventDate));
        System.out.println("| - Entrez la température : ");
        cityHistory.setHistoricalTemperature(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez l'humidité : ");
        cityHistory.setHistoricalHumidity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("| - Entrez la vitesse du vent : ");
        cityHistory.setHistoricalWindSpeed(scanner.nextInt());
        scanner.nextLine();
    }

    public void addCityHistory() throws SQLException {
        CityHistory cityHistory = new CityHistory();
        System.out.println("+-------------------------------------+");
        System.out.println("|      Ajouter un historique ville    |");
        System.out.println("+-------------------------------------+");
        interfaceCityHistory(cityHistory);
        if(!DatabaseManagement.checkCity(cityHistory.getCityName())) {
            System.out.println("+-------------------------------------+");
            System.out.println("|       Cette ville n'existe pas      |");
            System.out.println("+-------------------------------------+");
        } else if(DatabaseManagement.setDataCityHistory(cityHistory)){
            System.out.println("+-----------------------------------------------+");
            System.out.println("|   Le numéro d'identification doit être unique |");
            System.out.println("+-----------------------------------------------+");
        } else {
            System.out.println("+-------------------------------------+");
            System.out.println("| L'historique a été ajouté avec succès |");
            System.out.println("+-------------------------------------+");
        }
    }

    public void updateCityHistory() throws SQLException {
        CityHistory cityHistory = new CityHistory();
        System.out.println("+-------------------------------------+");
        System.out.println("|     Modifier un historique ville    |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez l'identification d'historique : ");
        cityHistory.setHistoricalDataId(scanner.nextInt());
        scanner.nextLine();
        interfaceCityHistory(cityHistory);
        if(!DatabaseManagement.checkCityHistory(cityHistory.getCityName())) {
            System.out.println("+-------------------------------------+");
            System.out.println("|      Cette ville n'existe pas       |");
            System.out.println("+-------------------------------------+");
        } else if (DatabaseManagement.updateDataCityHistory(cityHistory)){
            System.out.println("+-------------------------------------+");
            System.out.println("|     Cet historique n'existe pas     |");
            System.out.println("+-------------------------------------+");
        } else {
            System.out.println("+-------------------------------------+");
            System.out.println("| L'historique a été modifié avec succès |");
            System.out.println("+-------------------------------------+");
        }
    }

    public void deleteCityHistory() throws  SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|    Supprimer un historique ville    |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez le nom de la ville à supprimer :");
        String deleteHistory = scanner.nextLine();
        if(DatabaseManagement.checkCityHistory(deleteHistory)) {
            System.out.println("| - Entrez l'identification de l'historique : ");
            Integer historicalId = scanner.nextInt();
            if (DatabaseManagement.deleteDataCityHistory(deleteHistory, historicalId)) {
                System.out.println("+-------------------------------------+");
                System.out.println("|        Aucun historique trouvé      |");
                System.out.println("+-------------------------------------+");
            } else {
                System.out.println("+-----------------------------------------+");
                System.out.println("| L'historique a été supprimé avec succès |");
                System.out.println("+-----------------------------------------+");
            }
        }
    }

    public void searchCityHistory() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|   Rechercher un historique ville    |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez le nom de la ville :");
        String searchName = scanner.nextLine();
        if(DatabaseManagement.checkCityHistory(searchName)){
            DatabaseManagement.searchDataHistory(searchName);
        } else {
            System.out.println("+-------------------------------------+");
            System.out.println("|        Aucun historique trouvé      |");
            System.out.println("+-------------------------------------+");
        }
    }

    public void displayCityHistory() throws SQLException {
        if (DatabaseManagement.getDataCityHistory().isEmpty()){
            System.out.println("+-------------------------------------+");
            System.out.println("|   Aucun historique pour l'instant   |");
            System.out.println("+-------------------------------------+");
        } else {
            System.out.println("+-------------------------------------+");
            System.out.println("|       Historique des villes         |");
            System.out.println("+-------------------------------------+");
            DatabaseManagement.getDataCityHistory().forEach(System.out::println);
        }
    }
}
