import javax.swing.*;
import java.awt.event.*;

public class DBSampleGuiDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JLabel DialogType;
    private int dialogType;
    String plateNum;

    public DBSampleGuiDialog(int id,int dialogType) {
        this.dialogType =dialogType;
        switch (dialogType){
            case 1: DialogType.setText("New Vehicle");
                    plateNum =LTOrenewal.generatePlateNum();
                    textField1.setText(plateNum);
                    textField1.setEnabled(false);
                    break;
            case 2: Vehicle vehicle = DBSample.getVehicle(id);
                DialogType.setText("Update Vehicle Info");
                    textField1.setText(vehicle.getPlateNumber());
                    textField2.setText(vehicle.getOwnerName());
                    switch (vehicle.getType()){
                        case "Motor": comboBox1.setSelectedIndex(0); break;
                        case "Car":  comboBox1.setSelectedIndex(1); break;
                        case "PUV":comboBox1.setSelectedIndex(2);  break;
                        default: comboBox1.setSelectedIndex(0); break;
                    }


                    break;
            default: break;
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here

        String owner = textField2.getText();
        String type = String.valueOf(comboBox1.getSelectedItem());
        float fee = 0;
        switch (type){
            case "Motor": fee = 504.465f; break;
            case "Car": fee = 818.21f; break;
            case "PUV": fee = 1284.96f; break;

        }
        switch (dialogType){
            case 1: DBSample.insertVehicle(plateNum,owner,type,fee);
                break;
            case 2: // DBSample.setVehicle();
            break;
            default: break;
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
//        DBSampleGuiDialog dialog = new DBSampleGuiDialog();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
    }
}
