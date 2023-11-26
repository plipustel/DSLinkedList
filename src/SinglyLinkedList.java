/**
 * Singly LinkedList
 *
 *
 * @ImplementedBy: Plipus Tel <https://www.plipus.tel.com>
 * @Created: May 20, 2012
 * @LastModified: See in Github log
 * 
 * @Defenition : Linked List is a list that has sequences of node/link/record
 *             where one link connect to the next link using one direction
 *             pointer/reference. The last link always refers to NULL as the
 *             mark where the iteration will be stopped.
 * 
 * @ExampleLinkedList:
 * 
 *                     [head] A -> B -> C -> D -> E [tail] -> null
 * 
 *                     [head] = A [tail] = E [nodes] = A,B,C,D,E [link] = ->
 *                     connect one node to another
 * 
 * @AlgorithmToConstructLinkedList 1.
 * 
 * 
 * @ExampleImplementation 1. Music Play List 2. Students list 3. Etc...
 */

class Node {
	int id;
	String name;
	String email;

	/*
	 * link to reference to the next node just like when we create an instance of a
	 * class
	 * 
	 * Node person = new Node(1, 'Rebecca');
	 */
	Node nextNode = null;

	public Node(int Key, String Name, String Email) {
		this.id = Key;
		this.name = Name;
		this.email = Email;
		this.nextNode = null;
	}
}

/*
 * 2. Construct chain/linked/connected Nodes and is operations;
 */
class NodeList {

	public Node head; /* Can also available accessed */
	public Node tail;
	public Node found;

	public NodeList() {
		this.head = null;
		this.tail = null;
		this.found = null;
	}

	/*
	 * By default insertion is from left/head of nodes 1: empty 2. insert 'data': 2.
	 * head = data 3. data.next = to itself 3. insert 'newData': 4. head = newData
	 * 5. newData.next = head
	 */
	public void constructLinkedList(int Key, String Name, String Email) {

		Node data = new Node(Key, Name, Email);

		/* for the 1st time, set the tail */
		if (this.head == null) {
			data.nextNode = this.tail;
			this.tail = data;
		}

		data.nextNode = this.head; /* next node */
		this.head = data;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void printLinkedList() {
		// System.out.println(head.nextNode.nextNode.name); // 2

		if (isEmpty()) {
			System.out.println("No Data");
			return;
		}
		/*
		 * THIS IS VERY IMPORTANT to define current = head, instead of directly use the
		 * head since it will update the value of head hence causes unexpect behavour of
		 * methods which use the head
		 */
		Node current = head; /* make sure head is independent */

		/* Traverse node by node from current = head until it reach tail */
		while (current != null) {
			System.out.println("+------------------------+");
			System.out.println(current.id + "\n" + current.name + "\n" + current.email);
			current = current.nextNode;

		}
		System.out.println("+------------------------+");

		/* Alternatively, recursive call */
		/*
		 * if (head == null) { return; } System.out.println(head.id + ", " + head.name +
		 * ", " + head.email); head = head.nextNode; printLinkedList();
		 * 
		 **/
	}

	public Node getHead() {
		return head;
	}

	public void removeHead() {
		this.head = head.nextNode; /* make the current head become the next node of head. Don't head = null */
	}

	public Node getTail() {
		return tail;
	}

	public void insertTail(int Key, String Name, String Email) {
		if (isEmpty()) {
			System.out.println("No Data");
			return;
		}
		Node data = new Node(Key, Name, Email);
		this.tail.nextNode = data; /* update the current tail */
		this.tail = data; /* set data as new tail */

	}

	public void removeTail() {
		Node current = head; /* make sure head is independent */
		Node previous = null;

		/* Traverse node by node from current = head until it reach tail */
		while (current.nextNode != null) {
			previous = current;
			current = current.nextNode;
		}

		previous.nextNode = null;
		this.tail = previous;

	}

	public void removeNode(int Key) {

	}

	public int getLength() {
		Node current = head;
		int length = 0;

		while (current != null) {
			length++;
			current = current.nextNode;
		}

		return length;

	}

	/**
	 * This method could be improved into O(log n), this is till O(n)
	 */
	public boolean findNode(int Key) {
		Node current = head; /* make sure head is independent */

		/* Traverse node by node from current = head until it reach tail */
		while (current != null) {
			if (current.id == Key) {
				found = current;
				return true;
			}
			current = current.nextNode;

		}
		return false;

	}
	
	public Node getNode(int Key) {
		Node current = head; /* make sure head is independent */

		/* Traverse node by node from current = head until it reach tail */
		while (current != null) {
			if (current.id == Key) {
				return current;
			}
			current = current.nextNode;

		}
		return null;

	}
	
	
	/* Still not work */
	public void sortLinkedList() {
		
		Node temp = head;
		Node current = head; /* make sure head is independent */
		Node previous = null;

		
		while (current != null ) {
			previous = current;
			System.out.println(previous.id + " vs " +current.id);
			if(previous.id > current.id ) {
				temp = current;
				current = previous;
				previous = temp;
			}
			current = current.nextNode;
		}
	}
	
	public void divide() {
	}
	
	public void conquer() {
		
	}
}

public class SinglyLinkedList {

	public static void main(String[] args) {

		NodeList HappyFamily = new NodeList();

		HappyFamily.constructLinkedList(1, "Afrita", "afrita@plipustel.com"); /* tail */
		HappyFamily.constructLinkedList(2, "Plipus", "plipus@plipustel.com"); /* node */
		HappyFamily.constructLinkedList(3, "Adam", "adam@plipustel.com"); /* head */

		HappyFamily.insertTail(101, "Adam1", "adam@plipustel.com");
		HappyFamily.insertTail(102, "Adam2", "adam@plipustel.com");
		HappyFamily.insertTail(103, "Adam3", "adam@plipustel.com");

		HappyFamily.removeTail();

		HappyFamily.insertTail(105, "Adam3", "adam@plipustel.com");
		// HappyFamily.removeTail();

		HappyFamily.sortLinkedList();
		
		// System.out.println(HappyFamily.getTail().name);
		HappyFamily.printLinkedList();
		// System.out.println(HappyFamily.head.id);
		if (HappyFamily.findNode(3)) {
			System.out.println("Found (" + HappyFamily.found.id + "):\n" + HappyFamily.found.name + "\n"
					+ HappyFamily.found.email);
		}
		System.out.println("Length:" + HappyFamily.getLength());

		System.out.println( HappyFamily.getNode(2).id);

	}

}
