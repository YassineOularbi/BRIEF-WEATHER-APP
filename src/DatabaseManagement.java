import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManagement {
    private static final String url = "jdbc:mysql://localhost:3306/data_Weather";
    private static final String username = "root";
    private static final String password = "VANWOLFDEV123@";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
