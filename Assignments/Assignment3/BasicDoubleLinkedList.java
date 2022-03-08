import java.util.Comparator;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> {
	/**
	 * 
	 * @author Camron Franklin CMSC204 CRN 36906
	 *
	 */
	
	
	class Node{
		
		Node previous;
		T data;
		Node next;
		
		/**
		 * Constructor with data to be initialized
		 * @param datapoint
		 */
		public Node(T datapoint) {
			data = datapoint;
		}
	}
	
	class DoubleLinkedListIterator<T> implements ListIterator<T> {
		private Node pointer;

		/**
		 * Default no-args constructor
		 */
		DoubleLinkedListIterator(){
			pointer = new Node(null);
			pointer.next = head;
		}
		
		
		/**Checks if iterator has next element
		 * @return true if list has next element, false otherwise
		 */
		@Override
		public boolean hasNext() {
			if (pointer.next == null)
				return false;
			return true;
		}

		
		/**
		 * Returns element currently being pointed to
		 * @return list element and increments iterator
		 * @throws NoSuchElementException - if iterator reaches end of the list
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (pointer.next == null)
				throw new NoSuchElementException();
			T result = (T) pointer.next.data;
			pointer.previous = pointer.next;
			pointer.next = pointer.next.next;
			return (T) result;
		}

		
		/**
		 * Checks if iterator has previous element
		 * @return true if last has previous element, false otherwise
		 */
		@Override
		public boolean hasPrevious() {
			if (pointer.previous == null)
				return false;
			return true;
		}

		
		/**
		 * Returns element behind the element being pointed to
		 * @return previous list element and decrements iterator
		 * @throws NoSuchElementException - if iterator reaches end of the list
		 */
		@Override
		public T previous() throws NoSuchElementException {
			if (pointer.previous == null)
				throw new NoSuchElementException();
			T result = (T) pointer.previous.data;
			pointer.next = pointer.previous;
			pointer.previous = pointer.previous.previous;
			return (T) result;
		}

		
		/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		
		/**
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException {

		}
	
	}
	
	public Node head;
	public int size;
	public Node tail;
	
	/**
	 * Default no-args constructor
	 */
	public BasicDoubleLinkedList() {
		head = null;
		size = 0;
		tail = null;
	}
	
	/**
	 * Returns number of elements in list
	 * @return size of list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds new element to end of the list
	 * @param data element to be added
	 */
	public void addToEnd(T data) {
		Node datapoint = new Node(data);
		if (size == 0) {
			head = datapoint;
			tail = datapoint;
			size++;
		} else {
			tail.next = datapoint;
			datapoint.previous = tail;
			tail = datapoint;
			size++;
		}
	}
	
	/**
	 * Adds new element to front of the list
	 * @param data element to be added
	 */
	public void addToFront(T data) {
		Node datapoint = new Node(data);
		if (size == 0) {
			head = datapoint;
			tail = datapoint;
			size++;
		} else {
			head.previous = datapoint;
			datapoint.next = head;
			head = datapoint;
			size++;
		}
	}
	
	/**
	 * Returns element at top of the list
	 * @return first element of the list
	 */
	public T getFirst() {
		if (size == 0)
			return null;
		else
			return head.data;
	}
	
	/**
	 * Return element at end of the list
	 * @return last element of the list
	 */
	public T getLast() {
		if (size == 0)
			return null;
		else
			return tail.data;
	}
	
	/**
	 * Return iterator for list
	 * @return iterator
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>();	
	}

	/**
	 * Deletes specified node from list, returns it
	 * @param target data element to be removed
	 * @param comparable comparator object
	 * @return node associated with target data
	 */
	public Node remove(T target, Comparator<T> comparable) {
		Node current = head;
		Node result = new Node(null);
		for (int i = 0; i < size; i++) {
			if (comparable.compare(target, current.data) == 0) {
				if(current.previous == null) {
					head = current.next;
					head.previous = null;
				} else if (current.next == null) {
					tail = current.previous;
					tail.next = null;
				} else {
					current.next.previous = current.previous;
					current.previous.next = current.next;
				}
				result = current;
				size--;
				return result;
			}
			current = current.next;
		}
		return result;
	}
	
	/**
	 * Returns and deletes first list element
	 * @return first list element
	 */
	public T retrieveFirstElement() {
		if (size == 0)
			return null;
		T result = head.data;
		head = head.next;
		head.previous = null;
		size--;
		return result;
	}
	
	/**
	 * Returns and deletes last list element
	 * @return last list element
	 */
	public T retrieveLastElement() {
		if (size == 0)
			return null;
		T result = tail.data;
		tail = tail.previous;
		tail.next = null;
		size--;
		return result;
	}
	
	/**
	 * Returns arraylist form of list
	 * @return arraylist containing list elements
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<T>(size);
		Node current = head;
		for (int i = 0; i < size; i++) {
			list.add(current.data);
			current = current.next;
		}
		return list;
	}

}
