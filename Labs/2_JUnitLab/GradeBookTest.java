import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook g1;
	GradeBook g2;
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(3);
		g2 = new GradeBook(2);
		g1.addScore(24);
		g1.addScore(54);
		g1.addScore(16);
		g2.addScore(10);
		g2.addScore(61);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("24.0 54.0 16.0 "));
		assertEquals(g1.getScoreSize(), 3);
		assertTrue(g2.toString().equals("10.0 61.0 "));
		assertEquals(g2.getScoreSize(), 2);
	}

	@Test
	void testSum() {
		assertEquals(g1.sum(), 94);
		assertEquals(g2.sum(), 71);
	}

	@Test
	void testMinimum() {
		assertEquals(g1.minimum(), 16);
		assertEquals(g2.minimum(), 10);
	}

	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(), 78);
		assertEquals(g2.finalScore(), 61);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(g1.getScoreSize(), 3);
		assertEquals(g2.getScoreSize(), 2);
	}

	@Test
	void testToString() {
		assertTrue(g1.toString().equals("24.0 54.0 16.0 "));
		assertTrue(g2.toString().equals("10.0 61.0 "));
	}

}
