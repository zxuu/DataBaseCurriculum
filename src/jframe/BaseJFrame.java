package jframe;

import utils.BackImg;

import javax.swing.*;
import java.awt.*;

public class BaseJFrame extends JFrame {

    BackImg backImg;

    Container container;

    public BaseJFrame(String jframeTitle) throws HeadlessException {
        super(jframeTitle);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container = this.getContentPane();
    }

    public void setFrame(int winX,int winY,int width,int height){
//        backImg.setBounds(0,0,width,height);
        this.setBounds(winX,winY,width,height);
    }

    public void setBackImage(String location) {
        backImg = new BackImg(location);
        this.add(backImg);
    }

//    public void setMenuBar() {
//        windows.setJMenuBar(sysMenu.AddMenue());
//    }

    public Container getContainer(){
        return  container;
    }

    public JFrame getJFrame() {
        return this;
    }
}
