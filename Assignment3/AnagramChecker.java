import java.util.*;

// Anangram Checker checks to see if 2 strings given
// by a user are anagrams.
public class AnagramChecker{
	public static void main(String[] args){
	
		// Create scanner object
		Scanner scanner = new Scanner(System.in);

		// Take the two strings from user.
		System.out.println("Enter first string: ");
		String str1 = scanner.nextLine();

		System.out.println("Enter second string");
		String str2 = scanner.nextLine();

		// Check if they are anagrams
		if (areAnagrams(str1, str2)){
			System.out.println("Strings are anagrams!!");
		}
		else {
			System.out.println("Strings are not anagrams :( .");
		}
		scanner.close();
	}

	// Takes two strings and returns true or false if they are an anagram of each other.
	public static boolean areAnagrams(String str1, String str2){

		// Normalize the string - drop all to lower case
		// and remove all tabs/spaces/newlines
		String s1 = str1.replaceAll("\\s", "").toLowerCase();
		String s2 = str2.replaceAll("\\s", "").toLowerCase();

		// Simple first check - if they are not the same length they cant be an anagram.
		if (s1.length() != s2.length()) {
			return false;
		}
		
		// Convert string the char arrays
		// so we can sort and compare
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();

		// doing a simple sort of our char array will allow us to then
		// check if they are equal.
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		// if the sorted arrays of characters are equal then
		//  return true, else return false.
		return Arrays.equals(charArray1, charArray2);
	}
}
