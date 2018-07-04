package jframe;

import model.Users;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterUserInfo extends BaseJFrame{

    public AlterUserInfo(String jframeTitle) {
        super(jframeTitle,100,100,540,1040);
        getContentPane().setBackground(new Color(132, 188, 207));
        initComponents();
    }

    private void userbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
//        resultSetHelp resultSetHelp = utils.resultSetHelp.getresultSetHelpInstance();
//        resultSetHelp.setResultSet(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, "SELECT * FROM Users",
//                Aplication.row, new getResultSet() {
//                    @Override
//                    public void getResultSetSuccess(ResultSet resultSet, Connection connection) {
//                        System.out.println("getResultSuccess!");
//                        try {
//                            resultSet.updateString(1,unameText.getText());
//                            resultSet.updateString(2,usexText.getText());
//                            resultSet.updateString(3,uageText.getText());
//                            resultSet.updateString(4,utelText.getText());
//                            resultSet.updateString(5,textArea1.getText());
//                            resultSet.updateString(6,new String(password.getPassword()));
//                            resultSet.updateRow();
//                            connection.close();
//                        } catch (SQLException e1) {
//                            e1.printStackTrace();
//                        }
//
//                    }
//                });
        Users newUser = new Users();
        Users olduser = new Users();
        olduser.setUtel(Aplication.userI.getUtel());
        newUser.setUname(unameText.getText());
        newUser.setUsex(usexText.getText());
        newUser.setUage(uageText.getText());
        newUser.setUtel(utelText.getText());
        newUser.setUdescribe(textArea1.getText());
        newUser.setUpassword(String.valueOf(password.getPassword()));
        newUser.update(olduser, new JDBCDao.UpdateListener() {
            @Override
            public void onSucceed() {
                JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.PLAIN_MESSAGE);
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });

        Aplication.userI = newUser;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        unameText = new JTextField();
        usexText = new JTextField();
        uageText = new JTextField();
        utelText = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();
        password = new JPasswordField();
        label6 = new JLabel();
        label7 = new JLabel();
        passwordIdent = new JPasswordField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(unameText);
        unameText.setBounds(205, 65, 220, 45);
        contentPane.add(usexText);
        usexText.setBounds(205, 115, 220, 45);
        contentPane.add(uageText);
        uageText.setBounds(205, 165, 220, 45);
        contentPane.add(utelText);
        utelText.setBounds(205, 215, 220, 45);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(205, 365, 295, 95);

        //---- label1 ----
        label1.setText("\u59d3\u540d");
        contentPane.add(label1);
        label1.setBounds(150, 75, 60, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u6027\u522b");
        contentPane.add(label2);
        label2.setBounds(150, 130, 60, 20);

        //---- label3 ----
        label3.setText("\u5e74\u9f84");
        contentPane.add(label3);
        label3.setBounds(150, 165, 60, 20);

        //---- label4 ----
        label4.setText("\u7535\u8bdd\u53f7\u7801");
        contentPane.add(label4);
        label4.setBounds(130, 225, 60, 20);

        //---- label5 ----
        label5.setText("\u9700\u6c42\u63cf\u8ff0");
        contentPane.add(label5);
        label5.setBounds(130, 380, 60, 20);

        //---- button1 ----
        button1.setText("确定修改");
        button1.addActionListener(e -> userbuttonActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(200, 525, 155, 45);
        contentPane.add(password);
        password.setBounds(205, 265, 220, 40);

        //---- label6 ----
        label6.setText("\u5bc6\u7801");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(165, 275), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(135, 330), label7.getPreferredSize()));
        contentPane.add(passwordIdent);
        passwordIdent.setBounds(205, 315, 220, 43);

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
    private JTextField unameText;
    private JTextField usexText;
    private JTextField uageText;
    private JTextField utelText;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton button1;
    private JPasswordField password;
    private JLabel label6;
    private JLabel label7;
    private JPasswordField passwordIdent;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
