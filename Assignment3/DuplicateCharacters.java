import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to interrogate a user inputted string
// and find duplicate characters
public class DuplicateCharacters {
	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your string: ");
		String input = scanner.nextLine();

		// Find and print duplicate characters from user string.
		findDuplicateCharacters(input);

		scanner.close();
	}

	public static void findDuplicateCharacters(String str){

		// Useing a HashMap as a mechanism to collect character frequency info
		// [Char, charount]
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Convert the string to character array
		char[] chars = str.toCharArray();

		// Count occurences of each character
		for (char c : chars) {
			// Was this character seen/stored before?
			if (charCountMap.containsKey(c)) {
				// if so, increment the count value by 1
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				// new observed char, so set count value to 1
				charCountMap.put(c,1);
			}
		}

		// Print Duplicate characters
		System.out.println("Duplicate characters in the string: " + str );
		boolean duplicatesFound = false;

		// Loop through the hashmap
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
			// if a char is seen more than once, print out.
			if (entry.getValue() > 1){
				System.out.println("Character '" + entry.getKey() + "' appears " + entry.getValue() + " times");

			}
			duplicatesFound = true;
		}


	}
}
