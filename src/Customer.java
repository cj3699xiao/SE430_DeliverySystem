import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private List<Order> orderList;


    public Customer(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
        orderList = new ArrayList<>();

    }

    @Override
    public void operations(Scanner input) {
//        Scanner input = new Scanner(System.in);
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
                Order newOrder = new Order(super.getDeliverySystem().allOrder.size());

                //show all restaurant, allow to select valid one
                super.getDeliverySystem().printAllRestaurant();
                System.out.println("Please select your restaurant: ");
                String restInput = input.nextLine();
                int restNum = -1;

                try {
                    restNum = Integer.parseInt(restInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid restaurant number!");
                    continue;
                }

                if (restNum < 0 || restNum >= super.getDeliverySystem().allRestaurant.size()) {
                    System.out.println("Error! Please enter a valid restaurant number!");
                    continue;
                }

                newOrder.orderRestaurant = super.getDeliverySystem().allRestaurant.get(restNum);

                //show menu, allow add into order
                newOrder.orderRestaurant.printMenu();
                int dishNum = 0;

                while (dishNum != -1) {
                    System.out.println("Enter -1 to finish ");
                    System.out.println("Please select your dishes: ");
                    String dishInput = input.nextLine();

                    //duplicate code, to do
                    try {
                        dishNum = Integer.parseInt(dishInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Error! Please enter a valid dish number!");
                        continue;
                    }

                    if (dishNum == - 1) {
                        continue;
                    }

                    if (dishNum < 0 || dishNum >= newOrder.orderRestaurant.menu.size()) {
                        System.out.println("Error! Please enter a valid dish number!");
                        continue;
                    }

                    newOrder.OrderContent.add(newOrder.orderRestaurant.menu.get(dishNum));
                    newOrder.price += newOrder.orderRestaurant.menu.get(dishNum).price;

                    //print current order content
                    System.out.println("-----------------");
                    System.out.println("Your current order has: ");

                    for (int i = 0; i <= newOrder.OrderContent.size() - 1; i++) {
                        System.out.println(newOrder.OrderContent.get(i).toString());
                    }
                    System.out.println("Your current price is: $" + newOrder.price);
                }


                // submit --> add to user || cancel --> noop
                System.out.println("Please enter 1 to confirm your order or 2 to cancel: ");
                String confirmInput = input.nextLine();
                int confirmOp = 0;

                // if not 1, will cancel, could improve. to do
                try {
                    confirmOp = Integer.parseInt(confirmInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid operation number!");
                    continue;
                }

                if (confirmOp !=  1 && confirmOp != 2) {
                    System.out.println("Error! Please enter a valid operation number!");
                    continue;
                }

                if (confirmOp == 1) {
                    newOrder.orderCustomer = this;
                    newOrder.status = Order.Status.WaitRestaurantConfirm;

                    this.orderList.add(newOrder);
                    super.getDeliverySystem().allOrder.add(newOrder);
                    newOrder.orderRestaurant.OrderList.add(newOrder);
                }
                continue;


            } else if (oper == 2) {
                // print all my orders (for now, later could sharding)
                for (int i = 0; i <= this.orderList.size() - 1; i++) {
                    System.out.println("--------------------");
                    System.out.println(orderList.get(i).toString());
                }
                System.out.println();
                continue;

            } else if (oper == 3) {
                // report to admin, with calls/emails, not inside system
                System.out.println("Please email your issues to 123@gmail.com. Admin will contact you soon.");

            } else if (oper == 9) {
                break;
            } else {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }
        }

//        input.close();
    }


//    private void selectRestaurant(Scanner in) {
//
//    }
//
//    private void createOrder() {
//
//    }
//
//    private void confirmOrder() {
//
//    }

    @Override
    public String toString() {
        return super.getUserName();
    }

    public static void main(String[] args) {

    }
}

