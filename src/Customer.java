import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private List<Order> orderList;

    public Customer(String UID, String UN, String PN, String address, String Password) {
        super(UID, UN, PN, address, Password);
        orderList = new ArrayList<>();
    }

    @Override
    public void operations() {
        Scanner input = new Scanner(System.in);
        int oper = 0;

        while (oper != 9) {
            System.out.println("Hello, User " + super.getUserName() + ". Please select following options: ");
            System.out.println("1. Create new Order");
            System.out.println("2. Show all my orders");
            System.out.println("3. Report problem to Admin");
            System.out.println("9. Quit");

            String in = input.nextLine();

            try {
                oper = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }

            if (oper == 1) {
                //create new order
                //show all restaurant
                //show menu, allow add into order
                // submit --> add to user || cancel --> noop
            } else if (oper == 2) {
                // print all my orders (for now, later could sharding)

            } else if (oper == 3) {
                // report to admin, with calls/emails, not inside system

            } else if (oper == 9) {
                break;
            } else {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }
        }

        input.close();
    }


    private void selectRestaurant() {

    }

    private void createOrder() {

    }

    private void confirmOrder() {

    }



}

