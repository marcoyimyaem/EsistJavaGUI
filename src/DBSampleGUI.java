import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBSampleGUI extends JFrame {
    private JTable table1;
    private JPanel mainPanel;
    private JScrollPane scrollp;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;

    public DBSampleGUI()  {
        setContentPane(mainPanel);
        setTitle("Vehicle sys");
//        setIconImage();
        setVisible(true);
        setSize(800,600);
        setLocationRelativeTo(null);
        String[] colName = {"id","Plate #","Owner","Type","Fee"};
//        table1 = new JTable(data,colName);
        table1.setModel(new DefaultTableModel(DBSample.allVehicles(),colName));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBSampleGuiDialog dialog = new DBSampleGuiDialog(0,1);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object cellValue = table1.getValueAt(table1.getSelectedRow(),0);
                DBSampleGuiDialog dialog = new DBSampleGuiDialog((int)cellValue,2);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new DBSampleGUI();
    }
}
