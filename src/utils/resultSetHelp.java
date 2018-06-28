package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class resultSetHelp {
    ResultSet resultSet;
    Connection con;
    Statement sql;

    private static volatile resultSetHelp sInstance;

    public static resultSetHelp getresultSetHelpInstance() {
        if (null == sInstance) {
            synchronized (resultSetHelp.class) {
                if (sInstance == null) {
                    sInstance = new resultSetHelp();
                }
            }
        }
        return sInstance;
    }


    public void setResultSet(int parameter1, int parameter2, String querystatement, int row, getResultSet getResultSet) {
        try {
            con = JDBCSetting.getConnection();
            sql = con.createStatement(parameter1,parameter2);
            resultSet = sql.executeQuery(querystatement);
            if (resultSet.absolute(row)) {
                getResultSet.getResultSetSuccess(resultSet, con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
