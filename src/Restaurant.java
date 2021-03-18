import java.util.List;

public class Restaurant extends User{
    List<Dish> menu;

    public Restaurant(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
    }

    @Override
    public void operations() {

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

    class Dish {
        int DishID;
        String name;
        double price;

        public Dish(String name, double price, int DID) {
            this.name = name;
            this.price = price;
            this.DishID = DID;
        }
    }
}
