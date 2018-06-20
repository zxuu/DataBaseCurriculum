package DocoterSys;

import utils.BackImg;
import utils.SysMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FrameSet {

    JFrame windows;
    BackImg backImg;

    Container container;

    public FrameSet(String FrameTitle, String imageLocation) {
        windows = new JFrame(FrameTitle);
        backImg = new BackImg(imageLocation);

        container = windows.getContentPane();
    }


    public void setFrame(int winX,int winY,int width,int height){
//        Container container = windows.getContentPane();
        backImg.setBounds(0,0,width,height);
        windows.setBounds(winX,winY,width,height);
        windows.add(backImg);
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

//    public void setMenuBar() {
//        windows.setJMenuBar(sysMenu.AddMenue());
//    }

    public Container getContainer(){
        return  container;
    }

    public JFrame getJFrame() {
        return windows;
    }
}
