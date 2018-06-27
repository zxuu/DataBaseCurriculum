package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSetting {

    static Connection con;

    static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String URL = "jdbc:sqlserver://10.0.117.67:1433;DatabaseName=DPDB;useUnicode=true&characterEncoding=UTF-8";
    static final String USERNAME = "sa";
    static final String PASSWORD = "1122";

    public static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ec) {
            System.out.println("加载驱动失败");
        }
    }

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        } catch (SQLException e1) {
            System.out.println(e1 + "登陆失败");
        }

        return con;
    }

}
