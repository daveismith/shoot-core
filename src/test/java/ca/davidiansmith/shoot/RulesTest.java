package ca.davidiansmith.shoot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ca.davidiansmith.shoot.data.Card;
import ca.davidiansmith.shoot.data.Trump;
import nl.jqno.equalsverifier.EqualsVerifier;

class RulesTest {

	@Test
	void testIsCardLegal() {
		
		List<Card> hand = new ArrayList<>();
		hand.add(Card.getCardFromCode("9S"));
		hand.add(Card.getCardFromCode("9H"));
		hand.add(Card.getCardFromCode("9C"));
		hand.add(Card.getCardFromCode("9D"));
		hand.add(Card.getCardFromCode("0S"));
		hand.add(Card.getCardFromCode("0H"));
		hand.add(Card.getCardFromCode("0C"));
		hand.add(Card.getCardFromCode("0D"));
		
		
		// Check That You Can't Play A Card Not In Your Hand For Any Trump When A Trump Lead
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), Card.getCardFromCode("AS"), Trump.SPADES));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), Card.getCardFromCode("AH"), Trump.HEARTS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), Card.getCardFromCode("AC"), Trump.CLUBS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), Card.getCardFromCode("AD"), Trump.DIAMONDS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), Card.getCardFromCode("AH"), Trump.LOW));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), Card.getCardFromCode("9H"), Trump.HIGH));
		
		// Check That You Can't Play A Card Not In Your Hand For Any Trump When No Card Lead
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), null, Trump.SPADES));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), null, Trump.HEARTS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), null, Trump.CLUBS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), null, Trump.DIAMONDS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), null, Trump.LOW));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("AH"), null, Trump.HIGH));
		
		// Check that if you've got the card and nothing has been played you can play it
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), null, Trump.SPADES));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), null, Trump.HEARTS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), null, Trump.CLUBS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9D"), null, Trump.DIAMONDS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), null, Trump.LOW));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), null, Trump.HIGH));
		
		// Check that if you've got a card of the lead suit you can play it
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AS"), Trump.SPADES));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), Card.getCardFromCode("AH"), Trump.HEARTS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), Card.getCardFromCode("AC"), Trump.CLUBS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9D"), Card.getCardFromCode("AD"), Trump.DIAMONDS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), Card.getCardFromCode("AH"), Trump.LOW));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), Card.getCardFromCode("9H"), Trump.HIGH));
		
		// Check that if you've got a card of the lead suit and you try to play something else you can't (When Lead Not Trump)
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), Card.getCardFromCode("AH"), Trump.SPADES));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9D"), Card.getCardFromCode("AC"), Trump.HEARTS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AD"), Trump.CLUBS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), Card.getCardFromCode("AS"), Trump.DIAMONDS));
	
		// Check that if you've got a card of the lead suit and you try to play something else you can't (When Lead Trump)
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), Card.getCardFromCode("AS"), Trump.SPADES));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9D"), Card.getCardFromCode("AH"), Trump.HEARTS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AC"), Trump.CLUBS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), Card.getCardFromCode("AD"), Trump.DIAMONDS));
		
		// Check that if you've got a card of the lead suit and you try to play trump else you can't (When Lead Not Trump)
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AH"), Trump.SPADES));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9H"), Card.getCardFromCode("AC"), Trump.HEARTS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9C"), Card.getCardFromCode("AD"), Trump.CLUBS));
		assertFalse(Rules.isCardLegal(hand, Card.getCardFromCode("9D"), Card.getCardFromCode("AS"), Trump.DIAMONDS));
		
		hand = new ArrayList<>();
		hand.add(Card.getCardFromCode("9S"));
		hand.add(Card.getCardFromCode("9S"));
		hand.add(Card.getCardFromCode("0S"));
		hand.add(Card.getCardFromCode("0S"));
		hand.add(Card.getCardFromCode("QS"));
		hand.add(Card.getCardFromCode("QS"));
		hand.add(Card.getCardFromCode("JS"));
		hand.add(Card.getCardFromCode("JC"));
		
		// Check that if you don't have a card of the lead suit and you can play whatever
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AH"), Trump.SPADES));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AH"), Trump.HEARTS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AH"), Trump.CLUBS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("9S"), Card.getCardFromCode("AH"), Trump.DIAMONDS));
		
		// Check The Weird Quirks of Jacks
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("JC"), Card.getCardFromCode("9S"), Trump.SPADES));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("JS"), Card.getCardFromCode("9C"), Trump.CLUBS));
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("JC"), Card.getCardFromCode("9C"), Trump.CLUBS));
		
		assertTrue(Rules.isCardLegal(hand, Card.getCardFromCode("JS"), Card.getCardFromCode("9C"), Trump.CLUBS));
	}
	
	@Test
	public void testGetLegalCards() {
		List<Card> hand = new ArrayList<>();
		hand.add(Card.getCardFromCode("9S"));
		hand.add(Card.getCardFromCode("9H"));
		hand.add(Card.getCardFromCode("9C"));
		hand.add(Card.getCardFromCode("9D"));
		hand.add(Card.getCardFromCode("0S"));
		hand.add(Card.getCardFromCode("0H"));
		hand.add(Card.getCardFromCode("0C"));
		hand.add(Card.getCardFromCode("0D"));
		
		List<Card> filtered = Rules.getLegalCards(hand, Card.getCardFromCode("AS"), Trump.SPADES);
		List<Card> expected = new ArrayList<>();
		expected.add(Card.getCardFromCode("9S"));
		expected.add(Card.getCardFromCode("0S"));
		assertEquals(expected, filtered);
		
		filtered = Rules.getLegalCards(hand, Card.getCardFromCode("AS"), Trump.HEARTS);
		assertEquals(expected, filtered);
		
		
		hand = new ArrayList<>();
		hand.add(Card.getCardFromCode("9S"));
		hand.add(Card.getCardFromCode("9S"));
		hand.add(Card.getCardFromCode("0S"));
		hand.add(Card.getCardFromCode("0S"));
		hand.add(Card.getCardFromCode("QS"));
		hand.add(Card.getCardFromCode("QS"));
		hand.add(Card.getCardFromCode("JS"));
		hand.add(Card.getCardFromCode("JC"));
		
		filtered = Rules.getLegalCards(hand, Card.getCardFromCode("AS"), Trump.SPADES);
		assertEquals(hand, filtered);
		
		expected = new ArrayList<>();
		expected.add(Card.getCardFromCode("JS"));
		expected.add(Card.getCardFromCode("JC"));
		filtered = Rules.getLegalCards(hand, Card.getCardFromCode("AC"), Trump.CLUBS);
		assertEquals(expected, filtered);
	}
	
	@Test
	public void testIsCardBetter() {
		Card cA = Card.getCardFromCode("AC");
		Card cB = Card.getCardFromCode("AC");
		
		// Check when card is the same, they are not better
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.CLUBS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.DIAMONDS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HEARTS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.SPADES));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.LOW));
		
		//TODO: Check If This SHould Be The Case?
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.CLUBS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.DIAMONDS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HEARTS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.SPADES));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.LOW));
		
		// Check how things work with when cards are same suit,
		// depending on trump
		cB = Card.getCardFromCode("9C");
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.CLUBS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.DIAMONDS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HEARTS));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.SPADES));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HIGH));
		assertTrue(Rules.isCardBetter(cA, cB, cA, Trump.LOW));
		
		// Check flipping the cards around reverses the 
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.CLUBS));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.DIAMONDS));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.HEARTS));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.SPADES));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cB, cA, cA, Trump.LOW));
		
		// Check Non-equal suits (Trump will always win)
		cB = Card.getCardFromCode("AD");
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.CLUBS));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.CLUBS));
		assertFalse(Rules.isCardBetter(cA, cB, cB, Trump.CLUBS));
		assertTrue(Rules.isCardBetter(cB, cA, cB, Trump.CLUBS));
		
		// Check that non-equal suits which aren't trump, if 
		// the card being compared against is of the same 
		// suit as lead, the second will not win.
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.SPADES));
		assertFalse(Rules.isCardBetter(cB, cA, cB, Trump.SPADES));
		
		// Check that non-equal suits which aren't trump, if
		// the card that is being compared to the base is
		// of the same suit as lead, then it follows the 
		// so it wins
		assertTrue(Rules.isCardBetter(cA, cB, cB, Trump.SPADES));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.SPADES));
		
		// Check that if there's no lead, we can't figure out which card is better
		assertFalse(Rules.isCardBetter(cA, cB, null, Trump.SPADES));
		assertFalse(Rules.isCardBetter(cB, cA, null, Trump.SPADES));
		
		// Check that if we're playing high or low as trump, 
		// that whichever card follows suit wins
		
		// First Card Follows Suit
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cB, cA, cB, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cA, cB, cA, Trump.LOW));
		assertFalse(Rules.isCardBetter(cB, cA, cB, Trump.LOW));
		
		// Second Card Follows Suit
		assertTrue(Rules.isCardBetter(cA, cB, cB, Trump.HIGH));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.HIGH));
		assertTrue(Rules.isCardBetter(cA, cB, cB, Trump.LOW));
		assertTrue(Rules.isCardBetter(cB, cA, cA, Trump.LOW));
		
		// No Suit
		assertFalse(Rules.isCardBetter(cA, cB, null, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cB, cA, null, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cA, cB, null, Trump.LOW));
		assertFalse(Rules.isCardBetter(cB, cA, null, Trump.LOW));
		
		// Other Suit Lead
		Card cOther = Card.getCardFromCode("9H");
		assertFalse(Rules.isCardBetter(cA, cB, cOther, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cB, cA, cOther, Trump.HIGH));
		assertFalse(Rules.isCardBetter(cA, cB, cOther, Trump.LOW));
		assertFalse(Rules.isCardBetter(cB, cA, cOther, Trump.LOW));
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(Card.class).verify();
	}

}
