package jframe;
import model.DocIModel;
import model.Doctors;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class doctorJFrame extends BaseJFrame {

    List<JMenu> jMenuList = new ArrayList<>();
    SysMenu sysMenu;

    public doctorJFrame() {
        super("医生界面",50,50,1000,1000);
        getContentPane().setBackground(new Color(132, 188, 207));
        sysMenu = new SysMenu(new JMenu("信息"), new JMenu("查找"));
        jMenuList = sysMenu.getjMenuList();
        menuListener();
        setJMenuBar(sysMenu.AddMenue());
        initComponents();
    }

    private void menuListener() {
        JMenuItem jMenuItem1 = new JMenuItem("我的信息");
        JMenuItem jMenuItem2 = new JMenuItem("修改信息");
        JMenuItem jMenuItem3 = new JMenuItem("注销信息");
        jMenuList.get(0).add(jMenuItem1);
        jMenuList.get(0).add(jMenuItem2);
        jMenuList.get(0).add(jMenuItem3);
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

        jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("注销信息");
                resultSetHelp resultSetHelp = utils.resultSetHelp.getresultSetHelpInstance();
                resultSetHelp.setResultSet(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, "SELECT * FROM Doctors",
                        Aplication.drow, new getResultSet() {
                            @Override
                            public void getResultSetSuccess(ResultSet resultSet, Connection connection) {
                                Doctors doctor = new Doctors();
                                try {
                                    doctor.setDtel(resultSet.getString(4));
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                                doctor.delete(new JDBCDao.DeleteListener() {
                                    @Override
                                    public void onSucceed() {
                                        JOptionPane.showMessageDialog(null,"注销成功",
                                                "提示",JOptionPane.WARNING_MESSAGE);
                                    }

                                    @Override
                                    public void onFailed(Exception e) {
                                        JOptionPane.showMessageDialog(null,"注销失败",
                                                "提示",JOptionPane.WARNING_MESSAGE);
                                        e.printStackTrace();
                                    }
                                });
                            }
                        });
            }
        });
    }

    private void alterInfo() {
        new AlterDocInfo("修改医生信息");
    }

    public void iniTable() {
        new DocIInfo();
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
}
