import java.util.Scanner;

// While this program is simple the challenge is ensuring
// The user inputs correct values.
// Int is obvious, but double is a valid input here as well.
// So we create a method to handle ensureing what comes in is
// valid.

public class PowerOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get valid base input
        double base = getDoubleInput(scanner, "Enter the base: ");

        // Get valid exponent input (now a double)
        double exponent = getDoubleInput(scanner, "Enter the exponent: ");

        // Here we handle an interesting input permutation.
        // What if the user enters a negative number, but then a negative fraction as
        // the exponent. We essentailly end up with trying to get the root of
        // a negative number - which mathematically not possible.
        // so we try and catch it here....
        if (base < 0 && exponent % 1 != 0) {
            System.out.println("Error: Negative base cannot be raised to a fractional exponent.");
        } else {
            double result = Math.pow(base, exponent);
            System.out.println(base + " raised to the power of " + exponent + " is: " + result);
        }

        // Close scanner
        scanner.close();
    }

    // Method to get a valid double input from the user
    public static double getDoubleInput(Scanner scanner, String prompt) {

        // Keep asking until user enters valid data...
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Error: Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
