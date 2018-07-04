package model;

import utils.JDBCObject;

public class Doctors extends JDBCObject{

    String Dname;
    String Dsex;
    String Dage;
    String Dtel;
    String Dbirth;
    String DID;
    String Dadress;
    String Dworkunit;
    String Dworkexp;
    String Dpassword;
    String province;
    String city;
    String county;
    String Dscore;

    public String getDscore() {
        return Dscore;
    }

    public void setDscore(String dscore) {
        Dscore = dscore;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

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
