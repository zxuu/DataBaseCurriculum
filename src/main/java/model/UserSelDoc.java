package model;

import utils.JDBCObject;

public class UserSelDoc extends JDBCObject {
    String Uname;
    String Utel;
    String Dname;
    String Dtel;

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUtel() {
        return Utel;
    }

    public void setUtel(String utel) {
        Utel = utel;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDtel() {
        return Dtel;
    }

    public void setDtel(String dtel) {
        Dtel = dtel;
    }
}
