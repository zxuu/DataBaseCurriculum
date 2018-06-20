package DocoterSys;
import utils.SysMenu;

import javax.swing.*;
import java.awt.*;


public class SysView extends JFrame{

    public static void main(String[] args) {

        SysMenu sysMenu = new SysMenu();
        FrameSet frameSet = new FrameSet("家庭信息管理系统","E://Pictures//do.jpg");
        frameSet.getJFrame().setJMenuBar(sysMenu.AddMenue());
        frameSet.setFrame(300,200,1000,600);

    }



}
