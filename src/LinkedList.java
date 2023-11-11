/**
 * @(#)linkedListApp.java
 *
 *
 * @Author Plipus Telaumbanua
 * @Created  May 20, 2012
 * @LastModified Nov 12, 2023
 * 
 * @Defenition : Linked List is a list that has sequences of node/link/record where one link
 *               connect to the next link using one direction pointer/reference. 
 *               The last link always refers to NULL as the mark where the iteration will be stopped.
 */
class Record {
	public int stdNo;
	public String stdName;
	
	/* In Java, when you declare a variable like public String next;, it explicitly states 
	 * that next is a reference to a String. You cannot later assign it a reference to an 
	 * object of a different type (like a Record). This is because Java is statically typed, 
	 * and the type of a variable is determined at compile-time.
	 * 
	 * When you declare a field like public Record next; in a class, you are saying that the 
	 * variable next is a reference to an instance of the Record class. In other words, next
	 * will hold an object of type Record.
	 * 
	 * */
	public Record next; /* Make a reference */
	
	public Record( int newStdNo, String newStdName ) {
		stdNo 	= newStdNo;
		stdName = newStdName;
	}
	
	public void displayRecord() {
		System.out.print("{" + stdNo + " , " + stdName + "}" );
	}
}


class linkList {
	
	public Record first;
	
	public linkList() {
		first = null; /* Initialize first to null (link list does not contain any link )*/
	}
	
	public boolean isEmpty() {
		return ( first == null );
	}
	
	public void insertFirst( int newNo, String newName ) {
		Record newRecord = new Record(newNo, newName);
		newRecord.next = first; /* First newRecord will refers to NULL, for mark to stop the iteration */
		first = newRecord;      /* Now first is newRecord */
	}
	
	public void deleteFirst() {
		first = first.next; /* Just make first to be the record after first */
	}
	
	/* Find a specific Link
	 * Find a 'record/link' based on a specific key. In this case we assume 'key' is the 'StdNo'
	 * Since we want 'find' method return an object that has a references or something like record/link
	 * that has a reference, so we declare it as a 'Link' datatype.
	 **/
	public Record find( int key ) {
		Record current = first;
		while( current.stdNo != key ) {
			if( current.next == null ) {
				return null; /* Has achieved the last link, which means found nothing */
			} else {
				current = current.next; /* Go to the next link */
			}
		}
		return current; /* Found it, return the memory address of the Record */
	}
	
	/* Delete a specific link */
	public Record delete( int key ) {
		Record current  = first;
		Record previous = first;	
		
		while( current.stdNo != key ) {
			if( current.next == null ) {
				return null; /* Achieved the last link means Not found */
			} else {
				/* Move one step */
				previous = current;    
				current  = current.next; /* current.next = null */
			}
		}
		
		/* IF in link list, only contains 1 node */
		if( current == first ) {
			first = first.next; /* Make first to null means delete it */
		} else {
			/* Terminate the node to be deleted, by keeping the previoius pointer to next node of current 
			 * In other words, we connect the reference next link of previous to the next of current link (null).
			 *
			 * If we write something like this current = current.next : means we didn't connect anything to
			 * the previous link with the consequence the list looks like "drop".
			 **/
			previous.next = current.next;
			
			/* So, don't use this  current = current.next */
		}
		return current; /* Return the delete link to get the information of it */
	}
	
	public void displayLink() {
		System.out.print("The student List : " );
		Record current = first;
		
		while( current != null ) /* current != null means the last link will not be displayed */ {
			current.displayRecord();
			current = current.next;
		}
		System.out.println();
	}
}

public class LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Linked List");
		linkList theList = new linkList();
		
		/* Insert record/link */
		theList.insertFirst(1, "Philips");
		theList.insertFirst(2, "David");
		theList.insertFirst(3, "Jhon");
		theList.insertFirst(4, "Will");
		theList.insertFirst(5, "Rebecca");
		theList.displayLink();
		
		/* Delete first link */
		theList.deleteFirst();
		theList.displayLink();
		
		/* Insert a new link */
		theList.insertFirst(5, "Mike");
		theList.displayLink();
		
		Record f = theList.find(4);
		if ( f != null ) {
			System.out.println( "Found " + f.stdName + " at key " + f.stdNo);
		} else {
			System.out.println( "Not found key 4" );
		}
		Record d = theList.delete(4);
		if( d != null ) {
			System.out.println( "Deleted link with " + d.stdNo );
		} else {
			System.out.println( "Can't delete link" );
		}
		theList.displayLink();
	}

}
