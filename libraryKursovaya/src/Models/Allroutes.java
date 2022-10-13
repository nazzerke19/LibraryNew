package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Allroutes {
    public String Name;
    public int Count;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public static List<Allroutes> getAllRoutes(Connection connection){

        ArrayList<Allroutes> allroutes = new ArrayList<Allroutes>();
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT routes.name, count(auto_id) as amountofauto \n" +
                    "FROM routes \n" +
                    "left join journal on route_id = routes.id where journal.time_in is null group by routes.name");
            while(rs.next())
            {
                Allroutes car = new Allroutes();
                car.Name = rs.getString(1);
                car.Count = rs.getInt(2);
                allroutes.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allroutes;
    }
}
