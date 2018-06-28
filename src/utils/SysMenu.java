package utils;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SysMenu{

    JMenuBar menuBar;
    List<JMenu> jMenuList = new ArrayList<>();

    public SysMenu(JMenu... menus) {
        menuBar = new JMenuBar();
        for (JMenu jmenu : menus) {
            jMenuList.add(jmenu);
            menuBar.add(jmenu);
        }
    }

    public List<JMenu> getjMenuList(){
        return jMenuList;
    }
//    JMenuItem menuItem1,menuItem2;

//    public SysMenu() throws HeadlessException {
//        menuBar = new JMenuBar();
//        menu = new JMenu("系统");
//        menuItem1 = new JMenuItem("修改信息");
//        menuItem1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Item1ClickResult();
//            }
//        });
//        menuItem2 = new JMenuItem("查看信息");
//        menuItem2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Item2ClickResult();
//            }
//        });
//
//
//    }





    public JMenuBar AddMenue() {
        return menuBar;
    }




}
