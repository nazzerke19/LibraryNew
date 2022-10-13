package Models;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Routes {
    public int Id;
    public String Name;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static List<Routes> getRoutes(Connection connection){

        ArrayList<Routes> routes = new ArrayList<Routes>();
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from ROUTES");
            while(rs.next())
            {
                Routes route = new Routes();
                route.Id = rs.getInt(1);
                route.Name = rs.getString(2);
                routes.add(route);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return routes;
    }

    public static void Add(Connection connection,Routes routes){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "INSERT INTO routes(Name) values (" + "'" + routes.Name + "'" + ")";
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Update(Connection connection, Routes routes){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "Update routes SET Name ='" + routes.Name + "' Where Id = " + routes.Id;
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Delete(Connection connection, Routes routes){
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            String query = "Delete from Routes  Where Id = " + routes.Id;
            stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String toString() {
        return this.Name ;
    }
}
