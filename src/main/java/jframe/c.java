/*
 * Created by JFormDesigner on Tue Jul 03 11:33:29 CST 2018
 */

package jframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author we
 */
public class c extends JFrame {
    public c() {
        getContentPane().setBackground(new Color(132, 188, 207));
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u9009\u62e9");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(150, 295, 170, button1.getPreferredSize().height);
        contentPane.add(panel1);
        panel1.setBounds(10, 15, 470, 270);

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
    private JButton button1;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
