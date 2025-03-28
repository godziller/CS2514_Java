//PrintPattern Class to print a right orientated triangle
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

