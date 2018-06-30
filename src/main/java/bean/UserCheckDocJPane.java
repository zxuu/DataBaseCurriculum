/*
 * Created by JFormDesigner on Sat Jun 30 17:33:44 CST 2018
 */

package bean;

import jframe.test;
import model.Doctors;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.HttpUtil;
import utils.JDBCDao;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 * @author we
 */
public class UserCheckDocJPane extends JPanel {

    String[] provinces;
    String[] cities;
    String[] counties;
    String provinceName;
    String provinceNumber;
    String cityName;
    String cityNumber;
    String countyName;
    String countyNumber;
    String Dsex;
    String Dage;
    String Dscore;
    Map<String, Integer> provincesToId;
    Map<String, Integer> citiesToId;
    Map<String, Integer> countiesToId;

    public UserCheckDocJPane() {
        initComponents();

        provincesToId = new HashMap<>();
        citiesToId = new HashMap<>();
        countiesToId = new HashMap<>();
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

    private void sexItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange() == 1) {
            Dsex = (String) sex.getSelectedItem();
        }
    }

    private void ageItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange() == 1) {
            Dage = (String) age.getSelectedItem();
        }
    }

    private void scoreItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange() == 1) {
            Dscore = (String) score.getSelectedItem();
        }
    }

    private void startCheckActionPerformed(ActionEvent e) {
        // TODO add your code here
        Doctors doctor = new Doctors();
        doctor.setDsex(Dsex);
        doctor.setDage(Dage);
        doctor.setProvince(provinceName);
        doctor.setCity(cityName);
        doctor.setCounty(countyName);
        doctor.query(Doctors.class, new JDBCDao.QueryListener<Doctors>() {
            @Override
            public void onSucceed(List<Doctors> result) {
                DefaultListModel<DocListJpane> doctorsDefaultListModel = new DefaultListModel<>();
                for (Doctors d : result) {
                    doctorsDefaultListModel.addElement(new DocListJpane(d));
                }
                JList jList = new JList();
                jList.setModel(doctorsDefaultListModel);
                test test = new test(jList);
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        province = new JComboBox<>();
        city = new JComboBox<>();
        county = new JComboBox<>();
        sex = new JComboBox<>();
        age = new JComboBox<>();
        score = new JComboBox<>();
        startCheck = new JButton();

        //======== this ========
        setLayout(null);

        //---- province ----
        province.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u7701"
        }));
        province.addItemListener(e -> provinceItemStateChanged(e));
        add(province);
        province.setBounds(80, 140, 175, 70);

        //---- city ----
        city.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5e02"
        }));
        city.addItemListener(e -> {
			provinceItemStateChanged(e);
			cityItemStateChanged(e);
		});
        add(city);
        city.setBounds(265, 140, 175, 70);

        //---- county ----
        county.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u533a/\u53bf"
        }));
        county.addItemListener(e -> {
			provinceItemStateChanged(e);
			countyItemStateChanged(e);
			countyItemStateChanged(e);
		});
        add(county);
        county.setBounds(445, 140, 175, 70);

        //---- sex ----
        sex.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u6027\u522b",
            "\u7537",
            "\u5973"
        }));
        sex.addItemListener(e -> {
			provinceItemStateChanged(e);
			sexItemStateChanged(e);
		});
        add(sex);
        sex.setBounds(80, 230, 175, 70);

        //---- age ----
        age.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5e74\u9f84",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31",
            "32",
            "33",
            "34",
            "35",
            "36",
            "37",
            "38",
            "39",
            "40",
            "41",
            "42",
            "43",
            "44",
            "45",
            "46",
            "47",
            "48",
            "49",
            "50"
        }));
        age.addItemListener(e -> {
			provinceItemStateChanged(e);
			ageItemStateChanged(e);
		});
        add(age);
        age.setBounds(265, 230, 175, 70);

        //---- score ----
        score.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5206\u6570",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
        }));
        score.addItemListener(e -> {
			provinceItemStateChanged(e);
			scoreItemStateChanged(e);
		});
        add(score);
        score.setBounds(445, 230, 175, 70);

        //---- startCheck ----
        startCheck.setText("\u5f00\u59cb\u67e5\u627e");
        startCheck.addActionListener(e -> startCheckActionPerformed(e));
        add(startCheck);
        startCheck.setBounds(195, 380, 250, 75);

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
    private JComboBox<String> province;
    private JComboBox<String> city;
    private JComboBox<String> county;
    private JComboBox<String> sex;
    private JComboBox<String> age;
    private JComboBox<String> score;
    private JButton startCheck;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
