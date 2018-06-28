package bean;

import jframe.Aplication;
import utils.getResultSet;
import utils.resultSetHelp;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocJpane extends JPanel {
    public DocJpane() {
        initComponents();
    }

    private void initComponents() {
        String[] columnNames = {"姓名","性别","年龄","电话号码","出生日期","身份证号码","住址","工作单位","工作经历"
        ,"密码"};
        String[][] iIfo = new String[1][10];

        resultSetHelp resultSetHelp = utils.resultSetHelp.getresultSetHelpInstance();
        resultSetHelp.setResultSet(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,
                "SELECT * FROM Doctors ", Aplication.drow, new getResultSet() {
                    @Override
                    public void getResultSetSuccess(ResultSet resultSet, Connection connection) {

                        for (int i = 0; i < 1; i++) {
                            for (int j = 0; j < 10; j++) {
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
