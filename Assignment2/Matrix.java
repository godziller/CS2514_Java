import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Create both matrix objects as double for better precision
        double[][] matrix1 = new double[3][3];
        double[][] matrix2 = new double[3][3];
        // Create a matrix for storing the result
        double[][] resultMatrix = new double[3][3];

        // Input values for the first matrix
        System.out.println("Enter values (int or float) for the first 3x3 matrix (comma-separated):");
        inputMatrix(scanner, matrix1);

        // Input values for the second matrix
        System.out.println("\nEnter values (int or float) for the second 3x3 matrix (comma-separated):");
        inputMatrix(scanner, matrix2);

        // Perform matrix addition: Add corresponding elements
        // Addition is a simple double loop O(N^2)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j]; // Correctly adding corresponding elements
            }
        }

        // Display the result of the matrix addition
        System.out.println("\nThe result of the matrix addition is:");
        printMatrix(resultMatrix);

        // Close the scanner
        scanner.close();
    }

    // Method to input a matrix
    // To make input easier, we take each row as comma-separated
    public static void inputMatrix(Scanner scanner, double[][] matrix) {
        for (int i = 0; i < 3; i++) {
            boolean validRow = false;
            while (!validRow) {
                System.out.print("Enter row " + (i + 1) + " values (comma-separated): ");
                String input = scanner.nextLine();

                // Split the input string into an array of strings, using commas as separators
                String[] values = input.split(",");

                // Checking if the user entered exactly 3 comma-separated numbers.
                // If not ask them to go again.
                if (values.length != 3) {
                    System.out.println("Error: Please enter exactly 3 values for row " + (i + 1));
                    continue;  // Ask for the row again if the input is not exactly 3 values
                }

                // Ok, we should have valid input at this point, so we..
                // Convert the string values to doubles and assign them to the matrix
                boolean validValues = true;
                for (int j = 0; j < 3; j++) {
                    try {
                        // Trim spaces to avoid errors with unexpected spaces in input
                        matrix[i][j] = Double.parseDouble(values[j].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format. Please enter valid numbers.");
                        validValues = false;
                        break;
                    }
                }

                if (validValues) {
                    validRow = true;  // If all values are valid, move to the next row
                }
            }
        }
    }

    // Method to print a matrix in a neat format
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Print each element with two decimal places for better readability
                // This keeps our matrix print nice and neat.
                System.out.printf("%6.2f ", matrix[i][j]);
            }
            System.out.println(); // New line after each row
        }
    }
}
