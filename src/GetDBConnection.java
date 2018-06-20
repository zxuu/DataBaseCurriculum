import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDBConnection {

    public static Connection connectDB(String DBName, String user, String password) throws SQLException {

        Connection cno = null;
        String url = "jdbc:sqlserver://10.0.117.67:1433;DatabaseName=" + DBName;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            cno = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e + "getConnectionFaild");
        }

        return cno;
    }
}
