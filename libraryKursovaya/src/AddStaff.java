import Models.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddStaff extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton AddBtn;
    JFrame jframe=new JFrame("Add Staff");
    public AddStaff(Connection connection) {
        jframe.setPreferredSize(new Dimension(400, 300));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(panel1);
        jframe.setVisible(true);
        AddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Staff staff = new Staff();
                staff.First_Name = textField1.getText();
                staff.Last_Name = textField2.getText();
                staff.Pather_Name = textField3.getText();
                Staff.Add(connection, staff);
                JOptionPane.showMessageDialog(panel1,"Персонал успешно добавлен!");
            }
        });
    }
}
