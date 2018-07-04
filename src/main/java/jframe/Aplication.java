package jframe;

import model.Doctors;
import model.Users;

import java.sql.ResultSet;
import java.util.Vector;

public class Aplication {
    public static ResultSet resultSet;
    public static String tel;
    public static String password;
    public static int row;
    public static int drow;

    public static Vector<Doctors> doctorArry;
    public static Vector<Doctors> allMydoctorArry;

    public static Doctors doctorI;
    public static Users userI;
}
