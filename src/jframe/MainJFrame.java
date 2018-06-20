/*
 * Created by JFormDesigner on Thu Jun 21 05:18:31 CST 2018
 */

package jframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author we
 */
public class MainJFrame extends BaseJFrame{



    public MainJFrame(String jframeTitle) {
        super(jframeTitle);
        setFrame(100,100,840,840);
        initComponents();
    }

    private void userlogintnActionPerformed(ActionEvent e) {
        // TODO add your code here
        new UserRegister("医生注册");
    }

    private void docloginbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        new DoctorRegister("医生注册");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        userlogintn = new JButton();
        docloginbtn = new JButton();

        //======== this ========
        Container contentPane = getContainer();
        contentPane.setLayout(null);

        //---- userlogintn ----
        userlogintn.setText("\u7528\u6237\u767b\u9646");
        userlogintn.addActionListener(e -> userlogintnActionPerformed(e));
        contentPane.add(userlogintn);
        userlogintn.setBounds(280, 115, 285, 70);

        //---- docloginbtn ----
        docloginbtn.setText("\u533b\u751f\u767b\u9646");
        docloginbtn.addActionListener(e -> docloginbtnActionPerformed(e));
        contentPane.add(docloginbtn);
        docloginbtn.setBounds(280, 250, 285, 70);

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
//        pack();
//        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton userlogintn;
    private JButton docloginbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
