package utils;

import model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegHelp {
    Connection cno;
    PreparedStatement presql;

    public UserRegHelp() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败，" + e);
        }
        String url = "jdbc:sqlserver://10.0.117.67:1433;DatabaseName=DPDB";
        try {
            cno = DriverManager.getConnection(url, "sa", "1122");
        } catch (SQLException e) {
            System.out.println(e + ",getConnectionFaild");
        }
    }

    public void writeUserRegModel(User user){
        String sqlStr = "insert into Users values(?,?,?,?,?)";

        int ok = 0;
        try {
            presql = cno.prepareStatement(sqlStr);
            presql.setString(1,user.getUname());
            presql.setString(2,user.getUsex());
            presql.setString(3,user.getUage());
            presql.setString(4,user.getUtel());
            presql.setString(5,user.getUdescribe());

            ok = presql.executeUpdate();
            cno.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"id不能重复","警告",
                    JOptionPane.WARNING_MESSAGE);
        }

        if (ok != 0) {
            JOptionPane.showMessageDialog(null,"注册成功","" +
                    "恭喜",JOptionPane.WARNING_MESSAGE);
        }
    }
}
