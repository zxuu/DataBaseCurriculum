package model;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class DocTableModel  extends AbstractTableModel {

    Vector<Doctors> doctorsVector;
        /*
         * 这里和刚才一样，定义列名和每个数据的值
         */
        String[] columnNames =
                {"姓名","性别","年龄","电话号码","住址","工作单位","工作经历","评分","选择"};
        Object[][] data;
        int rowCount;

        /**
         * 构造方法，初始化二维数组data对应的数据
         */
        public DocTableModel(Vector<Doctors> doctorsVector) {
            this.doctorsVector = doctorsVector;
            rowCount = doctorsVector.size();
            data = new Object[rowCount][9];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < 9; j++) {
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
                            data[i][j] = doctorsVector.get(i).getDadress();
                        case 5:
                            data[i][j] = doctorsVector.get(i).getDworkunit();
                            break;
                        case 6:
                            data[i][j] = doctorsVector.get(i).getDworkexp();
                            break;
                        case 7:
                            data[i][j] = doctorsVector.get(i).getDscore();
                            break;
                        case 8:
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
