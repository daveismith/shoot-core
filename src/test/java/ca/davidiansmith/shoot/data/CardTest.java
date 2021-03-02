package ca.davidiansmith.shoot.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CardTest {
	
	@Test
	public void testGetCardFromCode() {
		//Test Too Long
		try {
			Card.getCardFromCode("9SA");
			fail("No exception thrown for an argument that was too long");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Test Too Short
		try {
			Card.getCardFromCode("9");
			fail("No exception thrown for an argument that was too short");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Test Invalid Suit
		try {
			Card.getCardFromCode("9A");
			fail("No exception thrown for an invalid suit");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Test Invalid Rank
		try {
			Card.getCardFromCode("LH");
			fail("No exception thrown for an invalid Rank");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		//Test One For Each Rank and Suit
		Card c = Card.getCardFromCode("9H");
		assertEquals(Rank.NINE, c.getRank());
		assertEquals(Suit.HEARTS, c.getSuit());
		
		c = Card.getCardFromCode("0D");
		assertEquals(Rank.TEN, c.getRank());
		assertEquals(Suit.DIAMONDS, c.getSuit());
		
		c = Card.getCardFromCode("JC");
		assertEquals(Rank.JACK, c.getRank());
		assertEquals(Suit.CLUBS, c.getSuit());
		
		c = Card.getCardFromCode("QS");
		assertEquals(Rank.QUEEN, c.getRank());
		assertEquals(Suit.SPADES, c.getSuit());
		
		c = Card.getCardFromCode("KD");
		assertEquals(Rank.KING, c.getRank());
		assertEquals(Suit.DIAMONDS, c.getSuit());
		
		c = Card.getCardFromCode("AC");
		assertEquals(Rank.ACE, c.getRank());
		assertEquals(Suit.CLUBS, c.getSuit());
	}
	
	@Test
	public void testGetContextualRank() {
		//Check That Nothing Changes For A Non-Jack Card
		char[] ranks = {'9', '0', 'Q', 'K', 'A'};
		char[] suits = {'S', 'H', 'C', 'D'};
		
		for (char r : ranks) {
			ContextualRank expectedRank = Rank.getRankByCode(r).getContextualRank();
			for (char s : suits) {
				Card c = Card.getCardFromCode("" + r + s);
				assertEquals(expectedRank, c.getContextualRank(Trump.SPADES));
				assertEquals(expectedRank, c.getContextualRank(Trump.HEARTS));
				assertEquals(expectedRank, c.getContextualRank(Trump.CLUBS));
				assertEquals(expectedRank, c.getContextualRank(Trump.DIAMONDS));
				assertEquals(expectedRank, c.getContextualRank(Trump.HIGH));
				assertEquals(expectedRank, c.getContextualRank(Trump.LOW));
			}
		}
		
		Card c = Card.getCardFromCode("JS");
		assertEquals(ContextualRank.RIGHT, c.getContextualRank(Trump.SPADES));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.HEARTS));
		assertEquals(ContextualRank.LEFT, c.getContextualRank(Trump.CLUBS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.DIAMONDS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.HIGH));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.LOW));
		
		c = Card.getCardFromCode("JH");
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.SPADES));
		assertEquals(ContextualRank.RIGHT, c.getContextualRank(Trump.HEARTS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.CLUBS));
		assertEquals(ContextualRank.LEFT, c.getContextualRank(Trump.DIAMONDS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.HIGH));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.LOW));
		
		c = Card.getCardFromCode("JC");
		assertEquals(ContextualRank.LEFT, c.getContextualRank(Trump.SPADES));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.HEARTS));
		assertEquals(ContextualRank.RIGHT, c.getContextualRank(Trump.CLUBS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.DIAMONDS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.HIGH));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.LOW));
		
		c = Card.getCardFromCode("JD");
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.SPADES));
		assertEquals(ContextualRank.LEFT, c.getContextualRank(Trump.HEARTS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.CLUBS));
		assertEquals(ContextualRank.RIGHT, c.getContextualRank(Trump.DIAMONDS));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.HIGH));
		assertEquals(ContextualRank.JACK, c.getContextualRank(Trump.LOW));
	}
	
	@Test
	public void testGetContextualSuit() {
		//Check That Nothing Changes For A Non-Jack Card
		char[] ranks = {'9', '0', 'Q', 'K', 'A'};
		char[] suits = {'S', 'H', 'C', 'D'};
		
		for (char s : suits) {
			Suit expectedSuit = Suit.getSuitByCode(s);
			for (char r : ranks) {
				Card c = Card.getCardFromCode("" + r + s);
				assertEquals(expectedSuit, c.getContextualSuit(Trump.SPADES));
				assertEquals(expectedSuit, c.getContextualSuit(Trump.HEARTS));
				assertEquals(expectedSuit, c.getContextualSuit(Trump.CLUBS));
				assertEquals(expectedSuit, c.getContextualSuit(Trump.DIAMONDS));
				assertEquals(expectedSuit, c.getContextualSuit(Trump.HIGH));
				assertEquals(expectedSuit, c.getContextualSuit(Trump.LOW));
			}
		}
		
		Card c = Card.getCardFromCode("JS");
		assertEquals(Suit.SPADES, c.getContextualSuit(Trump.SPADES));
		assertEquals(Suit.SPADES, c.getContextualSuit(Trump.HEARTS));
		assertEquals(Suit.CLUBS, c.getContextualSuit(Trump.CLUBS));
		assertEquals(Suit.SPADES, c.getContextualSuit(Trump.DIAMONDS));
		assertEquals(Suit.SPADES, c.getContextualSuit(Trump.HIGH));
		assertEquals(Suit.SPADES, c.getContextualSuit(Trump.LOW));
		
		c = Card.getCardFromCode("JH");
		assertEquals(Suit.HEARTS, c.getContextualSuit(Trump.SPADES));
		assertEquals(Suit.HEARTS, c.getContextualSuit(Trump.HEARTS));
		assertEquals(Suit.HEARTS, c.getContextualSuit(Trump.CLUBS));
		assertEquals(Suit.DIAMONDS, c.getContextualSuit(Trump.DIAMONDS));
		assertEquals(Suit.HEARTS, c.getContextualSuit(Trump.HIGH));
		assertEquals(Suit.HEARTS, c.getContextualSuit(Trump.LOW));
		
		c = Card.getCardFromCode("JC");
		assertEquals(Suit.SPADES, c.getContextualSuit(Trump.SPADES));
		assertEquals(Suit.CLUBS, c.getContextualSuit(Trump.HEARTS));
		assertEquals(Suit.CLUBS, c.getContextualSuit(Trump.CLUBS));
		assertEquals(Suit.CLUBS, c.getContextualSuit(Trump.DIAMONDS));
		assertEquals(Suit.CLUBS, c.getContextualSuit(Trump.HIGH));
		assertEquals(Suit.CLUBS, c.getContextualSuit(Trump.LOW));
		
		c = Card.getCardFromCode("JD");
		assertEquals(Suit.DIAMONDS, c.getContextualSuit(Trump.SPADES));
		assertEquals(Suit.HEARTS, c.getContextualSuit(Trump.HEARTS));
		assertEquals(Suit.DIAMONDS, c.getContextualSuit(Trump.CLUBS));
		assertEquals(Suit.DIAMONDS, c.getContextualSuit(Trump.DIAMONDS));
		assertEquals(Suit.DIAMONDS, c.getContextualSuit(Trump.HIGH));
		assertEquals(Suit.DIAMONDS, c.getContextualSuit(Trump.LOW));
	}

	@Test
	public void testEquals() {
		Card c1 = Card.getCardFromCode("AC");
		Card c2 = Card.getCardFromCode("AC");
		assertFalse(c1 == c2);
		assertEquals(c1, c2);
	}
	
	@Test
	public void testHashCode() {
		Card c1 = Card.getCardFromCode("AC");
		Card c2 = Card.getCardFromCode("AC");
		assertFalse(c1 == c2);
		assertEquals(c1.hashCode(), c2.hashCode());
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(Card.class).verify();
	}
	
	@Test
	public void testToString() {
		Card c = Card.getCardFromCode("AC");
		assertEquals("Card(rank=ACE, suit=CLUBS)", c.toString());

		c = Card.getCardFromCode("9D");
		assertEquals("Card(rank=NINE, suit=DIAMONDS)", c.toString());		
	}
}
