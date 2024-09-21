import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Arrays;

public class DBSampleGUI extends JFrame {
    private  JTable table1;
    private JPanel mainPanel;
    private JScrollPane scrollp;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private static String[] colName = {"id", "Plate #", "Owner", "Type", "Fee"};
    static DefaultTableModel model;
    public DBSampleGUI() {
        setContentPane(mainPanel);
        setTitle("Vehicle sys");
//        setIconImage();
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        table1.setModel(new DefaultTableModel(DBSample.allVehicles(), colName));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBSampleGuiDialog dialog = new DBSampleGuiDialog(0, 1);
                dialog.pack();
                dialog.setVisible(true);

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cellValue = (int) table1.getValueAt(table1.getSelectedRow(), 0);
                DBSampleGuiDialog dialog = new DBSampleGuiDialog(cellValue, 2);
                dialog.pack();
                dialog.setVisible(true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        refreshTable();
                        System.out.println("Dialog is being closed!");
                        // Perform any action needed when the dialog is closing
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        refreshTable();
                        System.out.println("Dialog has been closed!");
                        // Perform any action needed after the dialog has closed
                    }
                });


            }
        });
    }
public void refreshTable(){
    table1.setModel(new DefaultTableModel(DBSample.allVehicles(), colName));
}
    public static void main(String[] args) {
        new DBSampleGUI();
    }
}
