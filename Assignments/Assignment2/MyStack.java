
import java.util.ArrayList;

/**
 * 
 * @author Camron Franklin CMSC 204 CRN 36096
 *
 * @param <T> generic parameter type
 */
public class MyStack<T> implements StackInterface<T> {
	T[] sack;
	int numberOfEntries;
	@SuppressWarnings("unchecked")
	
	/**
	 * default constructor
	 */
	public MyStack() {
		this(10);
	}
	
	/**
	 * Parameterized constructor - initializes array and sets index to zero
	 * @param size size of array
	 */
	public MyStack(int size) {
		sack = (T[]) new Object[size];
		numberOfEntries = 0;
	}
	
	/**
	 * Determines if stack is empty
	 * @return true if stack is empty, false if otherwise
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Determines if stack is full
	 * @return true if stack is full, false otherwise
	 */
	@Override
	public boolean isFull() {
		return numberOfEntries == sack.length;
	}

	/**Returns element on top of the stack, removes it from stack
	 * @return returns element on top of the stack
	 * @throws StackUnderflowException - thrown if called when stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		numberOfEntries--;
		T result = sack[numberOfEntries];
		sack[numberOfEntries] = null;
		return result;
	}

	/**Returns element on top of the stack without removing it
	 * @return element on top of the stack
	 * @throws StackUnderflowException - thrown if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		T result = sack[numberOfEntries - 1];
		return result;
	}

	/**
	 * Returns the number of elements in the array
	 * @return int form of number of elements in the array
	 */
	@Override
	public int size() {
		return numberOfEntries;
	}

	
	/**
	 * Adds provided element to the top of the stack
	 * @param element to be added to the top of the stack
	 * @return returns true if addition was successful
	 * @throws StackOverflow - thrown if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		else {
			sack[numberOfEntries] = e;
			numberOfEntries++;
		}
		return true;
	}
	
	/**
	 * Returns string representation of the stack with delimiter inserted between elements
	 * @param delimiter to be inserted
	 * @return String representation of the stack
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (int i = 0; i < numberOfEntries; i++)
			result += sack[i] + delimiter;
		result = result.substring(0, result.length() - 1);
		return result;
	}

	/**
	 * Returns string representation of the stack
	 * @return String representation of the stack
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < numberOfEntries; i++)
			result += sack[i];
		return result;
	}
	
	/**
	 * Fills stack array with elements from arraylist
	 * @param ArrayList to be copied
	 * @throws StackOverflowException - thrown if arraylist is larger than stack
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		if (list.size() > sack.length)
			throw new StackOverflowException();
		ArrayList<T> temp = new ArrayList<T>(list.size());
		for (Object item: list) {
			temp.add((T) item);
		}			
		for (T item: temp) {
			sack[numberOfEntries] = item;
			numberOfEntries++;
		}	
	}
}
