import Models.Cars;
import Models.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddAuto extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton AddBtn;
    private JPanel AddAutoPanel;

    JFrame jframe=new JFrame("Add Automobile");
    public AddAuto(Connection connection) {
        jframe.setPreferredSize(new Dimension(400, 300));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(AddAutoPanel);
        jframe.setVisible(true);
        AddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cars cars = new Cars();
                cars.Num = textField1.getText();
                cars.Color = textField2.getText();
                cars.Mark = textField3.getText();
                Cars.Add(connection, cars);
                JOptionPane.showMessageDialog(AddAutoPanel,"Автомобиль успешно добавлен!");
            }
        });
    }
}
