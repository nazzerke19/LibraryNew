package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Staff {
    public int Id;
    public String First_Name;
    public String Last_Name;
    public String Pather_Name;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_name) {
        First_Name = First_name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_name) {
        Last_Name = Last_name;
    }
    public String getPather_Name() {
        return Pather_Name;
    }

    public void setPather_Name(String Pather_name) {
        Pather_Name = Pather_name;
    }

    public static List<Staff> getStaff(Connection connection){

        ArrayList<Staff> staffs = new ArrayList<Staff>();
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs= stmt.executeQuery("select * from AUTO_PERSONNEL");
            while(rs.next())
            {
                Staff staff = new Staff();
                staff.Id = rs.getInt(1);
                staff.First_Name = rs.getString(2);
                staff.Last_Name = rs.getString(3);
                staff.Pather_Name = rs.getString(4);
                staffs.add(staff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return staffs;

    }

    public static void Add(Connection connection,Staff staff){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "INSERT INTO AUTO_PERSONNEL(FIRST_NAME, LAST_NAME,PARTHER_NAME) values (" + "'" + staff.First_Name + "'," + "'" + staff.Last_Name + "'," + "'" + staff.Pather_Name + "'" + ")";
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Update(Connection connection, Staff staff){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "Update AUTO_PERSONNEL SET FIRST_NAME ='" + staff.First_Name + "', LAST_NAME = '" + staff.Last_Name + "', PARTHER_NAME ='" + staff.Pather_Name + "' Where Id = " + staff.Id;
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Delete(Connection connection, Staff staff){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "Delete from AUTO_PERSONNEL  Where Id = " + staff.Id;
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String toString() {
        return this.First_Name + " " + this.Last_Name;
    }
}
