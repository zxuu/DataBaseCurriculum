package bean;

import jframe.Aplication;
import utils.JDBCSetting;
import utils.getResultSet;
import utils.resultSetHelp;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Jun 27 19:08:28 CST 2018
 */



/**
 * @author we
 */
public class userJpane extends JPanel {


    public userJpane() {
        initComponents();
    }

    private void initComponents() {
        String[] columnNames = {"姓名","性别","年龄","电话号码","情况描述","密码"};
        String[][] iIfo = new String[2][6];

        resultSetHelp resultSetHelp = utils.resultSetHelp.getresultSetHelpInstance();
        resultSetHelp.setResultSet(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,
                "SELECT * FROM Users ", Aplication.row, new getResultSet() {
                    @Override
                    public void getResultSetSuccess(ResultSet resultSet, Connection connection) {
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 6; j++) {
                                try {
                                    iIfo[i][j] = resultSet.getString(j + 1);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

//        try {
//            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            resultSet = sql.executeQuery("SELECT * FROM Users ");
//            if (resultSet.absolute(Aplication.row)) {
//                for (int i = 0; i < 2; i++) {
//                    for (int j = 0; j < 6; j++) {
//                        iIfo[i][j] = resultSet.getString(j + 1);
//                    }
//                }
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        table1 = new JTable(iIfo,columnNames);
        table1.setSize(300,100);
        add(table1);

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
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
