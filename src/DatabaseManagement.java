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

}
