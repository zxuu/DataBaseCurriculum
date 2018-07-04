package jframe;

import model.DocIModel;
import model.Doctors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class DocIInfo extends BaseJFrame{

    Vector<Doctors> vector;

    public DocIInfo() {
        super("医生表",100,100,500,500);
        getContentPane().setBackground(new Color(132, 188, 207));
        vector = new Vector<>();
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {

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

        vector.add(Aplication.doctorI);
        JTable jTable = new JTable(new DocIModel(vector));
        jTable.setBounds(10, 15, 1070, 645);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        panel1.add(jScrollPane);

        contentPane.add(panel1);
        panel1.setBounds(10, 15, 1070, 645);

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
