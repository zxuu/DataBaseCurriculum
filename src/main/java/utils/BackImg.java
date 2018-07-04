package utils;

import javax.swing.*;
import java.awt.*;

public class BackImg extends Panel {
    ImageIcon img;

    public BackImg(String iamgeLocation) {
        img = new ImageIcon(iamgeLocation);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
    }


}
