/*
 * Created by JFormDesigner on Thu Jun 21 04:22:35 CST 2018
 */

package jframe;

import model.Users;
import utils.UserRegHelp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author we
 */
public class UserRegister extends BaseJFrame{



    Users users;
    UserRegHelp userRegHelp;


    public UserRegister(String jframeTitle) {
        super(jframeTitle,100,100,540,1040);
        users = new Users();
        initComponents();
    }

    private void userbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
        users.setUname(unameText.getText());
        users.setUsex(usexText.getText());
        users.setUage(uageText.getText());
        users.setUtel(utelText.getText());
        users.setUdescribe(textArea1.getText());
        users.setUpassword(new String(password.getPassword()));
        userRegHelp = new UserRegHelp();
        userRegHelp.writeUserRegModel(users);
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
        button1.setText("\u6ce8\u518c");
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
