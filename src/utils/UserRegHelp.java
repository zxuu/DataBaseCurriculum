package utils;

import model.Users;
import javax.swing.*;

public class UserRegHelp {


    public UserRegHelp() {

    }

    public void writeUserRegModel(Users users){

        users.save(new JDBCDao.SaveListerner() {
            @Override
            public void onSucceed() {
                JOptionPane.showMessageDialog(null,"注册成功",
                        "恭喜",JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void onFailed(Exception e) {
                JOptionPane.showMessageDialog(null,"注册失败",
                        "提示",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
