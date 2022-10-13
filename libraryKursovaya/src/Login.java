import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JButton button1;
    private JPanel panel1;
    private JTextField loginText;
    private JPasswordField passwordField1;
    JFrame jframe=new JFrame("Login");
    public Login() {
        jframe.setPreferredSize(new Dimension(400, 300));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.add(panel1);
        jframe.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = passwordField1.getPassword();
                String login = loginText.getText();
                if (login.equals("new") && String.valueOf(pass).equals("oracle")) {
                    AllAutopark allAutopark = new AllAutopark();
                    allAutopark.setVisible(true);
                    jframe.dispose();
                } else {JOptionPane.showMessageDialog(panel1,"Неправильный пароль или логин");}
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
