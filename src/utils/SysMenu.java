package utils;

import javafx.application.Application;
import jframe.DoctorRegister;
import jframe.UserRegister;
import model.Doctors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SysMenu{
    OnClickListener onClickListener;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem1,menuItem2;
    int clickIem = 0;

    public SysMenu() throws HeadlessException {
        menuBar = new JMenuBar();
        menu = new JMenu("系统");
        menuItem1 = new JMenuItem("修改信息");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item1ClickResult();
            }
        });
        menuItem2 = new JMenuItem("查看信息");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item2ClickResult();
            }
        });


    }

    private void Item1ClickResult() {

    }

    private void Item2ClickResult() {
        Doctors doctor = new Doctors();
        doctor.setDname("zxu");
        doctor.setDtel("18255713582");
        doctor.query(Doctors.class, new JDBCDao.QueryListener<Doctors>() {
            @Override
            public void onSucceed(List<Doctors> result) {
                System.out.println("ddfds");
                if (result != null) {
                    System.out.println("not null");
                }
                for (Doctors d : result) {
                    System.out.println(d.getDname());
                }
            }

            @Override
            public void onFailed(Exception e) {
                System.out.println(e.getMessage());
            }
        });
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

    public void setOnClickListener(OnClickListener onClickListener) {
        onClickListener.OnClick(clickIem);
    }


}
