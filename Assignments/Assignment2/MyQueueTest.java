
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	public Double one = 10.0, two = 20.0, three = 30.0, four = 40.0, five = 50.0;
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@Before
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(5);
		doubleQ.enqueue(one);
		doubleQ.enqueue(two);
		doubleQ.enqueue(three);
	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		try {
			assertEquals(one, doubleQ.dequeue());
			assertEquals(two, doubleQ.dequeue());
			assertEquals(three, doubleQ.dequeue());
			doubleQ.dequeue();
		} catch (QueueUnderflowException e) {
			assertTrue("This should have cause an QueueUnderflowException", true);
		}
	}

	@Test
	public void testSize() {
		assertEquals(3, stringQ.size());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		try {
			assertTrue(doubleQ.enqueue(four));
			assertTrue(doubleQ.enqueue(five));
			doubleQ.enqueue(150.0);
		} catch (QueueOverflowException e) {
			assertTrue("This should have cause an QueueOverflowException", true);
		}
		
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringQ.isFull());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() {
		assertEquals("abc", stringQ.toString());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("abcd", stringQ.toString());
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() {
		assertEquals("10.020.030.0", doubleQ.toString());
		assertEquals("10.0-20.0-30.0", doubleQ.toString("-"));
	}

	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringQ.toString("%"));
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("a&b&c&d", stringQ.toString("&"));
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		try {
			stringQ.fill(fill);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
