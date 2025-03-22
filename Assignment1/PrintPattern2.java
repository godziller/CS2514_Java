import java.util.Scanner;

public class PrintPattern2 {
	public static void main(String[] args) {

		// Create a Scanner object to get user input
		Scanner scanner = new Scanner(System.in);

		// Ask the user for the number of rows
		System.out.print("Enter the number of rows: ");
		int rows = scanner.nextInt();

		// Close the scanner after use
		scanner.close();

		// If the number of rows is even, rounding to nearest odd number (rows + 1)
		if (rows % 2 == 0) {
			System.out.println("Printing diamond requires an odd number. Using " + (rows + 1) + " rows instead.");
			rows = rows + 1;  // Increase by 1 to make it odd
		}

		// This is why I need odd rows....
		int mid = rows / 2;  // Midpoint to split the diamond

		// Going to break this into two parts - the top half of the diamond
		// then the bottom part of the diamond...

		// Top part of the diamond (including the middle row)
		// i drives down to the middle, including the middle
		for (int i = 0; i <= mid; i++) {
			String rowBuffer = "";

			// Add spaces before the stars
			for (int j = 0; j < mid - i; j++) {
				rowBuffer = rowBuffer + ' ';
			}

			// Add stars. I need stars to increment in odd numbers
			// so row 1 will have *
			// row 2 will have *** (3)
			// row 3 will have **** (5)
			// i, the row index here drives the above via (2*i+1)
			for (int k = 0; k < 2 * i + 1; k++) {
				rowBuffer = rowBuffer + '*';
			}

			// Print the row
			System.out.println(rowBuffer);
		}

		// Bottom part of the diamond
		// i here drives down the remainder of the diamond, but the
		// middle is handled earlier.
		for (int i = mid - 1; i >= 0; i--) {
			String rowBuffer = "";

			// Add spaces before the stars
			for (int j = 0; j < mid - i; j++) {
				rowBuffer = rowBuffer + ' ';
			}

			// Add stars
			// Add stars. I need stars to increment in odd numbers
			// row 3 will have **** (5)
			// row 2 will have *** (3)
			// so row 1 will have *

			// i, the row index here drives the above via (2*i+1)
			for (int k = 0; k < 2 * i + 1; k++) {
				rowBuffer = rowBuffer + '*';
			}

			// Print the row
			System.out.println(rowBuffer);
		}
	}
}
