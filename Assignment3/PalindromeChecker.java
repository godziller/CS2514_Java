import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

public class PalindromeChecker {

	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string to check for palindrome: ");
		String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");

		if (isPalindrome(input)){
			System.out.println(input + " is a palindrome!");
		} else {
			System.out.println(input + " is NOT a palindrome ... :(");
		}

		scanner.close();
	}

	public static boolean isPalindrome(String str) {
	
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();

		// Push characters onto the stack and queue
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			stack.push(c);
			queue.add(c);
		}


		// check Consistency of both Stack and Queue.
		while (!stack.isEmpty()){
			if (stack.pop() != queue.remove()){
				return false;
			}
		}

		return true;
	}
}
