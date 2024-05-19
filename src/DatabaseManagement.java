import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseManagement {
    static LocalDate currentDate = LocalDate.now();
    private static final String url = "jdbc:mysql://localhost:3306/data_Weather";
    private static final String username = "root";
    private static final String password = "VANWOLFDEV123@";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public static boolean checkLogin (String username, String password) throws SQLException {
        boolean checkingLogin = false;
        Connection connection = getConnection();
        String checkLogin = "SELECT * FROM Connection_Admin_User WHERE username = ? AND password = ?";
        PreparedStatement statementLogin = connection.prepareStatement(checkLogin);
        statementLogin.setString(1, username);
        statementLogin.setString(2, password);
        ResultSet resultSet = statementLogin.executeQuery();
        if(resultSet.next()){
            checkingLogin = true;
        }
        connection.close();
        statementLogin.close();
        return checkingLogin;
    }
    public static void userSignUp(String username, String password) throws SQLException {
        Connection connection = getConnection();
        String userSignUp = "INSERT INTO Connection_Admin_User (username, password) VALUES (?, ?)";
        PreparedStatement statementSignUp = connection.prepareStatement(userSignUp);
        statementSignUp.setString(1, username);
        statementSignUp.setString(2, password);
        statementSignUp.executeUpdate();
        connection.close();
        statementSignUp.close();
    }
    public static void refreshDataBase() throws SQLException {
        Connection connection = getConnection();
        connection.prepareStatement("SET foreign_key_checks = 0").executeUpdate();
        String transferData = "INSERT INTO CityHistory (cityId, eventDate, historicalTemperature, historicalHumidity, historicalWindSpeed) SELECT cityId, currentDate AS eventDate, currentTemperature AS historicalTemperature, currentHumidity AS historicalHumidity, currentWindSpeed AS historicalWindSpeed FROM City WHERE currentDate < CURDATE()";
        PreparedStatement transferDataStatement = connection.prepareStatement(transferData);
        transferDataStatement.executeUpdate();
        String deleteData = "DELETE FROM City WHERE currentDate < CURDATE()";
        PreparedStatement deleteDataStatement = connection.prepareStatement(deleteData);
        deleteDataStatement.executeUpdate();
        connection.prepareStatement("SET foreign_key_checks = 1").executeUpdate();
        connection.close();
        transferDataStatement.close();
        deleteDataStatement.close();
    }

    public static boolean checkCity (String cityName) throws SQLException {
        boolean foundCity = false;
        Connection connection = getConnection();
        String checkData = "SELECT * FROM City WHERE cityName = ?";
        PreparedStatement statement = connection.prepareStatement(checkData);
        statement.setString(1, cityName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            foundCity = true;
        }
        getConnection().close();
        statement.close();
        return foundCity;
    }
    public static void statementCity(ArrayList<City> arrayCity, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            City city = new City();
            city.setCityId(resultSet.getInt("cityId"));
            city.setCityName(resultSet.getString("cityName"));
            city.setCurrentTemperature(resultSet.getInt("currentTemperature"));
            city.setCurrentHumidity(resultSet.getInt("currentHumidity"));
            city.setCurrentWindSpeed(resultSet.getInt("currentWindSpeed"));
            arrayCity.add(city);
        }
    }
    public static ArrayList<City> getDataCity() throws SQLException {
        ArrayList<City> arrayCity = new ArrayList<>();
        Connection connection = getConnection();
        String getDataCity = "SELECT * FROM City";
        PreparedStatement statement = connection.prepareStatement(getDataCity);
        statementCity(arrayCity, statement);
        getConnection().close();
        statement.close();
        return arrayCity;
    }
    public static boolean setDataCity(City city){
        boolean duplicateId = false;
        try {
            Connection connection = getConnection();
            String setDataCity = "INSERT INTO City (cityId, cityName, currentDate, currentTemperature, currentHumidity, currentWindSpeed) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(setDataCity);
            statement.setInt(1, city.getCityId());
            statement.setString(2, city.getCityName());
            statement.setDate(3, Date.valueOf(currentDate));
            statement.setInt(4, city.getCurrentTemperature());
            statement.setInt(5, city.getCurrentHumidity());
            statement.setInt(6, city.getCurrentWindSpeed());
            statement.executeUpdate();
            getConnection().close();
            statement.close();
        } catch (SQLException exception){
            duplicateId = true;
        }
        return duplicateId;
    }
    public static boolean updateDataCity(City city){
        boolean idFound = false;
        try {
            Connection connection = getConnection();
            String updateDataCity = "UPDATE City SET currentDate = ?, currentTemperature = ?, currentHumidity = ?, currentWindSpeed = ? WHERE cityName = ? AND cityId = ?";
            PreparedStatement statement = connection.prepareStatement(updateDataCity);
            statement.setDate(1, Date.valueOf(currentDate));
            statement.setInt(2, city.getCurrentTemperature());
            statement.setInt(3, city.getCurrentHumidity());
            statement.setInt(4, city.getCurrentWindSpeed());
            statement.setString(5, city.getCityName());
            statement.setInt(6, city.getCityId());
            statement.executeUpdate();
            getConnection().close();
            statement.close();
        } catch (SQLException exception){
            idFound = true;
        }
        return idFound;
    }
    public static void deleteDataCity(String deleteCityByName) throws SQLException {
        Connection connection = getConnection();
        String deleteDataCity = "DELETE FROM City WHERE cityName = ?";
        PreparedStatement statement = connection.prepareStatement(deleteDataCity);
        statement.setString(1, deleteCityByName);
        statement.executeUpdate();
        getConnection().close();
        statement.close();
    }
    public static void searchDataCity(String searchName) throws SQLException {
        ArrayList<City> searchArrayCity = new ArrayList<>();
        Connection connection = getConnection();
        String checkData = "SELECT * FROM City WHERE cityName = ?";
        PreparedStatement statement = connection.prepareStatement(checkData);
        statement.setString(1, searchName);
        statementCity(searchArrayCity, statement);
        searchArrayCity.forEach(System.out::println);
        connection.close();
        statement.close();
    }
    public static boolean checkCityHistory (String cityName) throws SQLException {
        boolean foundCityHistory = false;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM CityHistory WHERE cityId = (SELECT cityId FROM City WHERE cityName = ?)");
        statement.setString(1, cityName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            foundCityHistory = true;
        }
        getConnection().close();
        statement.close();
        return foundCityHistory;
    }
    public static void statementCityHistory(ArrayList<CityHistory> searchArrayHistory, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            CityHistory cityHistory = new CityHistory();
            cityHistory.setHistoricalDataId(resultSet.getInt("historicalDataId"));
            cityHistory.setCityId(resultSet.getInt("cityId"));
            cityHistory.setCityName(resultSet.getString("cityName"));
            cityHistory.setEventDate(resultSet.getDate("eventDate").toLocalDate());
            cityHistory.setHistoricalTemperature(resultSet.getInt("historicalTemperature"));
            cityHistory.setHistoricalHumidity(resultSet.getInt("historicalHumidity"));
            cityHistory.setHistoricalWindSpeed(resultSet.getInt("historicalWindSpeed"));
            searchArrayHistory.add(cityHistory);
        }
    }
    public static ArrayList<CityHistory> getDataCityHistory() throws SQLException {
        ArrayList<CityHistory> arrayCityHistory = new ArrayList<>();
        Connection connection = getConnection();
        String getDataCityHistory = "SELECT CityHistory.historicalDataID, CityHistory.cityId, City.cityName , Cityhistory.eventDate, Cityhistory.historicalTemperature , Cityhistory.historicalHumidity, Cityhistory.historicalWindSpeed FROM CityHistory INNER JOIN City ON CityHistory.cityId = City.cityId";
        PreparedStatement statement = connection.prepareStatement(getDataCityHistory);
        ResultSet resultSet = statement.executeQuery();
        statementCityHistory(arrayCityHistory, resultSet);
        return arrayCityHistory;
    }
    public static boolean setDataCityHistory(CityHistory cityHistory){
        boolean duplicateHistoricalId = false;
        try {
            Connection connection = getConnection();
            String setDataCityHistory = "INSERT INTO CityHistory (cityId, eventDate, historicalTemperature, historicalHumidity, historicalWindSpeed) SELECT cityId, ?, ?, ?, ? FROM City WHERE cityName = ?";
            PreparedStatement statement = connection.prepareStatement(setDataCityHistory);
            statement.setDate(1, Date.valueOf(cityHistory.getEventDate()));
            statement.setInt(2, cityHistory.getHistoricalTemperature());
            statement.setInt(3, cityHistory.getHistoricalHumidity());
            statement.setInt(4, cityHistory.getHistoricalWindSpeed());
            statement.setString(5, cityHistory.getCityName());
            statement.executeUpdate();
            getConnection().close();
            statement.close();
        } catch (SQLException exception){
            duplicateHistoricalId = true;
        }
        return duplicateHistoricalId;
    }
    public static boolean updateDataCityHistory(CityHistory cityHistory){
        boolean historicalIdFound = false;
        try {
            Connection connection = getConnection();
            String updateDataCityHistory = "UPDATE CityHistory SET historicalTemperature = ?, historicalHumidity = ?, historicalWindSpeed = ?, eventDate = ? WHERE historicalDataId = ? AND cityId = (SELECT cityId FROM City WHERE cityName = ?)";
            PreparedStatement statement = connection.prepareStatement(updateDataCityHistory);
            statement.setInt(1, cityHistory.getHistoricalTemperature());
            statement.setInt(2, cityHistory.getHistoricalHumidity());
            statement.setInt(3, cityHistory.getHistoricalWindSpeed());
            statement.setDate(4, Date.valueOf(cityHistory.getEventDate()));
            statement.setInt(5, cityHistory.getHistoricalDataId());
            statement.setString(6, cityHistory.getCityName());
            statement.executeUpdate();
            getConnection().close();
            statement.close();
        }catch (SQLException exception){
            historicalIdFound = true;
        }
        return historicalIdFound;
    }
    public static boolean deleteDataCityHistory(String deleteHistoricalName, Integer historicalId){
        boolean historicalIdFound = false;
        try {
            Connection connection = getConnection();
            String deleteDataCityHistory = "DELETE FROM CityHistory WHERE historicalDataId = ? AND cityId = (SELECT cityId FROM City WHERE cityName = ?)";
            PreparedStatement statement = connection.prepareStatement(deleteDataCityHistory);
            statement.setInt(1, historicalId);
            statement.setString(2, deleteHistoricalName);
            statement.executeUpdate();
            getConnection().close();
            statement.close();
        } catch (SQLException exception){
            historicalIdFound = true;
        }
        return historicalIdFound;
    }
    public static void searchDataHistory(String searchName) throws SQLException {
        ArrayList<CityHistory> searchArrayHistory = new ArrayList<>();
        Connection connection = getConnection();
        String checkDataHistory = "SELECT CityHistory.historicalDataID, CityHistory.cityId, City.cityName , Cityhistory.eventDate, Cityhistory.historicalTemperature , Cityhistory.historicalHumidity, Cityhistory.historicalWindSpeed FROM CityHistory INNER JOIN City ON CityHistory.cityId = City.cityId WHERE City.cityName = ?";
        PreparedStatement statement = connection.prepareStatement(checkDataHistory);
        statement.setString(1, searchName);
        ResultSet resultSet = statement.executeQuery();
        statementCityHistory(searchArrayHistory, resultSet);
        searchArrayHistory.forEach(System.out::println);
        connection.close();
        statement.close();
    }

    public static void getCityHumidity() throws SQLException {
        ArrayList<City> arrayHumidity = new ArrayList<>();
        Connection connection = getConnection();
        String getCityHumidity = "SELECT * FROM City where currentHumidity >= 30";
        PreparedStatement statement = connection.prepareStatement(getCityHumidity);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            City city = new City();
            city.setCityName(resultSet.getString("cityName"));
            city.setCityId(resultSet.getInt("cityId"));
            city.setCurrentTemperature(resultSet.getInt("currentTemperature"));
            city.setCurrentHumidity(resultSet.getInt("currentHumidity"));
            city.setCurrentHumidity(resultSet.getInt("currentWindSpeed"));

        }
        arrayHumidity.stream().map(city -> city.getCityName()).forEach(name -> System.out.println("Name"+name));
    }
}
