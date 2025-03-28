import java.util.*;

public class AnagramChecker{
	public static void main(String[] args){
	
		// Create scanner object
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first string: ");
		String str1 = scanner.nextLine();

		System.out.println("Enter second string");
		String str2 = scanner.nextLine();

		if (areAnagrams(str1, str2)){
			System.out.println("Strings are anagrams!!");
		}
		else {
			System.out.println("Strings are not anagrams :( .");
		}

		scanner.close();
	}

	public static boolean areAnagrams(String str1, String str2){
	
		String s1 = str1.replaceAll("\\s", "").toLowerCase();
		String s2 = str2.replaceAll("\\s", "").toLowerCase();

		if (s1.length() != s2.length()) {
			return false;
		}
		
		// Convert string the char arrays 
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		return Arrays.equals(charArray1, charArray2);
	}
}
