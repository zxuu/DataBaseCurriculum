package DocoterSys;

import utils.BackImg;
import javax.swing.*;
import java.awt.*;

public class FrameSet {

    JFrame windows;
    BackImg backImg;

    Container container;
    public FrameSet(String FrameTitle) {
        windows = new JFrame(FrameTitle);
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container = windows.getContentPane();
    }

    public void setBackImage(String location) {
        backImg = new BackImg(location);
        windows.add(backImg);
    }

    public void setFrame(int winX,int winY,int width,int height){
//        backImg.setBounds(0,0,width,height);
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
