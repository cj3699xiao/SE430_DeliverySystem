import java.util.Scanner;

public class Test {
    //this class is used for testing
    public static void main(String[] args) {
        // initial
        DeliverySystem testDS = new DeliverySystem();

        Restaurant testR0 = new Restaurant("0","testBurgerRestaurant0","312-0000","rt0 St","123",testDS);
        Restaurant testR1 = new Restaurant("1","testSaladRestaurant1","312-0001","rt1 St","123",testDS);
        Restaurant testR2 = new Restaurant("2","testSteakRestaurant2","312-0002","rt2 St","123",testDS);
        testR0.menu.add(new Restaurant.Dish("burger0", 3.0, 0));
        testR0.menu.add(new Restaurant.Dish("burger1", 5.0, 1));
        testR0.menu.add(new Restaurant.Dish("burger2", 7.0, 2));

        testR1.menu.add(new Restaurant.Dish("Salad0", 1.5, 0));
        testR1.menu.add(new Restaurant.Dish("Salad1", 2.5, 1));
        testR1.menu.add(new Restaurant.Dish("Salad2", 3.5, 2));

        testR2.menu.add(new Restaurant.Dish("Steak0", 8.0, 0));
        testR2.menu.add(new Restaurant.Dish("Steak1", 9.5, 1));
        testR2.menu.add(new Restaurant.Dish("Steak2", 11.5, 2));

        testDS.allRestaurant.add(testR0);
        testDS.allRestaurant.add(testR1);
        testDS.allRestaurant.add(testR2);

        Customer testCustomer = new Customer("1","testCustomer","312-1111","wow St","123",testDS);
        testDS.allCustomer.add(testCustomer);
        Driver testDriver = new Driver("1","testDriver","312-9999","driver St","123",testDS);
        testDS.allDriver.add(testDriver);
        Administrator testAdmin = new Administrator("1","testAdmin","990-8888","admin St","123",testDS);
        testDS.allAdmin.add(testAdmin);

        Scanner input = new Scanner(System.in);


        //Customer journey test
        System.out.println("Customer User journey --> ");
        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        testCustomer.operations(input);

        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        //Restaurant user journey test
//        System.out.println("Restaurant User journey --> ");
//        System.out.println("All Orders in system now:");
//        testDS.printAllOrder();
//        System.out.println("--------------");
//
//        testR0.operations(input);
//
//        System.out.println("All Orders in system now:");
//        testDS.printAllOrder();
//        System.out.println("--------------");
//
//        // Driver user journey test
//        System.out.println("Driver User journey --> ");
//        System.out.println("All Orders in system now:");
//        testDS.printAllOrder();
//        System.out.println("--------------");
//
//        testDriver.operations(input);
//
//        System.out.println("All Orders in system now:");
//        testDS.printAllOrder();
//        System.out.println("--------------");

        // Admin user journey test
        System.out.println("Admin User journey --> ");
        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        testAdmin.operations(input);

        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");


        input.close();

    }
}
