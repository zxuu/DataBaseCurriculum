package model;

import utils.JDBCObject;

public class Doctors extends JDBCObject{

    String Dname,Dsex,Dage,Dtel,Dbirth,DID,Dadress,Dworkunit,Dworkexp,Dpassword;

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDsex() {
        return Dsex;
    }

    public void setDsex(String dsex) {
        Dsex = dsex;
    }

    public String getDage() {
        return Dage;
    }

    public void setDage(String dage) {
        Dage = dage;
    }

    public String getDtel() {
        return Dtel;
    }

    public void setDtel(String dtel) {
        Dtel = dtel;
    }

    public String getDbirth() {
        return Dbirth;
    }

    public void setDbirth(String dbirth) {
        Dbirth = dbirth;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getDadress() {
        return Dadress;
    }

    public void setDadress(String dadress) {
        Dadress = dadress;
    }

    public String getDworkunit() {
        return Dworkunit;
    }

    public void setDworkunit(String dworkunit) {
        Dworkunit = dworkunit;
    }

    public String getDworkexp() {
        return Dworkexp;
    }

    public void setDworkexp(String dworkexp) {
        Dworkexp = dworkexp;
    }

    public String getDpassword() {
        return Dpassword;
    }

    public void setDpassword(String dpassword) {
        Dpassword = dpassword;
    }
}
