package model;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class DocIModel extends AbstractTableModel {
    Vector<Doctors> doctorVector;


    String[] columnNames =
            {"姓名","性别","年龄","电话号码","出生日期","身份证号","住址","工作单位","工作经历","密码","省","市","县","评分","选择"};
    Object[][] data;
    int rowCount;

    public DocIModel(Vector<Doctors> doctorsVector) {
        this.doctorVector = doctorsVector;
        rowCount = doctorVector.size();
        data = new Object[rowCount][15];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 15; j++) {
                switch (j) {
                    case 0:
                        data[i][j] = doctorsVector.get(i).getDname();
                        break;
                    case 1:
                        data[i][j] = doctorsVector.get(i).getDsex();
                        break;
                    case 2:
                        data[i][j] = doctorsVector.get(i).getDage();
                        break;
                    case 3:
                        data[i][j] = doctorsVector.get(i).getDtel();
                        break;
                    case 4:
                        data[i][j] = doctorsVector.get(i).getDbirth();
                        break;
                    case 5:
                        data[i][j] = doctorsVector.get(i).getDID();
                        break;
                    case 6:
                        data[i][j] = doctorsVector.get(i).getDadress();
                        break;
                    case 7:
                        data[i][j] = doctorsVector.get(i).getDworkunit();
                        break;
                    case 8:
                        data[i][j] = doctorsVector.get(i).getDworkexp();
                        break;
                    case 9:
                        data[i][j] = doctorsVector.get(i).getDpassword();
                        break;
                    case 10:
                        data[i][j] = doctorsVector.get(i).getProvince();
                        break;
                    case 11:
                        data[i][j] = doctorsVector.get(i).getCity();
                        break;
                    case 12:
                        data[i][j] = doctorsVector.get(i).getCounty();
                    case 13:
                        data[i][j] = doctorsVector.get(i).getDscore();
                        break;
                    case 14:
                        data[i][j] = new Boolean(false);
                        break;
                }
            }
        }
    }

    // 以下为继承自AbstractTableModle的方法，可以自定义
    /**
     * 得到列名
     */
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    /**
     * 重写方法，得到表格列数
     */
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    /**
     * 得到表格行数
     */
    @Override
    public int getRowCount()
    {
        return data.length;
    }

    /**
     * 得到数据所对应对象
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return data[rowIndex][columnIndex];
    }

    /**
     * 得到指定列的数据类型
     */
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return data[0][columnIndex].getClass();
    }

    /**
     * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if (columnIndex < 2)
            return false;
        else
            return true;
    }

    /**
     * 如果数据单元为可编辑，则将编辑后的值替换原来的值
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        data[rowIndex][columnIndex] = aValue;
            /*通知监听器数据单元数据已经改变*/
        fireTableCellUpdated(rowIndex, columnIndex);
    }

}
