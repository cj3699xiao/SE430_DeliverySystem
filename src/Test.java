import java.util.Scanner;

public class Test {
    //this class is used for testing
    public static void main(String[] args) {

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

        Scanner input = new Scanner(System.in);
        //Customer journey test
        System.out.println("Customer User journey --> ");
        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        User test = new Customer("1","testCustomer","312-1111","wow St","123",testDS);
        test.operations(input);

        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        //Restaurant user journey test
        System.out.println("Restaurant User journey --> ");
        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        testR0.operations(input);

        System.out.println("All Orders in system now:");
        testDS.printAllOrder();
        System.out.println("--------------");

        // Driver user journey test


        input.close();

    }
}
