import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AllAutopark extends JFrame {


    private static String _connectionString = "jdbc:oracle:thin:@localhost:1521:orclcdb";
    private static String _username = "c##new";
    private static String _password = "oracle";

    private JPanel allAutoParkPanel;
    private JTable table;
    private JButton addAutoBt;
    private JButton addpersBtn;
    private JButton cars;
    private JButton routes;
    private JButton staff;
    private JScrollPane jScrollPane;
    private JButton updateStaffBtn;
    private JButton procedure;
    private JButton addrouteButton;
    private JButton updAutoBTn;
    private JButton updateRouteButton;
    private JButton journal;
    private Connection connection;
    JFrame jframe=new JFrame("AllAutoPark");
    Object[][] array;
    public AllAutopark() {
        jframe.setPreferredSize(new Dimension(500, 500));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(allAutoParkPanel);
        jframe.setVisible(true);
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(_connectionString, _username, _password);
        }catch(Exception e){ System.out.println(e); }

      //  AllRoutes();
        staff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffTable();
            }
        });
        routes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Models.Routes> _routes = Routes.getRoutes(connection);
                array = new String[_routes.size()][];
                for (int i = 0; i < _routes.size(); i++) {
                    String[] row = new String[2];
                    row[0] = String.valueOf(_routes.get(i).Id);
                    row[1] = _routes.get(i).Name;
                    array[i] = row;
                }
                 Object[] columnsHeader = new String[] {"ID", "Название"};
                DefaultTableModel model = new DefaultTableModel(array, columnsHeader);
                table = new JTable(model);
                table.setVisible(true);
                table.setFillsViewportHeight(true);
                jScrollPane.add(table);
                jScrollPane.setViewportView(table);
                jScrollPane.revalidate();
                jScrollPane.repaint();
                pack();
            }
        });

        cars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Models.Cars> _cars = Cars.getCars(connection);
                array = new String[_cars.size()][];
                for (int i = 0; i < _cars.size(); i++) {
                    String[] row = new String[4];
                    row[0] = String.valueOf(_cars.get(i).Id);
                    row[1] = _cars.get(i).Num;
                    row[2] = _cars.get(i).Color;
                    row[3] = _cars.get(i).Mark;
                    array[i] = row;
                }
                Object[] columnsHeader = new String[] {"ID", "Марка","Номер","Цвет"};
                DefaultTableModel model = new DefaultTableModel(array, columnsHeader);
                table = new JTable(model);
                table.setVisible(true);
                table.setFillsViewportHeight(true);
                jScrollPane.add(table);
                jScrollPane.setViewportView(table);
                jScrollPane.revalidate();
                jScrollPane.repaint();
                pack();
            }
        });


        addpersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStaff addStaff = new AddStaff( connection);
                addStaff.setVisible(true);
            }
        });
        updateStaffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStaff updateStaff = new updateStaff(connection);
                updateStaff.setVisible(true);
            }
        });
        procedure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllRoutes();
            }
        });
        addAutoBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAuto addAuto = new AddAuto( connection);
                addAuto.setVisible(true);
            }
        });
        addrouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRoutes addRoute = new AddRoutes( connection);
                addRoute.setVisible(true);
            }
        });
        updAutoBTn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateAuto updateAuto = new UpdateAuto(connection);
                updateAuto.setVisible(true);
            }
        });
        updateRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateRoutes updateRoutes = new UpdateRoutes(connection);
                updateRoutes.setVisible(true);
            }
        });
        journal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Models.Journal> _journal = Journal.getJournal(connection);
                array = new String[_journal.size()][];
                for (int i = 0; i < _journal.size(); i++) {
                    String[] row = new String[5];
                    row[0] = String.valueOf(_journal.get(i).Id);
                    row[1] = String.valueOf(_journal.get(i).Time_in);
                    row[2] = String.valueOf(_journal.get(i).Time_out);
                    row[3] = String.valueOf(_journal.get(i).Auto_id);
                    row[4] = String.valueOf(_journal.get(i).Route_id);
                    array[i] = row;
                }
                Object[] columnsHeader = new String[] {"ID", "Time in", "Time out", "Автомобиль id", "Маршрут id"};
                DefaultTableModel model = new DefaultTableModel(array, columnsHeader);
                table = new JTable(model);
                table.setVisible(true);
                table.setFillsViewportHeight(true);
                jScrollPane.add(table);
                jScrollPane.setViewportView(table);
                jScrollPane.revalidate();
                jScrollPane.repaint();
                pack();
            }  });
            }




    public void StaffTable(){
        List<Models.Staff> _staffs = Staff.getStaff(connection);
        array = new String[_staffs.size()][];
        for (int i = 0; i < _staffs.size(); i++) {
            String[] row = new String[4];
            row[0] = String.valueOf(_staffs.get(i).Id);
            row[1] = _staffs.get(i).First_Name;
            row[2] = _staffs.get(i).Last_Name;
            row[3] = _staffs.get(i).Pather_Name;
            array[i] = row;
        }
        Object[] columnsHeader = new String[] {"ID", "Имя","Фамилия","Партнер"};
        DefaultTableModel model = new DefaultTableModel(array, columnsHeader);
        table = new JTable(model);
        table.setVisible(true);
        table.setFillsViewportHeight(true);
        table.repaint();
        jScrollPane.add(table);
        jScrollPane.setViewportView(table);
        jScrollPane.revalidate();
        jScrollPane.repaint();
        pack();
    }

    public void AllRoutes(){
        //Количество автомобилей, находящихся в рейсе
        List<Models.Allroutes> _staffs = Allroutes.getAllRoutes(connection);
        array = new String[_staffs.size()][];
        for (int i = 0; i < _staffs.size(); i++) {
            String[] row = new String[2];
            row[0] = _staffs.get(i).Name;
            row[1] = String.valueOf(_staffs.get(i).Count);
            array[i] = row;
        }
        Object[] columnsHeader = new String[] {"Имя","Количество"};
        DefaultTableModel model = new DefaultTableModel(array, columnsHeader);
        table = new JTable(model);
        table.setVisible(true);
        table.setFillsViewportHeight(true);
        table.repaint();
        jScrollPane.add(table);
        jScrollPane.setViewportView(table);
        jScrollPane.revalidate();
        jScrollPane.repaint();
        pack();
    }
}
