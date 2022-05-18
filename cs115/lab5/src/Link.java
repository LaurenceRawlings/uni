
/**
 * This class is a link of a linked list for your lab.  It may look familiar...
 * @author archam
 *
 */
public class Link<E> {
	private E e; //the element contained in this linked list
	private Link<E> next; //the next element of the linked list
	
	public Link (E e, Link<E> n) {
		this.e = e;
		this.next = n;
	}
	
	/**
	 * Method to set the element
	 */
	public void setElement (E e) {
		this.e = e;
	}
	
	/**
	 * Method to set the next linked list element
	 */
	public void setNext (Link<E> e) {
		this.next = e;
	}
	
	/**
	 * Method to get the element.
	 */
	public E getElement () {
		return this.e;
	}
	
	/**
	 * Method to get the next linked list element
	 */
	public Link<E> getNext () {
		return this.next;
	}    	
}
