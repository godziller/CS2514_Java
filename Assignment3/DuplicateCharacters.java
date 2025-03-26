import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacters {
	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your string: ");
		String input = scanner.nextLine();

		findDuplicateCharacters(input);

		scanner.close();
	}

	public static void findDuplicateCharacters(String str){
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Convert the string to character array.
		char[] chars = str.toCharArray();

		// Count occurences of each character.
		for (char c : chars) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c,1);
			}
		}

		// Print Duplicate characters
		System.out.println("Duplicate characters in the string: " + str );
		boolean duplicatesFound = false;

		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
		
			if (entry.getValue() > 1){
				System.out.println("Character '" + entry.getKey() + "' appears " + entry.getValue() + " times");

			}
			duplicatesFound = true;
		}


	}
}
