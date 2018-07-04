package jframe;

import com.heweather.sdk.bean.Base;
import model.DocTableModel;
import model.Doctors;
import model.UserSelDoc;
import model.Users;
import utils.JDBCDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

public class ScoreJFrame extends BaseJFrame {

    JTable jTable;
//    Vector<Doctors> allMydocsVector;

    public ScoreJFrame() throws HeadlessException {
        super("评分表",100,100,500,500);
        getContentPane().setBackground(new Color(132, 188, 207));
//        allMydocsVector = new Vector<>();
        initComponents();
    }

    public Vector<Doctors> getVector() {
        Vector<Doctors> allMydocsVector = new Vector<>();
        UserSelDoc userI = new UserSelDoc();
        userI.setUtel(Aplication.userI.getUtel());
        userI.query(UserSelDoc.class, new JDBCDao.QueryListener<UserSelDoc>() {
            @Override
            public void onSucceed(List<UserSelDoc> result) {
                for (int i = 0; i < result.size(); i++) {
                    Doctors myDoctor = new Doctors();
                    myDoctor.setDtel(result.get(i).getDtel());

                    myDoctor.query(Doctors.class, new JDBCDao.QueryListener<Doctors>() {
                        @Override
                        public void onSucceed(List<Doctors> result) {
                            for (int j = 0; j < result.size(); j++) {
                                allMydocsVector.add(result.get(j));
                            }
                        }

                        @Override
                        public void onFailed(Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });

        return allMydocsVector;
    }

    private void button1ActionPerformed(ActionEvent e) {
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (true == (Boolean)jTable.getValueAt(i, 8)) {
                System.out.println("lllllllllllllll");
                Doctors newDoc = new Doctors();
                Doctors oldDoc = new Doctors();
                newDoc.setDscore(String.valueOf(jTable.getValueAt(i,7)));
                oldDoc.setDtel(String.valueOf(jTable.getValueAt(i,3)));
                newDoc.update(oldDoc, new JDBCDao.UpdateListener() {
                    @Override
                    public void onSucceed() {
                        JOptionPane.showMessageDialog(null,"评分成功",
                                "提示",JOptionPane.PLAIN_MESSAGE);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (true == (Boolean)jTable.getValueAt(i, 8)) {
                UserSelDoc userSelDoc = new UserSelDoc();
                userSelDoc.setDtel(String.valueOf(jTable.getValueAt(i,3)));
                userSelDoc.delete(new JDBCDao.DeleteListener() {
                    @Override
                    public void onSucceed() {
//                        update(UI);
                        JOptionPane.showMessageDialog(null,"删除成功",
                                "提示",JOptionPane.PLAIN_MESSAGE);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("确认打分");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(150, 295, 170, button1.getPreferredSize().height);

        button2.setText("确认删除");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(150, 315, 170, button1.getPreferredSize().height);
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        jTable = new JTable(new DocTableModel(getVector()));
        JScrollPane jScrollPane = new JScrollPane(jTable);
        panel1.add(jScrollPane);

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
    private JButton button2;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
