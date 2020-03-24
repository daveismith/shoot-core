package ca.davidiansmith.shoot.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SuitTest {

	@Test
	public void testGetAllSuits() {
		Suit[] suits = Suit.getAllSuits();
		assertEquals(4, suits.length);
		assertEquals(Suit.SPADES, suits[0]);
		assertEquals(Suit.HEARTS, suits[1]);
		assertEquals(Suit.CLUBS, suits[2]);
		assertEquals(Suit.DIAMONDS, suits[3]);
	}

	@Test
	public void testGetSuitByCode() {
		Suit s = Suit.getSuitByCode('S');
		assertEquals(Suit.SPADES, s);
		s = Suit.getSuitByCode('H');
		assertEquals(Suit.HEARTS, s);
		s = Suit.getSuitByCode('C');
		assertEquals(Suit.CLUBS, s);
		s = Suit.getSuitByCode('D');
		assertEquals(Suit.DIAMONDS, s);
	}
	
	@Test
	public void testGetSuitById() {
		Suit s = Suit.getSuitById(1);
		assertEquals(Suit.SPADES, s);
		s = Suit.getSuitById(2);
		assertEquals(Suit.HEARTS, s);
		s = Suit.getSuitById(3);
		assertEquals(Suit.CLUBS, s);
		s = Suit.getSuitById(4);
		assertEquals(Suit.DIAMONDS, s);
	}
	
	@Test
	public void testGetSuitByName() {
		Suit s = Suit.getSuitByName("Spades");
		assertEquals(Suit.SPADES, s);
		s = Suit.getSuitByName("Hearts");
		assertEquals(Suit.HEARTS, s);
		s = Suit.getSuitByName("Clubs");
		assertEquals(Suit.CLUBS, s);
		s = Suit.getSuitByName("Diamonds");
		assertEquals(Suit.DIAMONDS, s);
	}
	
	@Test
	public void testSpades() {
		assertEquals('S', Suit.SPADES.getCode());
		assertEquals(1, Suit.SPADES.getId());
		assertEquals("Spades", Suit.SPADES.getName());
		assertTrue(Suit.SPADES.isBlack());
		assertFalse(Suit.SPADES.isRed());
		assertEquals(Suit.CLUBS, Suit.SPADES.getSameColourSuit());
	}
	
	@Test
	public void testHearts() {
		assertEquals('H', Suit.HEARTS.getCode());
		assertEquals(2, Suit.HEARTS.getId());
		assertEquals("Hearts", Suit.HEARTS.getName());
		assertFalse(Suit.HEARTS.isBlack());
		assertTrue(Suit.HEARTS.isRed());
		assertEquals(Suit.DIAMONDS, Suit.HEARTS.getSameColourSuit());
	}
	
	@Test
	public void testClubs() {
		assertEquals('C', Suit.CLUBS.getCode());
		assertEquals(3, Suit.CLUBS.getId());
		assertEquals("Clubs", Suit.CLUBS.getName());
		assertTrue(Suit.CLUBS.isBlack());
		assertFalse(Suit.CLUBS.isRed());
		assertEquals(Suit.SPADES, Suit.CLUBS.getSameColourSuit());
	}
	
	@Test
	public void testDiamonds() {
		assertEquals('D', Suit.DIAMONDS.getCode());
		assertEquals(4, Suit.DIAMONDS.getId());
		assertEquals("Diamonds", Suit.DIAMONDS.getName());
		assertFalse(Suit.DIAMONDS.isBlack());
		assertTrue(Suit.DIAMONDS.isRed());
		assertEquals(Suit.HEARTS, Suit.DIAMONDS.getSameColourSuit());
	}

}
