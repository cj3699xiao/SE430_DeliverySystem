import java.util.List;

public class Restaurant extends User{
    List<Dish> menu;

    public Restaurant(String UID, String UN, String PN, String address, String Password) {
        super(UID, UN, PN, address, Password);
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
