import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	private static final int scoresSize = 5;
	Gradebook[] first;
	Gradebook[] second;
	

	@BeforeEach
	void setUp() throws Exception {
		
		first = new Gradebook[5];
		second = new Gradebook[5];
		
		first[0].addScore(78.0);
		first[1].addScore(79.0);
		
		second[0].addScore(99.5);
		second[1].addScore(92.5);
		second[2].addScore(95.7);
		second[3].addScore(85.6);
		second[4].addScore(76.9);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		first = null;
		second = null;
		
	}

	@Test
	void testGetScoreSize() {
		
		assertEquals(scoresSize, 5);
		
	}

	@Test
	void testAddScore() {
		assertTrue(first.toString().equals(" 78.0 79.0 "));
		assertTrue(second.toString().equals(" 99.5 92.5 95.7 85.6 76.9 "));
	}

	@Test
	void testSum() {
		assertEquals(157.0 , first[5].sum());
		assertEquals(450.2 , second[5].sum());
		
	}

	@Test
	void testMinimum() {
		assertEquals(78.0, first[5].minimum());
		assertEquals(76.9 , second[5].minimum());
	}

	@Test
	void testFinalScore() {
		
		assertEquals(373.3 , second[5].finalScore());
		assertEquals(79.0 , first[5].finalScore());
		
	}

	@Test
	void testToString() {
		assertTrue(first.toString().equals(" 78.0 79.0 "));
		assertTrue(second.toString().equals(" 99.5 92.5 95.7 85.6 76.9 "));
	}

}
