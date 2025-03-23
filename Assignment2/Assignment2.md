# Program 1

```mermaid
graph TD
    A[Start] --> B[Create Scanner object for user input]
    B --> C[Loop 10 times to get 10 names]

    subgraph InputLoop[Input Loop]
        C1[Ask for name input]
        C2[Store name in ArrayList]
        C3[Repeat for next name]

        C1 --> C2
        C2 --> C3
        C3 --> C1
    end

    C --> InputLoop
    InputLoop --> D[Close the scanner]
    D --> E[Call bubbleSort to sort names]

subgraph BubbleSort[Bubble Sort Algorithm]
F1[Outer loop: Pass through the list n-1 times]
F2[Inner loop: Compare adjacent names]
F3[If names are out of order, swap them]
F4[Repeat the inner loop until sorted]

F1 --> F2
F2 --> F3
F3 --> F4
F4 --> F2
F4 --> F1
end

E --> BubbleSort
BubbleSort --> L[End of sorting, print sorted names]
L --> M[Display sorted names]
M --> N[End]
```

```java
import java.util.*;
public class OrderNames{
    public static void main(String[] args){
        // make list buffer
        ArrayList<String> names = new ArrayList<>();

        // Create Scanenr Object
        Scanner scanner = new Scanner(System.in);

        // Make a loop of 10, ask for name -> store in list buffer
        for (int i = 1; i <= 10; i++){
            System.out.print("Please enter a name: ");
            String name = scanner.nextLine();
            names.add(name);	// Appending to array.
        }

        scanner.close();

        // Sort list of names -> Alphabetically
        //Collections.sort(names);
        bubbleSort(names);

        System.out.println("Sorted names: ");
        // Iterate over names and print
        for (String name : names){
            System.out.println(name);
        }
    }

    // Instead of using Collections.sort I'm going to try and
    // create my own sort algo here as recommended by question.
    // So bubblesort seems a good idea from CS2516:Algorithms and Data Structures

    public static void bubbleSort(ArrayList<String> names) {
        int n = names.size();
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent strings
                // This should handle Adrian vs Aidan scenarios..
                if (names.get(j).compareTo(names.get(j + 1)) > 0) {
                    // Swap if elements are in the wrong order
                    String temp = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp);
                }
            }
        }
    }
}

```

# Program 2 - Division

```mermaid
graph TD
    A[Start] --> B[Create Scanner object for user input]
    B --> C[Get dividend input numerator]
    C --> D[Call getIntegerInput to get valid dividend]

    subgraph GetIntegerInput[Function: getIntegerInput]
        D1[Prompt user for input: Enter the dividend numerator]
        D2[Check if input is a valid integer]
        D3[If valid, return the number]
        D4[If invalid, display error and prompt again]
        D1 --> D2
        D2 -->|Valid| D3
        D2 -->|Invalid| D4
        D4 --> D1
    end

    D3 --> E[Get divisor input denominator]
    E --> F[Call getDivisorInput to get valid divisor]

    subgraph GetDivisorInput[Function: getDivisorInput]
        F1[Prompt user for input: Enter the divisor non-zero]
        F2[Check if input is valid integer]
        F3[If divisor is not zero, return the divisor]
        F4[If divisor is zero, display error and prompt again]
        F1 --> F2
        F2 -->|Valid| F3
        F2 -->|Zero| F4
        F4 --> F1
    end

    F3 --> G[Perform division quotient and remainder]
    G --> H[Display quotient and remainder]
    H --> I[Close the scanner]
    I --> J[End]



```

```java
import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // When I ask for the user input I need to make sure its Real numbers
        // and also ensure the Divisor is not zero.
        // So we introduce two methors to handle this checking..

        // Get the dividend (numerator)
        int dividend = getIntegerInput(scanner, "Enter the dividend (numerator): ");

        // Get the divisor (denominator)
        int divisor = getDivisorInput(scanner);

        // Perform the division and output the result
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);

        scanner.close();
    }

    // Method to get a valid integer input
    public static int getIntegerInput(Scanner scanner, String prompt) {
        int number = 0;
        boolean valid = false;

        // Going to loop until I get valid integer from user
        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Error: Please enter a valid integer.");
                scanner.next(); // clear the invalid input
            }
        }
        return number;
    }

    // Method to get a valid divisor.
    // This also has to handle the divide by zero issue where the numerator did not.
    public static int getDivisorInput(Scanner scanner) {
        int divisor = 0;
        boolean valid = false;

        // Going to loop until I get valid integer from user
        while (!valid) {
            divisor = getIntegerInput(scanner, "Enter the divisor (non-zero): ");

            if (divisor == 0) {
                System.out.println("Error: Divisor cannot be zero. Please try again.");
            } else {
                valid = true;
            }
        }
        return divisor;
    }
}


```
![Program2.png](Program2.png)

## Program 3 - PowerOf

```java
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

```

![Program3.png](Program3.png)