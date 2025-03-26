public class CustomLinkedList{
	
	// Node class for the linked list...
	static class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	Node head;	// head of the list
	private int size; // to track list size
	
	// Constructor.
	public CustomLinkedList() {
		this.head = null;
		this.size = 0;
	}

	// Method to add node to end.
	public void append(int data){
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		}
		else {
		
			Node current = head; 
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	// Method to insert at a specific position
	public void insert(int position, int data){
		if (position < 0 || position > size){
			throw new IndexOutOfBoundsException("Invalid position");
		}

		Node newNode = new Node(data);

		if (position == 0){
			newNode.next = head;
			head = newNode;
		}else{
			Node current = head;
			for (int i = 0; i<position - 1; i++){
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}

	// Deleting a node from the list.
	public void delete(int position){
		if (position < 0 || position >= size){
			throw new IndexOutOfBoundsException("Invalid position");
		}

		if (position == 0){
			head = head.next;
		} else {
			Node current = head;
			for (int i = 0; i < position - 1; i++){
				current = current.next;
			}
			current.next = current.next.next;
		}
		size--;
	}
	public void deleteLast() {
        	if (size == 0) return;

        	if (size == 1) {
            		head = null;
        	} else {
            		Node current = head;
            		while (current.next.next != null) {
                		current = current.next;
            		}
            		current.next = null;
        	}
        	size--;
    	}

	// Method to print the list
    	public void printList() {
        	Node current = head;
        	System.out.print("[");
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


