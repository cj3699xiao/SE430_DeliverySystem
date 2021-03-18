import java.util.List;

public abstract class User {
    private String UserID;
    private String UserName;
    private String PhoneNumber;
    private String address;
    private String Password;

    private DeliverySystem deliverySystem;
    List<Order> UserOrders;

    public User(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        this.UserID = UID;
        this.UserName = UN;
        this.PhoneNumber = PN;
        this.address = address;
        this.Password = Password;
        this.deliverySystem = ds;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public DeliverySystem getDeliverySystem() {
        return this.deliverySystem;
    }

    public void report() {

    }

    public abstract void operations();


}
