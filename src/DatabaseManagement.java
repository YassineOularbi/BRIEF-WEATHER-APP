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
                CityService cityService = new CityService(0, "", 0, 0, 0);
                cityService.setCityId(resultSet.getInt("cityId"));
                cityService.setCityName(resultSet.getString("cityName"));
                cityService.setCurrentTemperature(resultSet.getInt("currentTemperature"));
                cityService.setCurrentHumidity(resultSet.getInt("currentHumidity"));
                cityService.setCurrentWindSpeed(resultSet.getInt("currentWindSpeed"));
                arrayCity.add(cityService);
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

}
