/*
 * Created by JFormDesigner on Sat Jun 30 16:40:09 CST 2018
 */

package bean;

import java.awt.event.*;
import model.Doctors;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author we
 */
public class DocListJpane extends JPanel {
    String[][] doctorIfo;
    String[] colum;

    Doctors doctor;

    public DocListJpane(Doctors doctor) {
        this.doctor = doctor;
        setVisible(true);
        inintInfo();
        initComponents();
    }

    private void inintInfo() {
        String name = doctor.getDname();
        String sex = doctor.getDsex();
        String age = doctor.getDage();
        String addres = doctor.getDadress();
        String workunit = doctor.getDworkunit();
        String workexp = doctor.getDworkexp();
        doctorIfo = new String[][]{{name, sex, age, addres, workunit, workexp},{name, sex, age, addres, workunit, workexp}};
        colum = new String[]{"姓名", "性别", "年龄", "住址", "工作单位", "工作经历"};
    }


    public JButton getButton() {
        return button1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        table1 = new JTable();

        //======== this ========
        setLayout(null);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u9009\u62e9");
        add(button1);
        button1.setBounds(825, 40, 150, 55);
        add(table1);
        table1.setBounds(5, 55, 815, 50);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JTable table1;



    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
