import java.util.List;

public class DeliverySystem {
    List<User> allUser;
    List<Restaurant> allRestaurant;

    public void run() {

    }

    public void sendNotification(User from, User to) {

    }

    public void printAllRestaurant() {
        for (int i = 0; i <= allRestaurant.size() - 1; i++) {
            System.out.println(i + ". "+ allRestaurant.get(i).toString());
        }
    }

}
