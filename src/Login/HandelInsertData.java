package Login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HandelInsertData {
    Connection cno;
    PreparedStatement presql;

    public HandelInsertData() {
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

    public void writeRegisterModel(Register register){
        String sqlStr = "insert into register values(?,?,?)";
        int ok = 0;
        try {
            presql = cno.prepareStatement(sqlStr);
            presql.setString(1,register.getId());
            presql.setString(2,register.getPassword());
            presql.setString(3,register.getBirth());
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
