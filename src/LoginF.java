import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginF extends JFrame {
    String uname = "645658";
    String passwd = "#5shf5)*!#@";
    private JPanel mainPanel;
    private JTextField textFieldUserName;
    private JPasswordField passwordField1;
    private JButton loginButton;

    public LoginF()  {

        setContentPane(mainPanel);
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("login button is clicked");
                System.out.println(textFieldUserName.getText());
                System.out.println(passwordField1.getText());
                if((textFieldUserName.getText().equals(uname))&&(passwordField1.getText().equals(passwd))){
                    System.out.println("username and password is correct");

                }
                else
                    System.out.println("username and password is invalid");
            }
        });
    }

    public static void main(String[] args) {
        new LoginF();
    }
}
