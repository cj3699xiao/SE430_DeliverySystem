import java.util.Scanner;

public class Driver extends User{
    protected Order processOrder;

    public Driver(String UID, String UN, String PN, String address, String Password,DeliverySystem ds) {
        super(UID, UN, PN, address, Password, ds);
    }

    @Override
    public void operations(Scanner input) {
        // to change!
//        Scanner input = new Scanner(System.in);
        int oper = 0;

        while (oper != 9) {
            System.out.println("Hello, Driver " + super.getUserName() + ". Please select following options: ");
            System.out.println("1. Show all available orders");
            System.out.println("2. Choose one order to process");
            System.out.println("3. Confirm order status to been picked up");
            System.out.println("4. Confirm order status to been delivered");
            System.out.println("5. Show my order detail");
            System.out.println("6. Report problem to Admin");
            System.out.println("9. Quit");

            String in = input.nextLine();

            try {
                oper = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please enter a valid operation!");
                continue;
            }

            if (oper == 1) {
                // print out all wait for pick up orders of System
                for (int i = 0; i <= super.getDeliverySystem().allOrder.size() - 1; i++) {
                    if (super.getDeliverySystem().allOrder.get(i).status == Order.Status.WaitDriverPickup && super.getDeliverySystem().allOrder.get(i).orderDriver == null) {
                        System.out.println(super.getDeliverySystem().allOrder.get(i).toString());
                        System.out.println("-----------------");
                    }

                }

            } else if(oper == 2) {
                if (processOrder != null) {
                    System.out.println("Please finish your processing order before take others !!");
                    continue;
                }

                // choose one to be process
                System.out.println("Please select the Order you want to process: ");
                String orderInput = input.nextLine();
                int orderNum = -1;

                try {
                    orderNum = Integer.parseInt(orderInput);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Please enter a valid order number!");
                    continue;
                }

                if (orderNum < 0 || orderNum > super.getDeliverySystem().allOrder.size() - 1) {
                    System.out.println("Error! Please enter a valid order number!");
                    continue;
                }

                if (super.getDeliverySystem().allOrder.get(orderNum).status != Order.Status.WaitDriverPickup) {
                    // multi-thread potential --> data race, to do
                    System.out.println("Error! The order is not wait for picked up!");
                    continue;
                }

                if (super.getDeliverySystem().allOrder.get(orderNum).orderDriver != null) {
                    // multi-thread potential --> data race, to do
                    System.out.println("Error! The order is already been process by someone else !");
                    continue;
                }

                super.getDeliverySystem().allOrder.get(orderNum).orderDriver = this;
                processOrder = super.getDeliverySystem().allOrder.get(orderNum);
                System.out.println("You have selected to process order" + super.getDeliverySystem().allOrder.get(orderNum).toString());


            } else if(oper == 3) {
                // change process status to picked up
                if (processOrder == null) {
                    System.out.println("You have no processing order!");
                    continue;
                }
//                processOrder.status = Order.Status.DriverDelivering;
//                System.out.println("Status change to Delivering !");
                this.confirmPickup();

            } else if(oper == 4) {
                // change process status to delivered
                if (processOrder == null) {
                    System.out.println("You have no processing order!");
                    continue;
                }
//                processOrder.status = Order.Status.Delivered;
//                System.out.println("Status change to Delivered ! We will let the customer know it. ");
//                processOrder = null;
                this.confirmDelivered();

            } else if(oper == 5) {
                // show process order status
                if (processOrder == null) {
                    System.out.println("You have no processing order!");
                } else {
                    System.out.println(processOrder.toString());
                }

                continue;

            }  else if(oper == 6) {
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

    @Override
    public String toString() {
        return super.getUserName();
    }



    private void confirmDelivered() {
        processOrder.status = Order.Status.Delivered;
        processOrder = null;
        System.out.println("Status change to Delivered ! We will let the customer know it. ");
    }

    private void confirmPickup() {
        processOrder.status = Order.Status.DriverDelivering;
        System.out.println("Status change to Delivering !");
    }


}
