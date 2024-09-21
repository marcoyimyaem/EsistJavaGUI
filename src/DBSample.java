import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSample {

    static private String url ="jdbc:mysql://localhost:3306/lto";
    static private String username ="root";
    static private String password ="root";
    static String DB_vehicle= "SELECT * FROM 'vehicle'";
    static void testCon(){
        try{
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("connection success!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    static Object[][] allVehicles(){
        Object[][] result;

        try {
            Connection con =DriverManager.getConnection(url,username,password);
            String all = "SELECT * FROM vehicle";
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet allVehicles= statement.executeQuery(all);
            allVehicles.last();
            result = new Object[allVehicles.getRow()-1][5];
            allVehicles.first();
            int i=0;
            while(allVehicles.next()){
                System.out.println(allVehicles.getInt(1)
                +"\t"+allVehicles.getString(2)
                        +"\t"+allVehicles.getString(3)
                        +"\t"+allVehicles.getString(4)
                        +"\t"+allVehicles.getFloat(5));
//
                result[i][0] = allVehicles.getInt(1);
                result[i][1] = allVehicles.getString(2);
                result[i][2] = allVehicles.getString(3);
                result[i][3] = allVehicles.getString(4);
                result[i][4] = allVehicles.getFloat(5);
                i++;
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return result;
    }
    static Vehicle getVehicle(int id){
        Connection con = null;
        Vehicle result = null;
        try {

            con = DriverManager.getConnection(url,username,password);
            String q = "SELECT * FROM `vehicle` where id = " +id;
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet idVehicle= statement.executeQuery(q);

            while(idVehicle.next()){
//                System.out.println((idVehicle.getInt(1)
//                        +"\t"+idVehicle.getString(2)
//                        +"\t"+idVehicle.getString(3)
//                        +"\t"+idVehicle.getString(4)
//                        +"\t"+idVehicle.getFloat(5)));
                result = new Vehicle(idVehicle.getInt(1),idVehicle.getString(2),
                        idVehicle.getString(3),
                        idVehicle.getString(4),
                        idVehicle.getFloat(5));
                System.out.println(result);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (NullPointerException e){
            System.out.println("user id doesn't exist");
        }

    return result;

    }
    static void setVehicle(String plateNumber,String ownerName,String type,float fee,int id){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,username,password);
//            String q ="UPDATE `vehicle` SET `ownerName` = '"+ownerName+"',`ownerName` = '"+ownerName+"',`ownerName` = '"+ownerName+"' WHERE `vehicle`.`id` = "+id;
            String q = "SELECT * FROM `vehicle` where id="+id;
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet idVehicle= statement.executeQuery(q);
            idVehicle.absolute(1);
            idVehicle.updateString(2,plateNumber);
            idVehicle.updateString(3,ownerName);
            idVehicle.updateString(4,type);
            idVehicle.updateFloat(5,fee);
            idVehicle.updateRow();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static void setVehicle(Vehicle vehicle){
//        setVehicle(vehicle.getPlateNumber());
    }
    static void delVehicle(int id){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,username,password);
            String q = "SELECT * FROM `vehicle` where id="+id;
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet idVehicle= statement.executeQuery(q);
            idVehicle.absolute(1);
            idVehicle.deleteRow();
            con.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    static void insertVehicle(String plateNumber,String ownerName,String type,float fee){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,username,password);
            String q = "SELECT * FROM `vehicle`";
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet idVehicle= statement.executeQuery(q);
            idVehicle.moveToInsertRow();
            idVehicle.updateString(2,plateNumber);
            idVehicle.updateString(3,ownerName);
            idVehicle.updateString(4,type);
            idVehicle.updateFloat(5,fee);
            idVehicle.insertRow();
            idVehicle.moveToCurrentRow();
//            System.out.println("added a new vehicle: "+idVehicle.getString(2));
            con.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
//        testCon();
        allVehicles();
        System.out.println("getting id number 2");

//        setVehicle("MCK245","John Del Cross","Car",1110.5f,2);
        getVehicle(2);
//        delVehicle(3);
        allVehicles();
//        insertVehicle("LFJ120","Anne Lopez","Car",845.65f);
        allVehicles();
    }
}
