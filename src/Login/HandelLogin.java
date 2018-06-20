package Login;

import javax.swing.*;
import java.sql.*;

public class HandelLogin {
    Connection cno;
    PreparedStatement preSql;
    ResultSet rs;

    public HandelLogin() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败，" + e);
        }
        String url = "jdbc:sqlserver://10.130.135.2:1433;DatabaseName=DPDB";
        try {
            cno = DriverManager.getConnection(url, "sa", "1122");
        } catch (SQLException e) {
            System.out.println(e + ",getConnectionFaild");
        }
    }

    public Login queryVerify(Login login) {
        String id = login.getId();
        String password = login.getPassword();
        try {
            preSql = cno.prepareStatement("SELECT id,password FROM register WHERE " +
                    "id = ? AND password = ?");
            preSql.setString(1,id);
            preSql.setString(2,password);
            rs = preSql.executeQuery();
            if (rs.next() == true) {
                login.setLoginSuccess(true);
                JOptionPane.showMessageDialog(null,"登陆成功","恭喜",
                        JOptionPane.WARNING_MESSAGE);
            }else {
                login.setLoginSuccess(false);
                JOptionPane.showMessageDialog(null,"登陆失败","登陆失败,重新登陆",
                        JOptionPane.WARNING_MESSAGE);
            }
            cno.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }


}
