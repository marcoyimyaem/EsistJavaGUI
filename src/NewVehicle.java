import javax.swing.*;
import java.awt.event.*;


public class NewVehicle extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JComboBox comboBox1;



    public NewVehicle() {
//
        setSize(300,300);
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);

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

        String owner = textField1.getText();
        String type = String.valueOf(comboBox1.getSelectedItem());
        float fee = 0;
        switch (type){
            case "Motor": fee = 504.465f; break;
            case "Car": fee = 818.21f; break;
            case "PUV": fee = 1284.96f; break;

        }
        LTOrenewal.addNewV(owner,type,fee);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        NewVehicle dialog = new NewVehicle();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
