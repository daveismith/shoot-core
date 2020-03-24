package ca.davidiansmith.shoot.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TrumpTest {

	@Test
	public void testGetTrumpByName() {
		Trump t = Trump.getTrumpByName("Spades");
		assertEquals(Trump.SPADES, t);
		t = Trump.getTrumpByName("Hearts");
		assertEquals(Trump.HEARTS, t);
		t = Trump.getTrumpByName("Clubs");
		assertEquals(Trump.CLUBS, t);
		t = Trump.getTrumpByName("Diamonds");
		assertEquals(Trump.DIAMONDS, t);
		t = Trump.getTrumpByName("High");
		assertEquals(Trump.HIGH, t);
		t = Trump.getTrumpByName("Low");
		assertEquals(Trump.LOW, t);
	}

	@Test
	public void testGetAllTrumps() {
		Trump[] trumps = Trump.getAllTrumps();
		assertEquals(6, trumps.length);
		boolean hasSpades = false, hasHearts = false, hasClubs = false,
				hasDiamonds = false, hasHigh = false, hasLow = false, hasOther = false;
		for (Trump t : trumps) {
			switch (t) {
			case SPADES:
				hasSpades = true;
				break;
			case HEARTS:
				hasHearts = true;
				break;
			case CLUBS:
				hasClubs = true;
				break;
			case DIAMONDS:
				hasDiamonds = true;
				break;
			case HIGH:
				hasHigh = true;
				break;
			case LOW:
				hasLow = true;
				break;
			default:
				hasOther = true;
				break;
			}
		}
		assertTrue(hasSpades);
		assertTrue(hasHearts);
		assertTrue(hasClubs);
		assertTrue(hasDiamonds);
		assertTrue(hasHigh);
		assertTrue(hasLow);
		assertFalse(hasOther);
	}

	@Test
	public void testGetTrumpCount() {
		assertEquals(6, Trump.getTrumpCount());
	}

	@Test
	public void testSpades() {
		assertEquals("Spades", Trump.SPADES.getName());
		assertEquals(Suit.SPADES, Trump.SPADES.getSuit());
		assertTrue(Trump.SPADES.isSuit());
	}
	
	@Test
	public void testHearts() {
		assertEquals("Hearts", Trump.HEARTS.getName());
		assertEquals(Suit.HEARTS, Trump.HEARTS.getSuit());
		assertTrue(Trump.HEARTS.isSuit());
	}
	
	@Test
	public void testClubs() {
		assertEquals("Clubs", Trump.CLUBS.getName());
		assertEquals(Suit.CLUBS, Trump.CLUBS.getSuit());
		assertTrue(Trump.CLUBS.isSuit());
	}
	
	@Test
	public void testDiamonds() {
		assertEquals("Diamonds", Trump.DIAMONDS.getName());
		assertEquals(Suit.DIAMONDS, Trump.DIAMONDS.getSuit());
		assertTrue(Trump.DIAMONDS.isSuit());
	}
	
	@Test
	public void testHigh() {
		assertEquals("High", Trump.HIGH.getName());
		assertNull(Trump.HIGH.getSuit());
		assertFalse(Trump.HIGH.isSuit());
	}
	
	@Test
	public void testLow() {
		assertEquals("Low", Trump.LOW.getName());
		assertNull(Trump.LOW.getSuit());
		assertFalse(Trump.LOW.isSuit());
	}
	
}
