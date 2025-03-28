import java.util.Random;
import java.util.Scanner;

// Class to create a random 3d array, then allow the user to check if a number exist in it.
public class Matrix_3D {
    public static void main(String[] args) {
        // x,y,z are the demsions of our array
        int x = 3, y = 3, z = 3;

        // Set up the matrix with the dimensions
        int[][][] array = new int[x][y][z];

        // To keep things interesting, going to use random numbers
        // to populate the array.
        Random random = new Random();

        // Initialize the array with random values between 1 and 100
        // 3 nested for loops, giving us an O(N^3)
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    array[i][j][k] = random.nextInt(100) + 1; // Random number between 1 and 100
                }
            }
        }

        // Similar style nested loops to print out the array we have so far.
        System.out.println("The 3D array is:");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();  // Newline for better readability
            }
            System.out.println();  // Add an extra line between 2D arrays
        }

        // The user now checks to see if their number is in the array...
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check: ");

        //
        int userNumber = scanner.nextInt();

        // Default to not found until we find it...
        boolean found = false;

        // Our familar tripple nested loop
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    if (array[i][j][k] == userNumber) {
                        found = true;   // we found the user's number, so we can
                        break;  // break out of the search loop.
                    }
                }
                if (found) break;  // cascade out
            }
            if (found) break;   // cascade out further.
                                // Note Java does seem to have an assembly style label/jump feature
                                // but not sure how OO that is , so avoiding.
        }

        // We're at the results section now.
        if (found) {
            System.out.println("The number " + userNumber + " is present in the array.");
        } else {
            System.out.println("The number " + userNumber + " is NOT present in the array.");
        }
        
        scanner.close();
    }
}

