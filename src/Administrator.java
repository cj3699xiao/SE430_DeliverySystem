import java.util.Scanner;

public class Administrator extends User{
    public Administrator(String UID, String UN, String PN, String address, String Password, DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
    }

    @Override
    public void operations(Scanner input) {

        int oper = 0;

        while (oper != 9) {
            System.out.println("Hello, Admin " + super.getUserName() + ". Please select following options: ");
            System.out.println("1. Show all orders & operations");
            System.out.println("2. Show all restaurant & operations");
            System.out.println("3. Show all customs");
            System.out.println("4. Show all drivers");
            System.out.println("9. Quit");

            String in = input.nextLine();

            try {
                oper = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }

            if (oper == 1) {
                // print out all orders & ask for potential edit
                for (int i = 0; i <= this.getDeliverySystem().allOrder.size() - 1; i++) {
                    System.out.println(this.getDeliverySystem().allOrder.get(i).toString());
                    System.out.println("--------------");
                }

                System.out.println("Please enter target order ID to edit or enter -1 to quit: ");

                String orderInput = input.nextLine();
                int orderOp = -1;

                try {
                    orderOp = Integer.parseInt(orderInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid operation!");
                    continue;
                }

                if (orderOp == -1) {
                    continue;
                }

                if (orderOp < 0 || orderOp > this.getDeliverySystem().allOrder.size() -1) {
                    System.out.println("Error! Please enter a valid order id !");
                    continue;
                }

                this.editOrder(orderOp, input);

            } else if(oper == 2) {
                // print out all restaurant & potential edit
                for (int i = 0; i <= this.getDeliverySystem().allRestaurant.size() - 1; i++) {
                    System.out.println(this.getDeliverySystem().allRestaurant.get(i).getInfo());
                    System.out.println("--------------");
                }

                // to do

            } else if(oper == 3) {

                for (int i = 0; i <= this.getDeliverySystem().allCustomer.size() - 1; i++) {
                    System.out.println(this.getDeliverySystem().allCustomer.get(i).getInfo());
                    System.out.println("--------------");
                }

            } else if(oper == 4) {

                for (int i = 0; i <= this.getDeliverySystem().allDriver.size() - 1; i++) {
                    System.out.println(this.getDeliverySystem().allDriver.get(i).getInfo());
                    System.out.println("--------------");
                }

            } else if (oper == 9) {
                break;
            } else {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }
        }


    }

    private void editOrder(int OrderID, Scanner input) {
        // add & remove

        int oper = -1;
        System.out.println("Please enter following operations: ");
        System.out.println("1. add dishes");
        System.out.println("2. remove dishes");
        System.out.println("3. change status to Reported ");
        System.out.println("4. cancel ");

        String opInput = input.nextLine();

        try {
            oper = Integer.parseInt(opInput);
        } catch (NumberFormatException e) {
            System.out.println("Error! Please enter a valid operation!");
        }

        if (oper == 1) {
            // add dish
            int addOp = -2;
            Order process = this.getDeliverySystem().allOrder.get(OrderID);

            while (addOp != -1) {
                System.out.println(process.toString());
                System.out.println("-----------------");
                System.out.println("Here is the menu of restaurant: ");
                process.orderRestaurant.printMenu();

                System.out.println("Please enter to dish number you want to add or -1 to stop: ");
                String addInput = input.nextLine();

                try {
                    addOp = Integer.parseInt(addInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid operation!");
                }

                if (addOp == -1) {
                    continue;
                }

                if (addOp < 0 || addOp > process.orderRestaurant.menu.size() - 1) {
                    System.out.println("Error! Please enter a valid dish number!");
                }

                process.addItem(process.orderRestaurant.menu.get(addOp));
            }

        } else if(oper == 2) {
            // remove dish
            int removeOp = -2;
            Order process = this.getDeliverySystem().allOrder.get(OrderID);

            while (removeOp != -1) {
                System.out.println(process.toString());

                System.out.println("Please enter to dish number you want to remove, -3 to clean all or -1 to stop: ");
                String removeInput = input.nextLine();

                try {
                    removeOp = Integer.parseInt(removeInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid operation!");
                }

                if (removeOp == -1) {
                    continue;
                }

                if (removeOp == -3 || process.OrderContent.size() == 0) {
                    process.emptyOrder();
                    System.out.println("Order content is clean up !");
                    break;
                }

                if (removeOp < 0 || removeOp > process.OrderContent.size() - 1) {
                    System.out.println("Error! Please enter a valid dish number!");
                }

                process.deleteItem(removeOp);
            }

        } else if(oper == 3) {

            this.getDeliverySystem().allOrder.get(OrderID).status = Order.Status.Reported;
            System.out.println(this.getDeliverySystem().allOrder.get(OrderID).toString());

        } else if(oper == 4) {
            return;
        } else {
            // to be improve
            return;
        }


    }

    private void editRestaurant(int UID) {
        // to do
        // add remove dish

    }

//    private void editCustomer(String UID) {
//
//    }



//    private void editDriver(String UID) {
//
//    }
}
