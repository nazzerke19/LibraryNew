import Models.Cars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class UpdateAuto extends JFrame{
    private JComboBox comboBox1;
    private JTextField num;
    private JTextField color;
    private JTextField mark;
    private JButton delete;
    private JButton updAutoBtn;
    private JPanel updAutoPanel;
    JFrame jframe=new JFrame("Update and Delete");


    public UpdateAuto(Connection connection){
        jframe.setPreferredSize(new Dimension(500, 500));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(updAutoPanel);
        jframe.setVisible(true);

        List<Cars> cars = Cars.getCars(connection);
        for (int i = 0; i < cars.size(); i++) {
            comboBox1.addItem(cars.get(i));
        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cars cars1 = (Cars) comboBox1.getSelectedItem();
                num.setText(cars1.Num);
                color.setText(cars1.Color);
                mark.setText(cars1.Mark);
            }
        });
        updAutoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cars cars1 = (Cars) comboBox1.getSelectedItem();
                cars1.Num = num.getText();
                cars1.Color = color.getText();
                cars1.Mark = mark.getText();

                Cars.Update(connection, cars1);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cars cars1 = (Cars) comboBox1.getSelectedItem();

                Cars.Delete(connection, cars1);
            }
        });
    }
}
