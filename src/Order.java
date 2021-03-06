import java.util.ArrayList;
import java.util.List;

public class Order {
    String OrderID;
    List<Restaurant.Dish> OrderContent;
    Double price;
    Customer orderCustomer;
    Restaurant orderRestaurant;
    Driver orderDriver;

    // potential changed --> add public cart to improve encapsulation
    // order --> private
    public boolean addItem(String item) {
        return true;
    }

    public boolean deleteItem(int index) {
        return true;
    }

    public void showDetails() {

    }

    public void submitOrder() {

    }

    public void emptyOrder() {
        OrderContent = new ArrayList<>();
    }


}
