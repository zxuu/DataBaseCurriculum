package jframe;

import okhttp3.*;
import org.json.JSONArray;
import model.Doctors;
import org.json.JSONException;
import org.json.JSONObject;
import utils.DocRegHelp;
import utils.HttpUtil;
import utils.Utility;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class DoctorRegister extends BaseJFrame{


    String name,sex,age,tel,docpassword,birth,ID,adress,workunit,workexperence;
    String[] provinces;
    String[] cities;
    String[] counties;
    String provinceName;
    String provinceNumber;
    String cityName;
    String cityNumber;
    String countyName;
    String countyNumber;
    Map<String, Integer> provincesToId;
    Map<String, Integer> citiesToId;
    Map<String, Integer> countiesToId;

    Doctors doctors;
    DocRegHelp docRegHelp;

    public DoctorRegister(String jframetitle) {
        super(jframetitle,100,100,540,1040);
        getContentPane().setBackground(new Color(132, 188, 207));
        doctors = new Doctors();
        provincesToId = new HashMap<>();
        citiesToId = new HashMap<>();
        countiesToId = new HashMap<>();
        initComponents();
        getProvinces();
    }



    private void getProvinces() {
        HttpUtil.sendOkHttpReqquest("http://guolin.tech/api/china", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("responseFail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("provinceresponseSuccess");
                 try {
                     String responseData = response.body().string();
                     JSONArray allProvinces = new JSONArray(responseData);
                    provinces = new String[allProvinces.length()];
                    for (int i = 0; i < allProvinces.length(); i++) {
                        JSONObject provinceObject = allProvinces.getJSONObject(i);
                        provincesToId.put(provinceObject.getString("name"),provinceObject.getInt("id"));
                        provinces[i] = provinceObject.getString("name");
                    }

                    province.setModel(new DefaultComboBoxModel<>(provinces));
                    province.addItemListener(e -> provinceItemStateChanged(e));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                response.close();
            }


        });

    }

    private void buttonregiActionPerformed(ActionEvent e) {
        // TODO add your code here
        name = textField1name.getText();
        sex = textFieldsex.getText();
        age = textFieldage.getText();
        tel = textFieldtel.getText();
        birth = textFieldbirth.getText();
        ID = textFieldID.getText();
        adress = textFieldadress.getText();
        workunit = textFieldworklo.getText();
        workexperence = textAreaworkep.getText();
        docpassword = new String(password.getPassword());

        doctors.setDname(name);
        doctors.setDsex(sex);
        doctors.setDage(age);
        doctors.setDtel(tel);
        doctors.setDbirth(birth);
        doctors.setDID(ID);
        doctors.setDadress(adress);
        doctors.setDworkunit(workunit);
        doctors.setDworkexp(workexperence);
        doctors.setDpassword(docpassword);
        doctors.setProvince(provinceName);
        doctors.setCity(cityName);
        doctors.setCounty(countyName);
        doctors.setDscore("0");

        docRegHelp = new DocRegHelp();
        docRegHelp.writeDocRegModel(doctors);

    }

    private void provinceItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange() == 1) {
            provinceName = (String)province.getSelectedItem();
            int s = provincesToId.get(provinceName);
            provinceNumber = Integer.toString(s);

            HttpUtil.sendOkHttpReqquest("http://guolin.tech/api/china/" + provinceNumber, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println("cityResponseFail");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println("cityresponseSuccess");
                    try {
                        String responseData = response.body().string();
                        JSONArray allCities = new JSONArray(responseData);
                        cities = new String[allCities.length()];
                        for (int i = 0; i < allCities.length(); i++) {
                            JSONObject cityObject = allCities.getJSONObject(i);
                            citiesToId.put(cityObject.getString("name"),cityObject.getInt("id"));
                            cities[i] = cityObject.getString("name");
                        }
                        city.setModel(new DefaultComboBoxModel<>(cities));

                        city.addItemListener(e -> cityItemStateChanged(e));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    response.close();
                }
            });
        }
    }

    private void cityItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange() == 1) {
            cityName = (String)city.getSelectedItem();
            int s = citiesToId.get(cityName);
            cityNumber = Integer.toString(s);
            HttpUtil.sendOkHttpReqquest("http://guolin.tech/api/china/" + provinceNumber + "/" + cityNumber, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println("countyresponseSuccess");
                    try {
                        String responseData = response.body().string();
                        JSONArray allCounties = new JSONArray(responseData);
                        counties = new String[allCounties.length()];
                        for (int i = 0; i < allCounties.length(); i++) {
                            JSONObject countyObject = allCounties.getJSONObject(i);
                            countiesToId.put(countyObject.getString("name"),countyObject.getInt("id"));
                            counties[i] = countyObject.getString("name");
                        }
                        county.setModel(new DefaultComboBoxModel<>(counties));

                        county.addItemListener(e -> countyItemStateChanged(e));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    response.close();
                }
            });
        }
    }

    private void countyItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange() == 1) {
            countyName = (String)county.getSelectedItem();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1name = new JTextField();
        lable = new JLabel();
        textFieldsex = new JTextField();
        textFieldage = new JTextField();
        textFieldtel = new JTextField();
        textFieldbirth = new JTextField();
        textFieldID = new JTextField();
        textFieldadress = new JTextField();
        textFieldworklo = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        textAreaworkep = new JTextArea();
        label8 = new JLabel();
        buttonregi = new JButton();
        labelpassword = new JLabel();
        label9 = new JLabel();
        province = new JComboBox<>();
        password = new JPasswordField();
        passwordIdent = new JPasswordField();
        city = new JComboBox<>();
        county = new JComboBox<>();
        籍贯 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1name);
        textField1name.setBounds(155, 30, 250, 45);

        //---- lable ----
        lable.setText("\u59d3\u540d");
        contentPane.add(lable);
        lable.setBounds(105, 40, 50, lable.getPreferredSize().height);
        contentPane.add(textFieldsex);
        textFieldsex.setBounds(155, 85, 250, 45);
        contentPane.add(textFieldage);
        textFieldage.setBounds(155, 140, 250, 45);
        contentPane.add(textFieldtel);
        textFieldtel.setBounds(155, 195, 250, 45);
        contentPane.add(textFieldbirth);
        textFieldbirth.setBounds(160, 410, 250, 45);
        contentPane.add(textFieldID);
        textFieldID.setBounds(160, 485, 250, 45);
        contentPane.add(textFieldadress);
        textFieldadress.setBounds(160, 550, 250, 45);
        contentPane.add(textFieldworklo);
        textFieldworklo.setBounds(160, 625, 250, 45);

        //---- label1 ----
        label1.setText("\u6027\u522b");
        contentPane.add(label1);
        label1.setBounds(105, 100, 50, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5e74\u9f84");
        contentPane.add(label2);
        label2.setBounds(105, 150, 49, 20);

        //---- label3 ----
        label3.setText("\u51fa\u751f\u5e74\u6708");
        contentPane.add(label3);
        label3.setBounds(80, 420, 70, 20);

        //---- label4 ----
        label4.setText("\u8eab\u4efd\u8bc1\u53f7");
        contentPane.add(label4);
        label4.setBounds(75, 500, 70, 20);

        //---- label5 ----
        label5.setText("\u8be6\u7ec6\u5730\u5740");
        contentPane.add(label5);
        label5.setBounds(75, 565, 70, 20);

        //---- label6 ----
        label6.setText("\u7535\u8bdd");
        contentPane.add(label6);
        label6.setBounds(105, 205, 30, 20);

        //---- label7 ----
        label7.setText("\u5de5\u4f5c\u5355\u4f4d");
        contentPane.add(label7);
        label7.setBounds(75, 640, 65, 20);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textAreaworkep);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(160, 690, 250, 135);

        //---- label8 ----
        label8.setText("\u5de5\u4f5c\u7ecf\u5386");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(80, 695), label8.getPreferredSize()));

        //---- buttonregi ----
        buttonregi.setText("\u6ce8\u518c");
        buttonregi.addActionListener(e -> buttonregiActionPerformed(e));
        contentPane.add(buttonregi);
        buttonregi.setBounds(195, 855, 150, buttonregi.getPreferredSize().height);

        //---- labelpassword ----
        labelpassword.setText("\u5bc6\u7801");
        contentPane.add(labelpassword);
        labelpassword.setBounds(new Rectangle(new Point(105, 265), labelpassword.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label9);
        label9.setBounds(85, 315, 70, 20);

        //---- province ----
        province.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u7701"
        }));
//        province.addItemListener(e -> provinceItemStateChanged(e));
        contentPane.add(province);
        province.setBounds(155, 360, 75, province.getPreferredSize().height);
        contentPane.add(password);
        password.setBounds(155, 250, 250, 45);
        contentPane.add(passwordIdent);
        passwordIdent.setBounds(155, 305, 250, 40);

        //---- city ----
        city.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5e02"
        }));
//        city.addItemListener(e -> cityItemStateChanged(e));
        contentPane.add(city);
        city.setBounds(230, 360, 85, city.getPreferredSize().height);

        //---- county ----
        county.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u533a/\u53bf"
        }));
//        county.addItemListener(e -> countyItemStateChanged(e));
        contentPane.add(county);
        county.setBounds(315, 360, 93, county.getPreferredSize().height);

        //---- 籍贯 ----
        籍贯.setText("\u7c4d\u8d2f");
        contentPane.add(籍贯);
        籍贯.setBounds(new Rectangle(new Point(100, 365), 籍贯.getPreferredSize()));

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
    private JTextField textField1name;
    private JLabel lable;
    private JTextField textFieldsex;
    private JTextField textFieldage;
    private JTextField textFieldtel;
    private JTextField textFieldbirth;
    private JTextField textFieldID;
    private JTextField textFieldadress;
    private JTextField textFieldworklo;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTextArea textAreaworkep;
    private JLabel label8;
    private JButton buttonregi;
    private JLabel labelpassword;
    private JLabel label9;
    private JComboBox<String> province;
    private JPasswordField password;
    private JPasswordField passwordIdent;
    private JComboBox<String> city;
    private JComboBox<String> county;
    private JLabel 籍贯;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
