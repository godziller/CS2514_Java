public class BeautySalonTest {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("Darren");
        Customer customer2 = new Customer("Ruairi");
        Customer customer3 = new Customer("Emma");
        Customer customer4 = new Customer("Tom");
        
        // Set membership types for first 3 customers
        customer1.setMemberType("Premium");
        customer2.setMemberType("Gold");
        customer3.setMemberType("Silver");
        // Note, customer4 remains non-member
        
        // Customer 1 pays a visit
        Visit visit1 = new Visit(customer1);
        // And spends some money
        visit1.setServiceExpense(100.0);
        visit1.setProductExpense(50.0);

        // Customer 2 follows in.
        Visit visit2 = new Visit(customer2);
        // And buys the same stuff!
        visit2.setServiceExpense(100.0);
        visit2.setProductExpense(50.0);

        // Customer 3 makes an appearance.
        Visit visit3 = new Visit(customer3);
        // And has a bit more to spend
        visit3.setServiceExpense(120.0);
        visit3.setProductExpense(150.0);

        // Customer 4 comes in.
        Visit visit4 = new Visit(customer4);
        // And buys little because he decides he isn't a memeber
        visit4.setServiceExpense(10.0);
        visit4.setProductExpense(5.0);
        
        // Print results - using the nice override from the Visit class def.
        System.out.println("=== Premium Member ===");
        System.out.println(visit1);
        
        System.out.println("\n=== Gold Member ===");
        System.out.println(visit2);
        
        System.out.println("\n=== Silver Member ===");
        System.out.println(visit3);
        
        System.out.println("\n=== Non-Member ===");
        System.out.println(visit4);
    }
}
