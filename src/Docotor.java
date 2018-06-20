import java.sql.*;

public class Docotor {

    public static void main(String[] args) {

        String user = "sa";
        String password = "1122";

        Statement sql = null;
        try {
            sql = GetDBConnection.connectDB("DPDB",user,password).createStatement();
            ResultSet rs = sql.executeQuery("SELECT Dname,Dsex FROM Doctor");
            while (rs.next()) {
                String Sno = rs.getString(1);
                String Sname = rs.getString(2);
                System.out.println(Sname);
                System.out.println(Sno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
