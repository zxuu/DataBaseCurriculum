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
        super(jframeTitle,50,50,1640,940);
        getContentPane().setBackground(new Color(132, 188, 207));
        initComponents();
    }

    private void userlogintnActionPerformed(ActionEvent e) {
        // 用户登陆按钮点击事件
        new UserLogin();
    }

    private void docloginbtnActionPerformed(ActionEvent e) {
        // 医生登陆按钮点击事件
        new DoctorLogin();
    }

    private void docRegiBtn2ActionPerformed(ActionEvent e) {
        // 医生注册按钮点击事件
        new DoctorRegister("医生注册");
    }

    private void userReigsBtnActionPerformed(ActionEvent e) {
        // 用户注册按钮点击事件
        new UserRegister("用户注册");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        userlogintn = new JButton();
        docloginbtn = new JButton();
        userReigsBtn = new JButton();
        docRegiBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- userlogintn ----
        userlogintn.setText("\u7528\u6237\u767b\u9646");
        userlogintn.addActionListener(e -> userlogintnActionPerformed(e));
        contentPane.add(userlogintn);
        userlogintn.setBounds(380, 120, 200, 75);

        //---- docloginbtn ----
        docloginbtn.setText("\u533b\u751f\u767b\u9646");
        docloginbtn.addActionListener(e -> docloginbtnActionPerformed(e));
        contentPane.add(docloginbtn);
        docloginbtn.setBounds(385, 245, 190, 70);

        //---- userReigsBtn ----
        userReigsBtn.setText("\u7528\u6237\u6ce8\u518c");
        userReigsBtn.addActionListener(e -> {
			userReigsBtnActionPerformed(e);
		});
        contentPane.add(userReigsBtn);
        userReigsBtn.setBounds(new Rectangle(new Point(835, 430), userReigsBtn.getPreferredSize()));

        //---- docRegiBtn ----
        docRegiBtn.setText("\u533b\u751f\u6ce8\u518c");
        docRegiBtn.addActionListener(e -> docRegiBtn2ActionPerformed(e));
        contentPane.add(docRegiBtn);
        docRegiBtn.setBounds(new Rectangle(new Point(835, 380), docRegiBtn.getPreferredSize()));

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

    private JButton userlogintn;
    private JButton docloginbtn;
    private JButton userReigsBtn;
    private JButton docRegiBtn;
}
