package DocoterSys;
import utils.FrameSet;
import utils.SysMenu;

import javax.swing.*;


public class SysView extends JFrame{

    public static void main(String[] args) {

        SysMenu sysMenu = new SysMenu();
        FrameSet SysFrame = new FrameSet("家庭信息管理系统");
        SysFrame.getJFrame().setJMenuBar(sysMenu.AddMenue());
        SysFrame.setFrame(300,200,1000,600);

    }



}
