import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args){
        // Create a scanner object.
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter your year: ");
        // Read input as string to validate the format
        String yearStr = myScanner.nextLine();

        // Check if the input is a valid year
        if (isValidYear(yearStr)) {
            // and then convert the valid year string to an integer
            int year = Integer.parseInt(yearStr);

            // Now check if it's a leap year using the isLeapYear method
            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year");
            } else {
                System.out.println(year + " is NOT a leap year");
            }
        } else {
            System.out.println("Invalid year format. Please enter a valid 4-digit year.");
        }
        // Close scanner.
        myScanner.close();
    }

    // Method to check if the year is a leap year
    // Returns a boolean true/false if its a leap year or not.
    // Assums the caller passes a correct into - 0000->9999

    public static boolean isLeapYear(int year) {
        // A year is a leap year if it is divisible by 4, but not divisible by 100 unless it is also divisible by 400..
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Need something to check if the input string is a valid year or not..
    // As the scanner might present any random string from the user we need
    // to ensure its in the year format before we can do anything iwth it.

    public static boolean isValidYear(String yearStr) {
        // Check if the string has exactly 4 characters
        if (yearStr != null && yearStr.length() == 4) {
            // Is everything a digit ???
            for (int i = 0; i < yearStr.length(); i++) {
                if (!Character.isDigit(yearStr.charAt(i))) {
                    return false; // Return false if any character is not a digit
                }
            }
            // At this point our yearStr is 4 digits between 0000 and 9999
            return true;
        }
        // If the string does not have exactly 4 characters, return false
        return false;
    }
}
