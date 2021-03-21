import java.util.ArrayList;
import java.util.List;

public class Order {
    int OrderID;
    Status status;
    List<Restaurant.Dish> OrderContent;
    double price;
    Customer orderCustomer;
    Restaurant orderRestaurant;
    Driver orderDriver;

    // potential changed --> add public cart to improve encapsulation
    public Order(int orderID) {
        this.OrderID = orderID;
        OrderContent = new ArrayList<>();
    }

    protected boolean addItem(Restaurant.Dish dish) {
        OrderContent.add(dish);
        return true;
    }

    protected boolean deleteItem(int index) {
        OrderContent.remove(index);
        return true;
    }

    protected void updatePrice() {
        double res = 0;
        for (Restaurant.Dish cur : OrderContent) {
            res += cur.price;
        }
        price = res;
    }

//    public void showDetails() {
//
//    }
//
//    public void submitOrder() {
//
//    }

    public void emptyOrder() {
        OrderContent = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("OrderID:  ");
        res.append(OrderID);
        res.append("  Customer: ");
        res.append(orderCustomer);
        res.append("  Customer Address: ");
        res.append(orderCustomer.getAddress());
        res.append("  Customer Number: ");
        res.append(orderCustomer.getPhoneNumber());

        res.append("\nRestaurant: ");
        res.append(orderRestaurant);
        res.append(".  Price:  $");
        res.append(price);
        res.append("  Driver:  ");
        res.append(orderDriver);
        res.append("\nStatus: ");
        res.append(status.toString());

        // add all dishes as well, to do
        for (int i = 0; i <= OrderContent.size() - 1; i++) {
            res.append("\n" + i + ". " + OrderContent.get(i).toString());
        }
        return res.toString();
    }

    public enum Status {
        WaitRestaurantConfirm,
        RestaurantPreparing,
        WaitDriverPickup,
        DriverDelivering,
        Delivered,
        Reported;

    }


}
