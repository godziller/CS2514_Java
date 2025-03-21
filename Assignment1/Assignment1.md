# Flow chart for Program 1 - Leap year Checker

```java
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
        // A year is a leap year if it is divisible by 4, but not divisible by 100 unless 
        //it is also divisible by 400..
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

```

```mermaid

 flowchart TD
    A[Start] --> B[Create Scanner Object]
    B --> C[Print Please enter your year]
    C --> D[Read input as string]
    D --> E{Is yearStr a valid 4-digit year?}
    E -->|Yes| F[Convert yearStr to integer]
    E -->|No| G[Print Invalid year format]
    F --> H{Is year a leap year?}
    H -->|Yes| I[Print year is a leap year]
    H -->|No| J[Print year is NOT a leap year]
    G --> K[End]
    I --> K
    J --> K
```
![CheckLeapYear.png](CheckLeapYear.png)

# Flow chart for Program 2 - Binary Adder

```java
import java.util.Scanner;

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

```

```mermaid
flowchart TD
    A[Start] --> B[Create Scanner Object]
    B --> C[Print 'Enter first binary number']
    C --> D[Read first binary input]
    D --> E{Is binary1 valid?}
    E -->|No| F[Print 'Invalid binary number and exit']
    E -->|Yes| G[Print 'Enter second binary number']
    G --> H[Read second binary input]
    H --> I{Is binary2 valid?}
    I -->|No| J[Print 'Invalid binary number and exit']
    I -->|Yes| K[Convert binary1 to decimal]
    K --> L[Convert binary2 to decimal]
    L --> M[Calculate sumDecimal = num1 + num2]
    M --> N[Convert sumDecimal to binary]
    N --> O[Print 'The Sum in binary: sumBinary']
    O --> P[Print 'The Sum in decimal: sumDecimal']
    P --> Q[Close scanner and End]

    class A,Q startend;
```
![BinaryAdder.png](BinaryAdder.png)

# Printing Patter for Program 3

```java
//PrintPattern1 - program prints out the following:
//    *
//   **
//  ***
// ****
//*****

public class PrintPattern1{
	public static void main(String[] args){
	
		// Number of rows to print
		int rows = 5;
		
		for (int i = 1; i <= rows; i++){
			// String buffer for each row.
			String rowString = "";

			// loop for spaces (going backwards)
			for (int j = rows + -i; j > 0; j--){
				rowString = rowString + ' '; 
			}

			// Loop for stars
			for (int k = 1; k <= i; k++){
				rowString = rowString + '*';
			}

			// Print buffer
			System.out.println(rowString);
		}

	}
}

```

```mermaid

flowchart TD
    A[Start] --> B[Initialize rows = 5]
    B --> C[Start Outer Loop i = 1 to rows]
    C --> D[Initialize rowString as empty]
    D --> E[Start Inner Loop for spaces j = rows - i to 1]
    E --> F[Append space to rowString]
    F --> G[End Inner Loop for spaces]
    G --> H[Start Inner Loop for stars k = 1 to i]
    H --> I[Append star to rowString]
    I --> J[End Inner Loop for stars]
    J --> K[Print rowString]
    K --> L[Increment i]
    L --> M[Check if i <= rows]
    M --> C
    M --> N[End Outer Loop]
    N --> O[End]
```
![PrintPattern1.png](PrintPattern1.png)