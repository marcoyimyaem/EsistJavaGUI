import javax.swing.*;
import java.awt.*;

public class DBSampleGUI extends JFrame {
    private JTable table1;
    private JPanel mainPanel;

    public DBSampleGUI()  {
        setContentPane(mainPanel);
        setTitle("Vehicle sys");
//        setIconImage();
        setVisible(true);
        setSize(800,600);
        setLocationRelativeTo(null);
        String[][] data = {
                {"1","2","3"},
                {"5","6","7"},
                {"8","9","0"}
        };
        String[] colName = {"id","Plate #","Owner"};

        table1.setBounds(30,40,200,300);


    }

    public static void main(String[] args) {
        new DBSampleGUI();
    }
}
