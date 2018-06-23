package utils;

import model.Doctors;
import javax.swing.*;


public class DocRegHelp {

    public DocRegHelp() {

    }

    public void writeDocRegModel(Doctors doctors) {

        doctors.save(new JDBCDao.SaveListerner() {
            @Override
            public void onSucceed() {
                JOptionPane.showMessageDialog(null,"注册成功","" +
                    "恭喜",JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void onFailed(Exception e) {
                JOptionPane.showMessageDialog(null,"注册失败","" +
                    "提示",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
