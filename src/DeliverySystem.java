import java.util.ArrayList;
import java.util.List;

public class DeliverySystem {
    List<Customer> allCustomer;
    List<Restaurant> allRestaurant;
    List<Driver> allDriver;
    List<Order> allOrder;

    public DeliverySystem() {
        allRestaurant = new ArrayList<>();
        allCustomer = new ArrayList<>();
        allDriver = new ArrayList<>();
        allOrder = new ArrayList<>();
    }

    public void run() {

    }

    public void sendNotification(User from, User to) {

    }

    public void printAllRestaurant() {
        for (int i = 0; i <= allRestaurant.size() - 1; i++) {
            System.out.println(i + ". "+ allRestaurant.get(i).toString());
        }
    }

    public void printAllOrder() {
        for (int i = 0; i <= allOrder.size() - 1; i++) {
            System.out.println(i + ". "+ allOrder.get(i).toString());
        }
    }

}
