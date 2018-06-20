package utils;

import jframe.DoctorRegister;
import jframe.UserRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SysMenu extends Menu {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("系统");
    JMenuItem menuItem1,menuItem2;

    public SysMenu() throws HeadlessException {

        menuItem1 = new JMenuItem("用户注册");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item1ClickResult();
            }
        });
        menuItem2 = new JMenuItem("医生注册");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item2ClickResult();
            }
        });
    }

    private void Item1ClickResult() {
        new UserRegister();
    }

    private void Item2ClickResult() {
        new DoctorRegister();
    }

    public JMenuBar AddMenue() {
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        return menuBar;
    }

    public JMenu getMenu() {
        return menu;
    }
}
