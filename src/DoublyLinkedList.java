/**
 * 
 */

class NodePerson {
	public int id;
	public String name;
	public String email;

	NodePerson nextNode;
	NodePerson prevNode;
	
	public NodePerson(int Key, String name, String email) {
		this.id = Key;
		this.name = name;
		this.email = email;
		this.nextNode = this.prevNode = null;
	}
}


class DoublyLilink {
	
	NodePerson head;
	NodePerson tail;
	
	public DoublyLilink() {
		this.head = this.tail = null;
	}
	
	public boolean isEmpty() {
		return (this.head == null);
	}
	
	
	public void ConstructDoblyLilink(int Key, String name, String email) {
		
		NodePerson newNode = new NodePerson(Key, name, email);
		
		if(isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
			newNode.nextNode = null;
			newNode.prevNode = null;
		} else {
			newNode.nextNode = head;
			head.prevNode = newNode;
			head = newNode;
		}
	}
	
	public void printDoublyLilink() {
		NodePerson current = this.head;
		
		while(current != null ) {
			System.out.println(current.id + "\n" + current.name);
			current = current.nextNode;
		}
	}
	

}

public class DoublyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLilink HappyFamily = new DoublyLilink();

		HappyFamily.ConstructDoblyLilink(1, "Afrita", "afrita@plipustel.com"); /* tail */
		HappyFamily.ConstructDoblyLilink(2, "Plipus", "plipus@plipustel.com"); /* node */
		HappyFamily.ConstructDoblyLilink(3, "Adam", "adam@plipustel.com"); /* head */
		
		HappyFamily.printDoublyLilink();
		
	}

}
