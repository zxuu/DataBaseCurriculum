package model;

import utils.JDBCObject;

public class Users extends JDBCObject{

    String Uname;
    String Usex;
    String Uage;
    String Utel;
    String Udescribe;
    String Upassword;

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }



    public Users() {
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUsex() {
        return Usex;
    }

    public void setUsex(String usex) {
        Usex = usex;
    }

    public String getUtel() {
        return Utel;
    }

    public void setUtel(String utel) {
        Utel = utel;
    }

    public String getUdescribe() {
        return Udescribe;
    }

    public void setUdescribe(String udescribe) {
        Udescribe = udescribe;
    }

    public String getUage() {
        return Uage;
    }

    public void setUage(String uage) {
        Uage = uage;
    }
}
