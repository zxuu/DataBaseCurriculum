/*
 * Created by JFormDesigner on Thu Jun 21 14:39:17 CST 2018
 */

package jframe;

import model.Doctors;
import utils.JDBCSetting;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


/**
 * @author we
 */
public class DoctorLogin extends BaseJFrame {

    Connection con;
    Statement sql;

    String docTelph;
    String doctorPassword;

    public DoctorLogin() {
        super("医生登陆",150,150,1200,520);
        getContentPane().setBackground(new Color(132, 188, 207));
        JDBCSetting.loadDriver();
        initComponents();
    }

    private void DocLoginActionPerformed(ActionEvent e) {
        // TODO add your code here
        int state = 0;
        docTelph = docTel.getText();
        doctorPassword = new String(docLoginPassword.getPassword());

        try {
            con = JDBCSetting.getConnection();
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM Doctors");
            while (rs.next()) {
                String Dtel = rs.getString(4);
                if (Dtel.equals(docTelph)) {
                    String dataDocPas = rs.getString(10);
                    if (dataDocPas.equals(doctorPassword)) {
                        //登陆成功后

                        Doctors doctor = new Doctors();
                        doctor.setDname(rs.getString(1));
                        doctor.setDsex(rs.getString(2));
                        doctor.setDage(rs.getString(3));
                        doctor.setDtel(rs.getString(4));
                        doctor.setDbirth(rs.getString(5));
                        doctor.setDID(rs.getString(6));
                        doctor.setDadress(rs.getString(7));
                        doctor.setDworkunit(rs.getString(8));
                        doctor.setDworkexp(rs.getString(9));
                        doctor.setDpassword(rs.getString(10));
                        doctor.setProvince(rs.getString(11));
                        doctor.setCity(rs.getString(12));
                        doctor.setCounty(rs.getString(13));
                        doctor.setDscore(rs.getString(14));
                        Aplication.doctorI = doctor;

                        System.out.println("doctorLoginSuccess!");
                        Aplication.drow = rs.getRow();
                        System.out.println("getRow == " + Aplication.drow);
                        new doctorJFrame();
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
                new DoctorRegister("医生注册");
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        loginBtn = new JButton();
        docLoginPassword = new JPasswordField();
        docTel = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7535\u8bdd");
        contentPane.add(label1);
        label1.setBounds(145, 100, 60, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(145, 190), label2.getPreferredSize()));

        //---- loginBtn ----
        loginBtn.setText("\u767b\u9646");
        loginBtn.addActionListener(e -> DocLoginActionPerformed(e));
        contentPane.add(loginBtn);
        loginBtn.setBounds(240, 330, 205, 50);
        contentPane.add(docLoginPassword);
        docLoginPassword.setBounds(210, 175, 285, 55);
        contentPane.add(docTel);
        docTel.setBounds(210, 95, 285, 60);

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
    private JButton loginBtn;
    private JPasswordField docLoginPassword;
    private JTextField docTel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
