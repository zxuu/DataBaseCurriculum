package utils;

import model.Doctor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocRegHelp {

    Connection cno;
    PreparedStatement presql;

    public DocRegHelp() {
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

    public void writeDocRegModel(Doctor doctor) {


        String sqlStr = "insert into Doctors values(?,?,?,?,?,?,?,?,?,?)";
        int ok = 0;
        try {
            presql = cno.prepareStatement(sqlStr);
            presql.setString(1,doctor.getName());
            presql.setString(2,doctor.getSex());
            presql.setString(3,doctor.getAge());
            presql.setString(4,doctor.getTel());
            presql.setString(5,doctor.getBirth());
            presql.setString(6,doctor.getID());
            presql.setString(7,doctor.getAdress());
            presql.setString(8,doctor.getWorkunit());
            presql.setString(9,doctor.getWorkexperence());
            presql.setString(10,doctor.getPassword());

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
