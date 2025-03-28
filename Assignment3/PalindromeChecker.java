import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

// Class to check if a string is a palindrome.
public class PalindromeChecker {

	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string to check for palindrome: ");

		// process the input string.
		// first lower the case.
		// then a simple regex to recognize Palindomes should only work with letters and digits.
		// so if we see anything else strange, we mask out.
		String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");

		if (isPalindrome(input)){
			System.out.println(input + " is a palindrome!");
		} else {
			System.out.println(input + " is NOT a palindrome ... :(");
		}

		scanner.close();
	}

	public static boolean isPalindrome(String str) {

		// Using the classical Stack and Queue from Algo class
		// inserting the string into both results the string getting inverted
		// which means we can do a simple compare of each entry
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();

		// Push characters onto the stack and queue
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			stack.push(c);
			queue.add(c);
		}


		// This is where we leverage the string pushed to a stack and enqueued in a queue
		// popping and removing each in parallel should tell us if we have a palindorme or not.
		while (!stack.isEmpty()){
			if (stack.pop() != queue.remove()){
				return false;
			}
		}

		return true;
	}
}
