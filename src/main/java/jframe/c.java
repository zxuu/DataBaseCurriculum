/*
 * Created by JFormDesigner on Mon Jul 02 03:26:23 CST 2018
 */

package jframe;

import model.DocTableModel;
import model.Doctors;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 * @author we
 */
public class c extends BaseJFrame {
    JTable jTable;

    Vector<Doctors> doctorsVector;
    public c(Vector<Doctors> doctorsVector) {
        super("医生表",100,100,500,500);
        this.doctorsVector = doctorsVector;
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if ((Boolean)jTable.getValueAt(i, 7) == true) {
                System.out.println("lllllllllllllll");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("text");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(150, 295, 170, button1.getPreferredSize().height);

        jTable = new JTable(new DocTableModel(doctorsVector));
        JScrollPane scroll = new JScrollPane(jTable);
        panel1.add(scroll);

        contentPane.add(panel1);
        panel1.setBounds(10, 15, 470, 245);

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
