/*
 * Created by JFormDesigner on Thu Jun 21 17:02:53 CST 2018
 */

package jframe;

import utils.JDBCSetting;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author we
 */
public class UserLogin extends BaseJFrame {

    Connection con;
    Statement sql;

    String userTel;
    String userPassword;

    public UserLogin() {
        super("用户登陆",150,150,1200,520);
        JDBCSetting.loadDriver();
        con = JDBCSetting.getConnection();
        initComponents();
    }

    private void userRegBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        int state = 0;
        userTel = tel.getText();
        userPassword = new String(password.getPassword());

        Aplication.tel = userTel;
        Aplication.password = userPassword;

        try {
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT Utel,Upassword FROM Users");
            while (rs.next()) {
                String Utel = rs.getString(1);
                if (Utel.equals(userTel)) {
                    String dataUserPas = rs.getString(2);
                    if (dataUserPas.equals(userPassword)) {
                        Aplication.row = rs.getRow();
                        //登陆成功后
                        System.out.println("userLoginSuccess!");
                        new UserJFrame();
                    } else {
                        JOptionPane.showMessageDialog(null,"密码错误！" +
                                "请重新登陆","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                    state = 1;
                    break;
                }
            }
            con.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        if (state == 0) {
            int op = JOptionPane.showConfirmDialog(null,"您还没有注册!确认要注册？","警告",JOptionPane.ERROR_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                new UserRegister("用户注册");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        tel = new JTextField();
        loginBtn = new JButton();
        password = new JPasswordField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7535\u8bdd");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(240, 95), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(240, 165), label2.getPreferredSize()));
        contentPane.add(tel);
        tel.setBounds(300, 80, 210, 45);

        //---- loginBtn ----
        loginBtn.setText("\u767b\u9646");
        loginBtn.addActionListener(e -> userRegBtnActionPerformed(e));
        contentPane.add(loginBtn);
        loginBtn.setBounds(335, 270, 135, loginBtn.getPreferredSize().height);
        contentPane.add(password);
        password.setBounds(300, 160, 210, 45);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField tel;
    private JButton loginBtn;
    private JPasswordField password;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
