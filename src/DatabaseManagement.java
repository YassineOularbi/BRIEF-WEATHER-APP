import java.sql.*;
import java.util.ArrayList;

public class DatabaseManagement {
    private static final String url = "jdbc:mysql://localhost:3306/data_Weather";
    private static final String username = "root";
    private static final String password = "VANWOLFDEV123@";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public static ArrayList<City> getDataCity() throws SQLException {
        ArrayList<City> arrayCity = new ArrayList<>();
        Connection connection = getConnection();
        String getDataCity = "SELECT * FROM City";
        try (PreparedStatement statement = connection.prepareStatement(getDataCity);
             ResultSet resultSet = statement.executeQuery()) {
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
        return arrayCity;
    }
    public static void setDataCity(City city) throws SQLException {
        Connection connection = getConnection();
        String setDataCity = "INSERT INTO City (cityId, cityName, currentTemperature, currentHumidity, currentWindSpeed) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(setDataCity);
        statement.setInt(1, city.getCityId());
        statement.setString(2, city.getCityName());
        statement.setInt(3, city.getCurrentTemperature());
        statement.setInt(4, city.getCurrentHumidity());
        statement.setInt(5, city.getCurrentWindSpeed());
        statement.executeUpdate();
        getConnection().close();
        statement.close();
    }
    public static void updateDataCity(City city) throws SQLException {
        Connection connection = getConnection();
        String updateDataCity = "UPDATE City SET  cityName = ?, currentTemperature = ?, currentHumidity = ?, currentWindSpeed = ? WHERE cityId = ?";
        PreparedStatement statement = connection.prepareStatement(updateDataCity);
        statement.setString(1, city.getCityName());
        statement.setInt(2, city.getCurrentTemperature());
        statement.setInt(3, city.getCurrentHumidity());
        statement.setInt(4, city.getCurrentWindSpeed());
        statement.setInt(5, city.getCityId());
        statement.executeUpdate();
        getConnection().close();
        statement.close();
    }
    public static void deleteDataCity(String name) throws SQLException {
        Connection connection = getConnection();
        String deleteDataCity = "DELETE FROM City WHERE cityName = ?";
        PreparedStatement statement = connection.prepareStatement(deleteDataCity);
        statement.setString(1, name);
        statement.executeUpdate();
        getConnection().close();
        statement.close();
        getDataCity();
    }
    public static ArrayList<CityHistory> getDataCityHistory() throws SQLException {
        ArrayList<CityHistory> arrayCityHistory = new ArrayList<>();
        Connection connection = getConnection();
        String getDataCityHistory = "SELECT * FROM CityHistory";
        try (PreparedStatement statement = connection.prepareStatement(getDataCityHistory);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                CityHistory cityHistory = new CityHistory();
                cityHistory.setHistoricalDataId(resultSet.getInt("historicalDataId"));
                cityHistory.setCityId(resultSet.getInt("cityId"));
                cityHistory.setEventDate(resultSet.getDate("eventDate").toLocalDate());
                cityHistory.setHistoricalTemperature(resultSet.getInt("historicalTemperature"));
                cityHistory.setHistoricalHumidity(resultSet.getInt("historicalHumidity"));
                cityHistory.setHistoricalWindSpeed(resultSet.getInt("historicalWindSpeed"));
                arrayCityHistory.add(cityHistory);
            }
        }
        return arrayCityHistory;
    }
    public static void setDataCityHistory(CityHistory cityHistory) throws SQLException {
        Connection connection = getConnection();
        String setDataCityHistory = "INSERT INTO CityHistory (historicalDataId, cityId, eventDate, historicalTemperature, historicalHumidity, historicalWindSpeed) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(setDataCityHistory);
        statement.setInt(1, cityHistory.getHistoricalDataId());
        statement.setInt(2, cityHistory.getCityId());
        statement.setDate(3, Date.valueOf(cityHistory.getEventDate()));
        statement.setInt(4, cityHistory.getHistoricalTemperature());
        statement.setInt(5, cityHistory.getHistoricalHumidity());
        statement.setInt(6, cityHistory.getHistoricalWindSpeed());
        statement.executeUpdate();
        getConnection().close();
        statement.close();
    }
    public static void updateDataCityHistory(CityHistory cityHistory) throws SQLException {
        Connection connection = getConnection();
        String updateDataCityHistory = "UPDATE CityHistory SET historicalDataId = ?, eventDate = ?, historicalTemperature = ?, historicalHumidity = ?, historicalWindSpeed = ? WHERE cityId = ?";
        PreparedStatement statement = connection.prepareStatement(updateDataCityHistory);
        statement.setInt(1, cityHistory.getHistoricalDataId());
        statement.setDate(2, Date.valueOf(cityHistory.getEventDate()));
        statement.setInt(3, cityHistory.getHistoricalTemperature());
        statement.setInt(4, cityHistory.getHistoricalHumidity());
        statement.setInt(5, cityHistory.getHistoricalWindSpeed());
        statement.setInt(6, cityHistory.getCityId());
        statement.executeUpdate();
        getConnection().close();
        statement.close();
    }
    public static void deleteDataCityHistory(Integer cityId) throws SQLException {
        Connection connection = getConnection();
        String deleteDataCityHistory = "DELETE FROM CityHistory WHERE cityId = ?";
        PreparedStatement statement = connection.prepareStatement(deleteDataCityHistory);
        statement.setInt(1, cityId);
        statement.executeUpdate();
        getConnection().close();
        statement.close();
        getDataCity();
    }
}
