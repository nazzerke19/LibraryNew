import Models.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class updateStaff extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton изменитьButton;
    private JComboBox comboBox1;
    private JPanel panelUpd;
    private JButton delete;
    JFrame jframe=new JFrame("Update and Delete");


    public updateStaff(Connection connection){
        jframe.setPreferredSize(new Dimension(500, 500));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(panelUpd);
        jframe.setVisible(true);

        List<Staff> staffs = Staff.getStaff(connection);
        for (int i = 0; i < staffs.size(); i++) {
            comboBox1.addItem(staffs.get(i));
        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Staff sStaff = (Staff) comboBox1.getSelectedItem();
                textField1.setText(sStaff.First_Name);
                textField2.setText(sStaff.Last_Name);
                textField3.setText(sStaff.Pather_Name);
            }
        });
        изменитьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Staff staff = (Staff) comboBox1.getSelectedItem();
                staff.First_Name = textField1.getText();
                staff.Last_Name = textField2.getText();
                staff.Pather_Name = textField3.getText();

                Staff.Update(connection, staff);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Staff staff = (Staff) comboBox1.getSelectedItem();

                Staff.Delete(connection, staff);
            }
        });
    }
}
