package jframe;

import bean.DocJpane;
import bean.userJpane;
import utils.JDBCSetting;
import utils.SysMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class doctorJFrame extends BaseJFrame {

    List<JMenu> jMenuList = new ArrayList<>();
    SysMenu sysMenu;

    public doctorJFrame() {
        super("医生界面",50,50,1000,1000);

        sysMenu = new SysMenu(new JMenu("w"), new JMenu("c"));
        jMenuList = sysMenu.getjMenuList();
        menuListener();
        setJMenuBar(sysMenu.AddMenue());
        initComponents();
    }

    private void menuListener() {
        JMenuItem jMenuItem1 = new JMenuItem("我的信息");
        JMenuItem jMenuItem2 = new JMenuItem("修改信息");
        jMenuList.get(0).add(jMenuItem1);
        jMenuList.get(0).add(jMenuItem2);
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("我的信息");
                iniTable();
            }
        });
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("修改信息");
                alterInfo();
            }
        });
    }

    private void alterInfo() {
//        new AlterUserInfo("修改用户信息");
        new AlterDocInfo("修改医生信息");
    }

    public void iniTable() {
//        String[] columnNames = {"姓名","性别","年龄","电话号码","情况描述","密码"};
//        String[][] iIfo = new String[2][6];
//        try {
//            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            resultSet = sql.executeQuery("SELECT * FROM Users ");
//            if (resultSet.absolute(Aplication.row)) {
//                for (int i = 0; i < 2; i++) {
//                    for (int j = 0; j < 6; j++) {
//                        iIfo[i][j] = resultSet.getString(j + 1);
//                    }
//                }
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        table = new JTable(iIfo, columnNames);
//        table.setSize(1500,1500);
//        add(table);
//        this.getContentPane().add(new userJpane());
//        setContentPane(new userJpane());
        setContentPane(new DocJpane());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
