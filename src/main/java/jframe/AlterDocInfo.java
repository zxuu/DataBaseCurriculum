package jframe;

import utils.getResultSet;
import utils.resultSetHelp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlterDocInfo extends BaseJFrame{

    public AlterDocInfo(String jframetitle) {
        super(jframetitle,100,100,540,1040);
        getContentPane().setBackground(new Color(132, 188, 207));
        initComponents();
    }

    private void buttonregiActionPerformed(ActionEvent e) {
        // TODO add your code here
        resultSetHelp resultSetHelp = utils.resultSetHelp.getresultSetHelpInstance();
        resultSetHelp.setResultSet(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, "SELECT * FROM Doctors",
                Aplication.drow, new getResultSet() {
                    @Override
                    public void getResultSetSuccess(ResultSet resultSet, Connection connection) {
                        System.out.println("getResultSuccess!");
                        try {
                            resultSet.updateString(1,textField1name.getText());
                            resultSet.updateString(2,textFieldsex.getText());
                            resultSet.updateString(3,textFieldage.getText());
                            resultSet.updateString(4,textFieldtel.getText());
                            resultSet.updateString(5,textFieldbirth.getText());
                            resultSet.updateString(6,textFieldID.getText());
                            resultSet.updateString(7,textFieldadress.getText());
                            resultSet.updateString(8,textFieldworklo.getText());
                            resultSet.updateString(9,textAreaworkep.getText());
                            resultSet.updateString(10,new String(password.getPassword()));
                            resultSet.updateRow();
                            connection.close();
                            System.out.println("修改医生信息成功");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1name = new JTextField();
        lable = new JLabel();
        textFieldsex = new JTextField();
        textFieldage = new JTextField();
        textFieldtel = new JTextField();
        textFieldbirth = new JTextField();
        textFieldID = new JTextField();
        textFieldadress = new JTextField();
        textFieldworklo = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        textAreaworkep = new JTextArea();
        label8 = new JLabel();
        buttonregi = new JButton();
        labelpassword = new JLabel();
        label9 = new JLabel();
        comboBox1 = new JComboBox<>();
        password = new JPasswordField();
        passwordIdent = new JPasswordField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1name);
        textField1name.setBounds(155, 30, 250, 45);

        //---- lable ----
        lable.setText("\u59d3\u540d");
        contentPane.add(lable);
        lable.setBounds(105, 40, 50, lable.getPreferredSize().height);
        contentPane.add(textFieldsex);
        textFieldsex.setBounds(155, 85, 250, 45);
        contentPane.add(textFieldage);
        textFieldage.setBounds(155, 140, 250, 45);
        contentPane.add(textFieldtel);
        textFieldtel.setBounds(155, 195, 250, 45);
        contentPane.add(textFieldbirth);
        textFieldbirth.setBounds(160, 410, 250, 45);
        contentPane.add(textFieldID);
        textFieldID.setBounds(160, 485, 250, 45);
        contentPane.add(textFieldadress);
        textFieldadress.setBounds(160, 550, 250, 45);
        contentPane.add(textFieldworklo);
        textFieldworklo.setBounds(160, 625, 250, 45);

        //---- label1 ----
        label1.setText("\u6027\u522b");
        contentPane.add(label1);
        label1.setBounds(105, 100, 50, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5e74\u9f84");
        contentPane.add(label2);
        label2.setBounds(105, 150, 49, 20);

        //---- label3 ----
        label3.setText("\u51fa\u751f\u5e74\u6708");
        contentPane.add(label3);
        label3.setBounds(80, 420, 70, 20);

        //---- label4 ----
        label4.setText("\u8eab\u4efd\u8bc1\u53f7");
        contentPane.add(label4);
        label4.setBounds(75, 500, 70, 20);

        //---- label5 ----
        label5.setText("\u5bb6\u5ead\u4f4f\u5740");
        contentPane.add(label5);
        label5.setBounds(75, 565, 70, 20);

        //---- label6 ----
        label6.setText("\u7535\u8bdd");
        contentPane.add(label6);
        label6.setBounds(105, 205, 30, 20);

        //---- label7 ----
        label7.setText("\u5de5\u4f5c\u5355\u4f4d");
        contentPane.add(label7);
        label7.setBounds(75, 640, 65, 20);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textAreaworkep);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(160, 690, 250, 135);

        //---- label8 ----
        label8.setText("\u5de5\u4f5c\u7ecf\u5386");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(80, 695), label8.getPreferredSize()));

        //---- buttonregi ----
        buttonregi.setText("确认修改");
        buttonregi.addActionListener(e -> buttonregiActionPerformed(e));
        contentPane.add(buttonregi);
        buttonregi.setBounds(195, 855, 150, buttonregi.getPreferredSize().height);

        //---- labelpassword ----
        labelpassword.setText("\u5bc6\u7801");
        contentPane.add(labelpassword);
        labelpassword.setBounds(new Rectangle(new Point(105, 265), labelpassword.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label9);
        label9.setBounds(85, 315, 70, 20);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5317\u4eac",
                "\u4e0a\u6d77"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(155, 360), comboBox1.getPreferredSize()));
        contentPane.add(password);
        password.setBounds(155, 250, 250, 45);
        contentPane.add(passwordIdent);
        passwordIdent.setBounds(155, 305, 250, 40);

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
//        pack();
//        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1name;
    private JLabel lable;
    private JTextField textFieldsex;
    private JTextField textFieldage;
    private JTextField textFieldtel;
    private JTextField textFieldbirth;
    private JTextField textFieldID;
    private JTextField textFieldadress;
    private JTextField textFieldworklo;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTextArea textAreaworkep;
    private JLabel label8;
    private JButton buttonregi;
    private JLabel labelpassword;
    private JLabel label9;
    private JComboBox<String> comboBox1;
    private JPasswordField password;
    private JPasswordField passwordIdent;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
