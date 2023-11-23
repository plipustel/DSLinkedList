/**
 * Singly LinkedList
 *
 *
 * @Author Plipus Tel <https://www.plipus.tel.com>
 * @Created May 20, 2012
 * @LastModified See in github log
 * 
 * @Defenition : Linked List is a list that has sequences of node/link/record
 *             where one link connect to the next link using one direction
 *             pointer/reference. The last link always refers to NULL as the
 *             mark where the iteration will be stopped.
 *      
 * @ExampleLinkedList:
 * 
 * A -> B -> C -> D -> E -> null
 * 
 * [head] = A
 * [tail] = E
 * [nodes] = A,B,C,D,E
 * [link] = ->
 * @AlgorithmToConstructLinkedList
 * 1. 
 */


class Node {
	int id;
	String name;
	String email;
	
	/* link to reference to the next node 
	 * just like when we create an instance of a class
	 * 
	 * Node person = new Node(1, 'Rebecca');
	 * */
	Node nextNode = null; 
	
	public Node(int Key, String Name, String Email) {
		this.id = Key;
		this.name = Name;
		this.email = Email;
		this.nextNode = null;
	}
}

/* 2. Construct chain/linked/connected Nodes and is operations;
 * */
class NodeList {
	
	public Node head; /* Can also available accessed */
	
	public NodeList() {
		this.head = null;
	}
	
	/* By default insertion is from left/head of nodes 
	 * 1: empty
	 * 2. insert 'data':
	 * 2.   head = data
	 * 3.   data.next = to itself
	 * 3. insert 'newData':
	 * 4.   head = newData 
	 * 5.   newData.next = head 
	 * */
	public void constructLinkedList(int Key, String Name, String Email) {
		Node data = new Node(Key, Name, Email);
		data.nextNode = this.head;	/* next node */
		this.head = data;
	}
	
	public void printLinkedList() {
		//System.out.println(head.nextNode.nextNode.name); // 2
		
		while(head != null) {
			System.out.println(head.id + ", " + head.name + ", " + head.email);
			head = head.nextNode;
		}
		
		
		/* Alternatively, recursive call */
		/*
		if (head == null)  {
			return;
		}
		System.out.println(head.id + ", " + head.name + ", " + head.email);	
		head = head.nextNode;
		printLinkedList();
		
		**/
	}
	
	public void isEmpty() {
		
	}
	
	public void insertLast() {
		
	}
	
	public void removeFirst() {
		
	}
	
	public void removeNode() {
		
	}

	public void findNode() {
		
	}
}

public class SinglyLinkedList {

	public static void main(String[] args) {
		
		NodeList HappyFamily = new NodeList();
		
		HappyFamily.constructLinkedList(1, "Afrita", "afrita@plipustel.com");
		HappyFamily.constructLinkedList(2, "Plipus", "plipus@plipustel.com");
		HappyFamily.constructLinkedList(3, "Adam", "adam@plipustel.com");
		
		
		// System.out.println(HappyFamily.head.id); is also valid
		HappyFamily.printLinkedList();
	}

}
