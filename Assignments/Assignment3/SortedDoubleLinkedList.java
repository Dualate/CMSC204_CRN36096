import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36906
 *
 * @param <T> generic type paramter
 */

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	

	Comparator<T> compare;
	
	/**
	 * Constructor that calls super method and instantiates comparator object
	 * @param compareableObject
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		compare = compareableObject;
	}
	
	/**
	 * Calls superclass iterator method
	 * @return iterator
	 */
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * Adds data element in proper position
	 * @param data element to be added
	 */
	public void add (T data) {
		Node entry = new Node (data);
		if (size == 0) {
			head = entry;
			tail = entry;
		} else {
			boolean flag = false;
			Node current = head;
			while(!flag) {
				int p = compare.compare(data, (T) current.data);
				if (p > 0) {
					if (current.next == null) {
						tail = entry;
						entry.previous = current;
						current.next = entry;
						flag = true;
					}
				} else {
					if (current.previous == null) {
						head = entry;
					}
					else {
						entry.previous = current.previous;
						current.previous.next = entry;
					}
					entry.next = current;
					current.previous = entry;
					flag = true;
				}
				current = current.next;
			}
		}
		size++;
	}
	
	/**
	 * @throws UnsupportedOperationException
	 */
	@Override
	 public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
}
