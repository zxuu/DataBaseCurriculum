package DocoterSys;

import utils.BackImg;
import javax.swing.*;
import java.awt.*;

public class FrameSet {

    JFrame windows;
    BackImg backImg;

    Container container;
    public FrameSet(String FrameTitle, String imageLocation) {
        windows = new JFrame(FrameTitle);

//        jPanel = new JPanel();
//        jPanel.setOpaque(false);
//        windows.setContentPane(jPanel);

        backImg = new BackImg(imageLocation);
        windows.add(backImg);
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container = windows.getContentPane();
    }


    public void setFrame(int winX,int winY,int width,int height){
        backImg.setBounds(0,0,width,height);
        windows.setBounds(winX,winY,width,height);
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
