package activity;

import DocoterSys.FrameSet;

import javax.swing.*;
import java.awt.*;

public class DoctorRigister {

//    JTextField name;
//    JTextField sex;
//    JTextField age;
//    JTextField IDNumber;
//    JTextField adrees;
//    JTextField phonenumber;
//    JTextField workunit;
//    JTextArea workexperience;
//
//    Container container;
//    JPanel jPanel;
//
//    public DoctorRigister() {
//        super("医生注册","E://Pictures//docregister.jpg");
//        setFrame(350,250,500,600);
//
//        name = new JTextField("姓名");
//        sex = new JTextField("性别");
//        age = new JTextField("年龄");
//        IDNumber = new JTextField("身份证号");
//        adrees = new JTextField("住址");
//        phonenumber = new JTextField("电话号码");
//        workunit = new JTextField("工作单位");
//        workexperience = new JTextArea();
//
////        name.setBounds(355,255,20,15);
//
//        container = getContainer();
////        container.setLayout(new BorderLayout());
//
//        jPanel = new JPanel();
////        jPanel.setLayout(new GridLayout(8,1));
//        jPanel.add(name);
//        jPanel.add(sex);
//        jPanel.add(age);
//        jPanel.add(IDNumber);
//        jPanel.add(adrees);
//        jPanel.add(phonenumber);
//        jPanel.add(workunit);
//        jPanel.add(workexperience);
//
//        container.add(jPanel);
//
//    }

    FrameSet frameSet;
    JPanel jp;
    JTextField name,sex,age,IDNumber,adrees,phonenumber,workunit;
    JTextArea workexperience;

    JFrame jf;
    public DoctorRigister() {

        frameSet = new FrameSet("医生登陆","E://Pictures//do.jpg");
//        frameSet.setFrame(350,250,500,600);

        jf = frameSet.getJFrame();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = jf.getContentPane();
        contentPane.setLayout(new BorderLayout());

        jp = new JPanel();
        jp.setLayout(new GridLayout(10,1));

        name = new JTextField();
        sex = new JTextField("姓名");
        age = new JTextField("年龄");
        IDNumber = new JTextField("身份证号");
        adrees = new JTextField("住址");
        phonenumber = new JTextField("电话号码");
        workunit = new JTextField("工作单位");
        workexperience = new JTextArea("工作单位");

//        jtf3.setEnabled(false);
//        jtf4.setFont(new Font("谐体",Font.BOLD|Font.ITALIC,16));
        //设置文本的水平对齐方式
//        jtf4.setHorizontalAlignment(JTextField.CENTER);

        jp.add(name);
        jp.add(sex);
        jp.add(age);
        jp.add(IDNumber);
        jp.add(adrees);
        jp.add(phonenumber);
        jp.add(workunit);
        jp.add(workexperience);

        contentPane.add(jp);

        jf.pack();
        jf.setLocation(400, 200);
        jf.setVisible(true);


    }

}
