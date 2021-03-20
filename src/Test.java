public class Test {
    //this class is used for testing
    public static void main(String[] args) {

        DeliverySystem testDS = new DeliverySystem();

        Restaurant testR0 = new Restaurant("0","testBurgerRestaurant0","312-0000","rt0 St","123",testDS);
        testR0.menu.add(new Restaurant.Dish("burger0", 3.0, 0));

        testDS.allRestaurant.add(testR0);


        //use journey test
        User test = new Customer("1","testCustomer","312-1111","wow St","123",testDS);
        test.operations();

    }
}
