package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal {
    public int Id;
    public Date Time_out;
    public Date Time_in;
    public int Auto_id;
    public int Route_id;

    public Cars Auto;
    public Routes Route;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Cars getAuto() {
        return Auto;
    }

    public void setAuto(Cars auto) {
        Auto = auto;
    }

    public Date getTime_in() {
        return Time_in;
    }

    public void setAuto_id(int auto_id) {
        Auto_id = auto_id;
    }

    public Date getTime_out() {
        return Time_out;
    }

    public void setRoute(Routes route) {
        Route = route;
    }

    public int getAuto_id() {
        return Auto_id;
    }

    public void setRoute_id(int route_id) {
        Route_id = route_id;
    }

    public int getRoute_id() {
        return Route_id;
    }

    public void setTime_in(Date time_in) {
        Time_in = time_in;
    }

    public void setTime_out(Date time_out) {
        Time_out = time_out;
    }

    public static List<Journal> getJournal(Connection connection){

        ArrayList<Journal> journals = new ArrayList<Journal>();
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Journal");
            while(rs.next())
            {
                Journal journal = new Journal();
                journal.Id = rs.getInt(1);
                journal.Time_in = rs.getDate(2);
                journal.Time_out = rs.getDate(3);
                journal.Auto_id = rs.getInt(4);
                journal.Route_id = rs.getInt(5);
                journals.add(journal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return journals;
    }
}
