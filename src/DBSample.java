import java.sql.*;
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
    static void allVehicles(){
        try {
            Connection con =DriverManager.getConnection(url,username,password);
            String all = "SELECT * FROM vehicle";
            Statement statement = con.createStatement();
            ResultSet allVehicles= statement.executeQuery(all);
            while(allVehicles.next()){
                System.out.println(allVehicles.getInt(1)
                +"\t"+allVehicles.getString(2)
                        +"\t"+allVehicles.getString(3)
                        +"\t"+allVehicles.getString(4)
                        +"\t"+allVehicles.getFloat(5));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    static void getVehicle(int id){
        Connection con = null;
        try {

            con = DriverManager.getConnection(url,username,password);
            String q = "SELECT * FROM `vehicle` where id = " +id;
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet idVehicle= statement.executeQuery(q);
            while(idVehicle.next()){
                System.out.println((idVehicle.getInt(1)
                        +"\t"+idVehicle.getString(2)
                        +"\t"+idVehicle.getString(3)
                        +"\t"+idVehicle.getString(4)
                        +"\t"+idVehicle.getFloat(5)));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



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
    static void delVehicle(int id){
//        String q = "SELECT * FROM `vehicle` where id = " +id;

    }
    public static void main(String[] args) {
//        testCon();
        allVehicles();
        System.out.println("getting id number 3");

        setVehicle("MCK245","John Del Cross","Car",1110.5f,2);
        getVehicle(2);
    }
}
