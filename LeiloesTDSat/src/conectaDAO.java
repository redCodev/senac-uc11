
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class conectaDAO {

    private Connection conn = null;

    public Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // SSL
            Properties props = new Properties();
            props.setProperty("useSSL", "true");
            props.setProperty("requireSSL", "true");

            props.setProperty("user", "root");
            props.setProperty("password", "123");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", props);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ConectaDAO" + ex.getMessage());
            return null;
        }
        return conn;
    }

}
