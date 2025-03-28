public class BeautySalonTest {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Charlie");
        Customer customer4 = new Customer("Diana");
        
        // Set membership types
        customer1.setMemberType("Premium");
        customer2.setMemberType("Gold");
        customer3.setMemberType("Silver");
        // customer4 remains non-member
        
        // Create visits
        Visit visit1 = new Visit(customer1);
        visit1.setServiceExpense(100.0);
        visit1.setProductExpense(50.0);
        
        Visit visit2 = new Visit(customer2);
        visit2.setServiceExpense(100.0);
        visit2.setProductExpense(50.0);
        
        Visit visit3 = new Visit(customer3);
        visit3.setServiceExpense(100.0);
        visit3.setProductExpense(50.0);
        
        Visit visit4 = new Visit(customer4);
        visit4.setServiceExpense(100.0);
        visit4.setProductExpense(50.0);
        
        // Print results
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
