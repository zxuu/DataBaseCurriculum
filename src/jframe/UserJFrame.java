/*
 * Created by JFormDesigner on Sat Jun 23 13:25:55 CST 2018
 */

package jframe;

import utils.OnClickListener;
import utils.SysMenu;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.View;

/**
 * @author we
 */
public class UserJFrame extends BaseJFrame{

    SysMenu sysMenu;

    public UserJFrame() {
        super("用户界面",50,50,1000,1000);
        sysMenu = new SysMenu();
        setJMenuBar(sysMenu.AddMenue());
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
