/*
 * Created by JFormDesigner on Mon Jul 02 03:26:23 CST 2018
 */

package jframe;

import model.DocTableModel;
import model.Doctors;
import model.UserSelDoc;
import utils.JDBCDao;
import utils.SysMenu;
import utils.getResultSet;
import utils.resultSetHelp;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;

/**
 * @author we
 */
public class UserIInfo extends BaseJFrame {
    JTable jTable;
    List<JMenu> jMenuList = new ArrayList<>();
    SysMenu sysMenu;

    String Uname,Utel,Dname,Dtelph;

    Vector<Doctors> doctorsVector;
    Vector<Doctors> doctorsArry;
    int l;
    public UserIInfo(Vector<Doctors> doctorsVector) {
        super("医生信息表",100,100,500,500);
        getContentPane().setBackground(new Color(132, 188, 207));
        sysMenu = new SysMenu(new JMenu("确认添加"));
        jMenuList = sysMenu.getjMenuList();
        l = 0;
        doctorsArry = new Vector<>();
        this.doctorsVector = doctorsVector;
        initComponents();
        menuListener();
        setJMenuBar(sysMenu.AddMenue());
    }

    private void menuListener() {
        JMenuItem jMenuItem1 = new JMenuItem("我的信息");
        jMenuList.get(0).add(jMenuItem1);
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jTable.getRowCount(); i++) {
                    if (true == (Boolean)jTable.getValueAt(i, 8)) {
                        System.out.println("lllllllllllllll");
                        createUserSelDocTable(String.valueOf(jTable.getValueAt(i,3)));
                        Aplication.doctorArry = doctorsArry;
                    }
                }
            }
        });
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (true == (Boolean)jTable.getValueAt(i, 8)) {
                System.out.println("lllllllllllllll");
                createUserSelDocTable(String.valueOf(jTable.getValueAt(i,3)));
                Aplication.doctorArry = doctorsArry;
            }
        }
    }

    private void createUserSelDocTable(String Dtel) {

        resultSetHelp resultSetHelp = utils.resultSetHelp.getresultSetHelpInstance();
        resultSetHelp.setResultSet(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,
                "SELECT * FROM Users ", Aplication.row, new getResultSet() {
                    @Override
                    public void getResultSetSuccess(ResultSet resultSet, Connection connection) {
                        try {
                            Uname = resultSet.getString(1);
                            Utel = resultSet.getString(4);

                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Doctors doctor = new Doctors();
        doctor.setDtel(Dtel);
        doctor.query(Doctors.class, new JDBCDao.QueryListener<Doctors>() {
            @Override
            public void onSucceed(List<Doctors> result) {
                for (int j = 0; j < result.size(); j++) {
                    doctorsArry.add(result.get(j));
                    Dname = result.get(j).getDname();
                    Dtelph = result.get(j).getDtel();
                }
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });

        UserSelDoc userSelDoc = new UserSelDoc();
        userSelDoc.setUname(Uname);
        userSelDoc.setUtel(Utel);
        userSelDoc.setDname(Dname);
        userSelDoc.setDtel(Dtelph);
        System.out.println(Uname);
        System.out.println(Utel);
        System.out.println(Dname);
        System.out.println(Dtelph);
        userSelDoc.save(new JDBCDao.SaveListerner() {
            @Override
            public void onSucceed() {
                JOptionPane.showMessageDialog(null,"添加成功","" +
                        "恭喜",JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void onFailed(Exception e) {
                JOptionPane.showMessageDialog(null,"添加失败","" +
                        "提示",JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void initComponents() {
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
//        button1 = new JButton();
//        panel1 = new JPanel();
//
//        //======== this ========
//        Container contentPane = getContentPane();
//        contentPane.setLayout(null);
//
//        //---- button1 ----
//        button1.setText("\u786e\u8ba4\u9009\u62e9");
//        button1.addActionListener(e -> button1ActionPerformed(e));
//        contentPane.add(button1);
//        button1.setBounds(150, 295, 170, button1.getPreferredSize().height);
//
//        jTable = new JTable(new DocTableModel(doctorsVector));
//        JScrollPane scroll = new JScrollPane(jTable);
//        scroll.setBounds(10,15,470,300);
////        panel1.setBounds(9,14,470,310);
////        panel1.add(scroll);
//
//        contentPane.add(scroll);
////        panel1.setBounds(10, 15, 470, 245);
//
//        { // compute preferred size
//            Dimension preferredSize = new Dimension();
//            for(int i = 0; i < contentPane.getComponentCount(); i++) {
//                Rectangle bounds = contentPane.getComponent(i).getBounds();
//                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
//                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
//            }
//            Insets insets = contentPane.getInsets();
//            preferredSize.width += insets.right;
//            preferredSize.height += insets.bottom;
//            contentPane.setMinimumSize(preferredSize);
//            contentPane.setPreferredSize(preferredSize);
//        }
//        pack();
//        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        jTable = new JTable(new DocTableModel(doctorsVector));

        /* 用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看 */
        JScrollPane scroll = new JScrollPane(jTable);
        add(scroll);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
