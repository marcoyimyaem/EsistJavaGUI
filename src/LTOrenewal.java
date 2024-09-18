import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LTOrenewal extends JFrame {
    private JTextField textField1;
    private JButton checkButton;
    private JButton payButton;
    private JLabel Plate;
    private JLabel Owner;
    private JLabel Fee;
    private JLabel Type1;
    private JPanel mainPanel;
    private JButton newButton;
    static List<Vehicle> vehicles = new ArrayList<>();
    static Vehicle vehicle1= null;
    public LTOrenewal(){
        setContentPane(mainPanel);
        setTitle("LTO sys");
//        setIconImage();
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewVehicle nv = new NewVehicle();
                nv.setVisible(true);
            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Vehicle vehicle:vehicles){
                    if(vehicle.getPlateNumber().equals(textField1.getText())){
                        vehicle1 = vehicle;
                        Plate.setText(vehicle.getPlateNumber());
                        Owner.setText(vehicle.getOwnerName());
                        Fee.setText((String.valueOf(vehicle.getFee())));
                        Type1.setText(vehicle.getType());
                        break;
                    }
                    else
                        System.out.println("no item found");

                }
            }
        });
    }
    static String generatePlateNum(){
        Random r = new Random();
        char[] i = new char[3];
        int[] j = new int[3];
        for(int a = 0;a<3;a++){
            i[a] = (char)(r.nextInt(26)+'A');
            j[a] = r.nextInt(9);
        }


        return String.valueOf(String.valueOf(i)+j[0]+j[1]+j[2]);
    }
    static public void addNewV(String owner,String type,float fee){
        int id = vehicles.size()+1;
        String plateNum = generatePlateNum();
        for(Vehicle vehicle:vehicles){
            while(vehicle.getPlateNumber().equals(plateNum)){
                plateNum = generatePlateNum();
            }

        }
        vehicles.add(new Vehicle(id,plateNum,owner,type,fee));
        System.out.println(vehicles);
    }

    public static void main(String[] args) {
        new LTOrenewal();
        vehicles.add(new Vehicle(1,"JGD958","Marc Yim","Motor",500.0f));
        vehicles.add(new Vehicle(2,"MCK245","John Del Cross","Car",1110.50f));
        System.out.println(vehicles);

    }
}
