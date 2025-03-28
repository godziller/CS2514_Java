
// Custom Single Linked-List Class diagram.
public class CustomLinkedList{

	Node head;	// Reference to head of the list
	private int size; // Size of linked list


	// Node class for the Single linked list...
	static class Node{
		int data; // Node's data payload
		Node next; // pointer to next downstream on the list

		// Constructor
		public Node(int data){
			this.data = data;
			this.next = null; // default to null - don't know yet where we place it.
		}
	}

	// Constructor.
	public CustomLinkedList() {
		this.head = null;
		this.size = 0;
	}

	// Method to add node to end.
	public void append(int data){

		// wrap the data in its node instance.
		Node newNode = new Node(data);

		// If this is the first to be added to the list
		if (head == null) {
			head = newNode; // then it becomes the head.
		}
		else {
			// need to walk down the list to the last Node.
			Node current = head; 
			while (current.next != null) {
				current = current.next;
			}
			// when we get to end of list, we append by requiring
			// the current list's last node to point its next from
			// null to this new node. Note the new node is point to null
			current.next = newNode;
		}
		// increment the list size as we have added a new node.
		size++;
	}

	// Method to insert at a specific position
	// position is where we want to place it - the i'th location
	// data is the new data we want to store in our list
	public void insert(int position, int data){
		// basic error checking to ensure position is valid
		if (position < 0 || position > size){
			throw new IndexOutOfBoundsException("Invalid position");
		}

		// wrap the data in its new Node's instance.
		Node newNode = new Node(data);

		// Check do we want this new Node to be head?
		if (position == 0){
			// if so, we update our head pointer
			newNode.next = head;
			head = newNode;
		}else{
			// walk down the list until the node just before the
			// desired position
			Node current = head;
			for (int i = 0; i<position - 1; i++){
				current = current.next;
			}
			// rewire the linked list - setting the new node's next
			// to the position -1 's next
			// and then the position -1's next to this new node.
			newNode.next = current.next;
			current.next = newNode;
		}
		// new node means we increment the list size.
		size++;
	}

	// Deleting a node from the list at position
	public void delete(int position){
		// basic error checking to ensure position is valid
		if (position < 0 || position >= size){
			throw new IndexOutOfBoundsException("Invalid position");
		}

		// Special case if we are removing the head?
		// for example if this was a queue.
		if (position == 0){
			head = head.next;
		} else {
			// walk down the list to the node before the element to be removed.
			Node current = head;
			// wire the element out of the list
			for (int i = 0; i < position - 1; i++){
				current = current.next;
			}
			current.next = current.next.next;
		}
		// deleted element - so we need to reduce list size.
		size--;
	}
	public void deleteLast() {
			// If no elements we still succeeded
        	if (size == 0) return;
			// if we have 1, then we are getting rid of head.
        	if (size == 1) {
            		head = null;
        	} else {
					// walk down the list.
					// and point second from last to null.
					// garbage collection will take care of the last one.
            		Node current = head;
            		while (current.next.next != null) {
                		current = current.next;
            		}
            		current.next = null;
        	}
		// deleted element - so we need to reduce list size.
		size--;
    	}

	// Method to print the list
    	public void printList() {
		// Prity print of our list

        	Node current = head;
        	System.out.print("[");

			// Walk down the list, printing as we go.
        	while (current != null) {
            		System.out.print(current.data);
            		if (current.next != null) {
                		System.out.print(", ");
            		}
            		current = current.next;
        	}
        	System.out.println("]");
    	}

    	public static void main(String[] args) {

			// list instance.
        	CustomLinkedList list = new CustomLinkedList();

        	// Add initial elements
	        list.append(11);
        	list.append(22);
	        list.append(6);
        	list.append(89);
	        list.append(99);

        	System.out.print("Initial linked list: ");
        	list.printList();

        	// Insert 50 at position 2 (third position)
        	list.insert(2, 50);
	        System.out.print("After inserting 50 at position 3: ");
        	list.printList();

	        // Delete the 2nd element (position 1)
        	list.delete(1);
	        System.out.print("After deleting 2nd element: ");
        	list.printList();

	        // Delete the 1st element (position 0)
        	list.delete(0);
	        System.out.print("After deleting 1st element: ");
        	list.printList();

        	// Delete the last element
	        list.deleteLast();
        	System.out.print("After deleting last element: ");
	        list.printList();
    }
}


