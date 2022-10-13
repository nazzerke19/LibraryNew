import Models.Routes;
import Models.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddRoutes extends JFrame{
    private JTextField textField1;
    private JButton addRouteBtn;
    private JPanel addRoutesPanel;
    JFrame jframe=new JFrame("Add Routes");
    public AddRoutes(Connection connection) {
        jframe.setPreferredSize(new Dimension(400, 300));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(addRoutesPanel);
        jframe.setVisible(true);
        addRouteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Routes routes = new Routes();
                routes.Name = textField1.getText();

                Routes.Add(connection, routes);
                JOptionPane.showMessageDialog(addRoutesPanel,"Маршрут успешно добавлен!");
            }
        });
    }
}
