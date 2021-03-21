import java.util.List;
import java.util.Scanner;

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

    public String getAddress() {return address;}

    public DeliverySystem getDeliverySystem() {
        return this.deliverySystem;
    }

    public void report() {
        System.out.println("Please email your issues to 123@gmail.com. Admin will contact you soon.");
    };

    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("UserID: ");
        res.append(this.UserID);
        res.append(" UserName: ");
        res.append(this.UserName);
        res.append(" PhoneNumber: ");
        res.append(this.PhoneNumber);
        res.append(" Address: ");
        res.append(this.address);
        return res.toString();
    }

    public abstract void operations(Scanner input);


}
