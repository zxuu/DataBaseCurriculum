/*
 * Created by JFormDesigner on Sat Jun 23 13:25:55 CST 2018
 */

package jframe;


import bean.UserCheckDocJPane;
import model.Users;
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

/**
 * @author we
 */
public class UserJFrame extends BaseJFrame{

    List<JMenu> jMenuList = new ArrayList<>();
    SysMenu sysMenu;

    public UserJFrame() {
        super("用户界面",50,50,1000,1000);
        getContentPane().setBackground(new Color(132, 188, 207));
        sysMenu = new SysMenu(new JMenu("信息"), new JMenu("查找"));
        jMenuList = sysMenu.getjMenuList();
        menuListener();
        setJMenuBar(sysMenu.AddMenue());
    }

    private void menuListener() {
        JMenuItem jMenuItem1 = new JMenuItem("我的信息");
        JMenuItem jMenuItem2 = new JMenuItem("修改信息");
        JMenuItem jMenuItem3 = new JMenuItem("查找新的家庭医生");
        JMenuItem jMenuItem4 = new JMenuItem("注销信息");
        JMenuItem jMenuItem5 = new JMenuItem("我的医生");
        jMenuList.get(0).add(jMenuItem1);
        jMenuList.get(0).add(jMenuItem2);
        jMenuList.get(1).add(jMenuItem3);
        jMenuList.get(0).add(jMenuItem4);
        jMenuList.get(1).add(jMenuItem5);
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
                System.out.println("查找医生");
                new UserCheckDocJPane();
            }
        });
        jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("注销信息");

                Users users = new Users();
                users.setUtel(Aplication.userI.getUtel());
                users.delete(new JDBCDao.DeleteListener() {
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

        jMenuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScoreJFrame();
            }
        });
    }

    private void alterInfo() {
        new AlterUserInfo("修改用户信息");
    }

    public void iniTable() {
        JTable table1 = new JTable();
        JScrollPane jsPanel = new JScrollPane(table1);
        jsPanel.add(table1);
        setContentPane(jsPanel);
    }
}
