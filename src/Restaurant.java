import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant extends User{
    protected List<Dish> menu;
    protected List<Order> OrderList;

    public Restaurant(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
        menu = new ArrayList<>();
        OrderList = new ArrayList<>();
    }

    @Override
    public void operations(Scanner input) {
//        Scanner restInput = new Scanner(System.in);
        int oper = 0;

        while (oper != 9) {
            System.out.println("Hello, Restaurant " + super.getUserName() + ". Please select following options: ");
            System.out.println("1. Show all restaurant orders");
            System.out.println("2. Confirm order status to confirm");
            System.out.println("3. Confirm order status to be prepared");
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
                // print out all orders of restaurant
                for (int i = 0; i <= OrderList.size() - 1; i++) {
                    System.out.println(OrderList.get(i).toString());
                    System.out.println("-----------------");
                }

            } else if(oper == 2) {
                // confirm order
                System.out.println("Please select the Order you want to confirm: ");
                String orderInput = input.nextLine();
                int orderNum = -1;

                try {
                    orderNum = Integer.parseInt(orderInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid order number!");
                    continue;
                }

                if (orderNum < 0 || orderNum > OrderList.size() - 1) {
                    System.out.println("Error! Please enter a valid order number!");
                    continue;
                }

                if (OrderList.get(orderNum).status != Order.Status.WaitRestaurantConfirm) {
                    System.out.println("Error! The order is not wait for confirmed!");
                    continue;
                }

                OrderList.get(orderNum).status = Order.Status.RestaurantPreparing;
                System.out.println("Order confirmed !");

            } else if(oper == 3) {
                //confirm order is already prepared
                System.out.println("Please select the Order want to change to prepared ");
                String orderInput = input.nextLine();
                int orderNum = -1;

                try {
                    orderNum = Integer.parseInt(orderInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid order number!");
                    continue;
                }

                if (orderNum < 0 || orderNum > OrderList.size() - 1) {
                    System.out.println("Error! Please enter a valid order number!");
                    continue;
                }

                if (OrderList.get(orderNum).status != Order.Status.RestaurantPreparing) {
                    System.out.println("Error! The order is not wait for Preparing!");
                    continue;
                }

                OrderList.get(orderNum).status = Order.Status.WaitDriverPickup;
                System.out.println("Order prepared confirmed! Driver will come and pick it up shortly.");

            } else if(oper == 4) {
                // report to admin, with calls/emails, not inside system
                System.out.println("Please email your issues to 123@gmail.com. Admin will contact you soon.");

            } else if (oper == 9) {
                break;
            } else {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }
        }

//        restInput.close();

    }

    public void printMenu() {
        for (int i = 0; i <= menu.size() - 1; i++) {
            System.out.println(i + ". " +menu.get(i).toString());
        }

    }


    protected void addDish(String name, double price, int DID) {
        Dish toAdd = new Dish(name, price, DID);
        this.menu.add(toAdd);
    }

    protected void removeDish(int index) {
        this.menu.remove(index);
    }


//    private void confirmPrepared() {
//
//    }
//
//    private void confirmReceived() {
//
//    }

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
