package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    public int Id;
    public String Num;
    public String Color;
    public String Mark;


    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public static List<Cars> getCars(Connection connection){

        ArrayList<Cars> cars = new ArrayList<Cars>();
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from AUTO");
            while(rs.next())
            {
                Cars car = new Cars();
                car.Id = rs.getInt(1);
                car.Num = rs.getString(2);
                car.Color = rs.getString(3);
                car.Mark = rs.getString(4);
                cars.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cars;
    }


    public static void Add(Connection connection,Cars cars){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "INSERT INTO AUTO(Num, Color,Mark) values (" + "'" + cars.Num + "'," + "'" + cars.Color + "'," + "'" + cars.Mark + "'" + ")";
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Update(Connection connection, Cars cars){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "Update AUTO SET Num ='" + cars.Num + "', Color = '" + cars.Color + "', Mark ='" + cars.Mark + "' Where Id = " + cars.Id;
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Delete(Connection connection, Cars cars){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "Delete from AUTO  Where Id = " + cars.Id;
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String toString() {
        return this.Mark + " " + this.Color;
    }
}
