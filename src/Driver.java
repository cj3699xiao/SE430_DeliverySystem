import java.util.Scanner;

public class Driver extends User{

    public Driver(String UID, String UN, String PN, String address, String Password,DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
    }

    @Override
    public void operations() {
        // to change!
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

    private void confirmDelivered() {

    }

    private void confirmPickup() {

    }


}
