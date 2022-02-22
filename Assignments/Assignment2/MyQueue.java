import java.util.ArrayList;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 * @param <T> generic parameter type
 */
public class MyQueue<T> implements QueueInterface<T> {
	
	T[] bag;
	int numberOfEntries;
	
	/**
	 * default constructor
	 */
	public MyQueue() {
		this(10);
	}
	
	/**
	 * Parameterized constructor
	 * @param size size to intialize queue array with
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int size) {
		bag = (T[]) new Object[size];
		numberOfEntries = 0;
	}
	
	/**
	 * Determines if queue is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Determines if queue is full
	 * @return true if queue is full, false otherwise
	 */
	@Override
	public boolean isFull() {
		return numberOfEntries == bag.length;
	}

	/**
	 * Removes element from the front of the queue
	 * @return first element in the queue
	 * @throws QueueUnderflowException - thrown if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T result;
		if (bag[0] == null)
			throw new QueueUnderflowException();
		result = bag[0];
		for (int i = 0; i < numberOfEntries; i++)
			bag[i] = bag[i+1];
		numberOfEntries--;
		return result;
	}

	/**
	 * Returns number of elements in queue
	 * @return number of element in queue
	 */
	@Override
	public int size() {
		return numberOfEntries;
	}

	/**
	 * Adds element to the back of the queue
	 * @param e element to be queued
	 * @return true if addition was successful
	 * @throws QueueOverflowException - thrown if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		else {
			bag[numberOfEntries] = e;
			numberOfEntries++;
		}
		return true;
	}
	
	/**
	 * Returns string representation of the queue
	 * @return string representation of the queue
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < numberOfEntries; i++)
			result += bag[i];
		return result;
	}
	
	/**
	 * Returns string representation of the queue with delimiter inserted
	 * @param delimiter character to be added between elements
	 * @return string representation of the queue with delimiter inserted
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (int i = 0; i < numberOfEntries; i++)
			result += bag[i] + delimiter;
		result = result.substring(0, result.length() - 1);
		return result;
	}

	/**
	 * Fills queue with elements from arraylist
	 * @param list elements to be added to the queue
	 * @throws QueueOverflowException if arraylist is bigger than queue size
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		if (list.size() > bag.length)
			throw new QueueOverflowException();
		ArrayList<T> temp = new ArrayList<T>(list.size());
		for (Object item: list)
			temp.add((T) item);
		for (T item: temp) {
			bag[numberOfEntries] = item;
			numberOfEntries++;
		}
		
	}

}
