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

                if (orderOp < 0 || orderOp >= this.getDeliverySystem().allOrder.size()) {
                    System.out.println("Error! Please enter a valid order id !");
                    continue;
                }

                this.editOrder(orderOp, input);

            } else if(oper == 2) {
                // print out all restaurant & potential edit
                for (int i = 0; i <= this.getDeliverySystem().allRestaurant.size() - 1; i++) {
                    System.out.println(this.getDeliverySystem().allRestaurant.get(i).toString());
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

    }

    private void editRestaurant(int UID) {

    }

//    private void editCustomer(String UID) {
//
//    }



//    private void editDriver(String UID) {
//
//    }
}
