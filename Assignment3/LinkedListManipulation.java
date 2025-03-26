import java.util.LinkedList;

public class LinkedListManipulation {
	public static void main(String[] args){
	
		// Create & Initialize Linked List.
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.add(11);
                numbers.add(22);
                numbers.add(6);
                numbers.add(89);
                numbers.add(99);

		System.out.println("Initial Linked list: " + numbers);

		// Insert 50 at the third position
		numbers.add(2, 50);
		System.out.println("After inserting 50 at position 3: " + numbers);

		// Delete 2nd element
		numbers.remove(1);
		System.out.println("After deleting 2nd element: " + numbers);

		// Delete 2nd element
                numbers.remove(1);
                System.out.println("After deleting 2nd element: " + numbers);
		
		// Delete the last element
        	numbers.removeLast();
        	System.out.println("After deleting last element: " + numbers);

	}
}
