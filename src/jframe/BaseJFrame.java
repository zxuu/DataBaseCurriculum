package jframe;

import utils.BackImg;
import utils.OnClickListener;

import javax.swing.*;
import java.awt.*;

public class BaseJFrame extends JFrame{

    BackImg backImg;

    Container container;

    public BaseJFrame(String jframeTitle) throws HeadlessException {
        super(jframeTitle);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container = this.getContentPane();
    }

    public BaseJFrame(String jframeTitle, int winX, int winY, int width, int height) {
        super(jframeTitle);
        super.setVisible(true);
        super.setBounds(winX,winY,width,height);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container = super.getContentPane();
    }


    public void setBackImage(String location) {
        backImg = new BackImg(location);
        this.add(backImg);
    }

//    public void setMenuBar() {
//        this.setJMenuBar(sysMenu.AddMenue());
//    }

    public Container getContainer(){
        return  container;
    }

    public JFrame getJFrame() {
        return this;
    }

}
