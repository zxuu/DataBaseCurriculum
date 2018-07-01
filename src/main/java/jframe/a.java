package jframe;

import model.DocTableModel;
import model.Doctors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class a extends BaseJFrame{

    Vector<Doctors> doctorsVector;

    public a(Vector<Doctors> doctorsVector) {
        super("医生表",100,100,500,500);
        this.doctorsVector = doctorsVector;
        inint();
        initComponents();
    }

    private void inint() {
//        JTable jTable = new JTable(new DocTableModel(doctorsVector));
//        JScrollPane scroll = new JScrollPane(jTable);
//        add(scroll);
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== dialogPane ========
//        {
//            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
//            dialogPane.setLayout(new BorderLayout());
//
//            //======== contentPanel ========
//            {
//                contentPanel.setLayout(null);
//
//                { // compute preferred size
//                    Dimension preferredSize = new Dimension();
//                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
//                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
//                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
//                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
//                    }
//                    Insets insets = contentPanel.getInsets();
//                    preferredSize.width += insets.right;
//                    preferredSize.height += insets.bottom;
//                    contentPanel.setMinimumSize(preferredSize);
//                    contentPanel.setPreferredSize(preferredSize);
//                }
//            }
//            dialogPane.add(contentPanel, BorderLayout.CENTER);
//
//            //======== buttonBar ========
//            {
//                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
//                buttonBar.setLayout(new GridBagLayout());
//                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
//                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};
//
//                //---- okButton ----
//                okButton.setText("OK");
//                okButton.addActionListener(e -> okButtonActionPerformed(e));
//                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
//                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
//                        new Insets(0, 0, 0, 5), 0, 0));
//
//                //---- cancelButton ----
//                cancelButton.setText("Cancel");
//                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
//                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
//                        new Insets(0, 0, 0, 0), 0, 0));
//            }
//            dialogPane.add(buttonBar, BorderLayout.SOUTH);
//        }
        okButton.addActionListener(e -> okButtonActionPerformed(e));

        JTable jTable = new JTable(new DocTableModel(doctorsVector));
        JScrollPane scroll = new JScrollPane(jTable);
        add(scroll);
        add(okButton);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
