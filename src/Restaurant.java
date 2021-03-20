import java.util.ArrayList;
import java.util.List;

public class Restaurant extends User{
    protected List<Dish> menu;
    protected List<Order> OrderList;

    public Restaurant(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
        menu = new ArrayList<>();
    }

    @Override
    public void operations() {

    }

    public void printMenu() {
        for (int i = 0; i <= menu.size() - 1; i++) {
            System.out.println(i + ". " +menu.get(i).toString());
        }

    }


    private void addDish() {

    }

    private void removeDish() {

    }

    private void showMenu() {

    }

    private void confirmPrepared() {

    }

    private void confirmReceived() {

    }

    @Override
    public String toString() {
        return super.getUserName();
    }

    public static class Dish {
        int DishID;
        String name;
        double price;

        public Dish(String name, double price, int DID) {
            this.name = name;
            this.price = price;
            this.DishID = DID;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(this.name);
            res.append("  $ ");
            res.append(this.price);
            return res.toString();
        }
    }
}
