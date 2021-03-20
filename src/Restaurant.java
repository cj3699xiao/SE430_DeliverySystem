import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant extends User{
    protected List<Dish> menu;
    protected List<Order> OrderList;

    public Restaurant(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
        menu = new ArrayList<>();
    }

    @Override
    public void operations() {
        Scanner input = new Scanner(System.in);
        int oper = 0;

        while (oper != 9) {
            System.out.println("Hello, Restaurant " + super.getUserName() + ". Please select following options: ");
            System.out.println("1. Show all restaurant orders");
            System.out.println("2. Confirm order status to prepared");
            System.out.println("3. Confirm order status to been picked up");
            System.out.println("4. Report problem to Admin");
            System.out.println("9. Quit");

            String in = input.nextLine();

            try {
                oper = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }

            if (oper == 1) {

            } else if(oper == 2) {

            } else if(oper == 3) {

            } else if(oper == 4) {

            } else if (oper == 9) {
                break;
            } else {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }
        }

        input.close();

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
