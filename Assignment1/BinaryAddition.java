import java.util.Scanner;

// Class to add two user inputted Binary numbers
public class BinaryAddition{
    public static void main(String[] args){
        // Open scanner object.
        Scanner myScanner = new Scanner(System.in);

        // Get first user defined input.
        System.out.println("Enter first binary number: ");
        String binary1 = myScanner.nextLine();

        // Check if the first input is a valid binary number
        if (!isValidBinary(binary1)) {
            System.out.println("Invalid binary number: " + binary1);
            myScanner.close();
            return;
        }

        // Get input 2.
        System.out.println("Enter second binary number: ");
        String binary2 = myScanner.nextLine();

        // Check if the second input is a valid binary number
        if (!isValidBinary(binary2)) {
            System.out.println("Invalid binary number: " + binary2);
            myScanner.close();
            return;
        }

        // Convert binary numbers to decimal
        int num1 = Integer.parseInt(binary1, 2);
        int num2 = Integer.parseInt(binary2, 2);

        // Calculate sum in decimal
        int sumDecimal = num1 + num2;

        // Convert the sum to binary
        String sumBinary = Integer.toBinaryString(sumDecimal);

        System.out.println("The Sum in binary is: " + sumBinary);
        System.out.println("The Sum in decimal is: " + sumDecimal);

        // Close scanner.
        myScanner.close();
    }

    // Ok, a string coming in, so need to check if its only 1's and O's
    public static boolean isValidBinary(String binary) {
        // Check each character in the string
        for (int i = 0; i < binary.length(); i++) {
            // If the character is neither '0' nor '1', return false
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                return false;
            }
        }
        // If all characters are valid binary digits, return true
        return true;
    }
}
