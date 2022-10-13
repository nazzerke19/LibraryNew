import Models.Routes;
import Models.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class UpdateRoutes extends JFrame{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton updBtn;
    private JButton delete;
    private JPanel updRoutesPanel;
    JFrame jframe=new JFrame("Update and Delete");


    public UpdateRoutes(Connection connection){
        jframe.setPreferredSize(new Dimension(500, 500));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(updRoutesPanel);
        jframe.setVisible(true);

        List<Routes> routes = Routes.getRoutes(connection);
        for (int i = 0; i < routes.size(); i++) {
            comboBox1.addItem(routes.get(i));
        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Routes routes1 = (Routes) comboBox1.getSelectedItem();
                textField1.setText(routes1.Name);

            }
        });
        updBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Routes routes1 = (Routes) comboBox1.getSelectedItem();
                routes1.Name = textField1.getText();


                Routes.Update(connection, routes1);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Routes routes1 = (Routes) comboBox1.getSelectedItem();

                Routes.Delete(connection, routes1);
            }
        });
    }
}
