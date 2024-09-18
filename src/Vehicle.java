public class Vehicle {
    public int getId() {
        return id;
    }

    private int id;
    private String plateNumber;
    private String ownerName;
    private String type;
    private float fee;

    public Vehicle(int id,String plateNumber, String ownerName, String type, float fee) {
        this.id=id;
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.type = type;
        this.fee = fee;
    }


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", type='" + type + '\'' +
                ", fee=" + fee +
                '}';
    }
}
