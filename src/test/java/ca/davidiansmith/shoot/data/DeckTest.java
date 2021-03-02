package ca.davidiansmith.shoot.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeck() {
		Deck d = new Deck(1);
		assertEquals(24, d.getCardsInDeck());
		assertEquals(24, d.size());
		
		d = new Deck(2);
		assertEquals(48, d.getCardsInDeck());
		assertEquals(48, d.size());
	}

	@Test
	void testGetTopCard() {
		Deck d1 = new Deck(2);
		Deck d2 = new Deck(2);
		
		int equal = 0;
		for (int i = 0; i < 48; i++) {
			Card c1 = d1.getTopCard();	//TODO: Validate That All Cards Are There, and Not In the Same Order
			Card c2 = d2.getTopCard();
			if (c1.equals(c2)) {
				equal++;
			}
		}
		
		assertTrue(equal < 5);
		
		try {
			d1.getTopCard();
			fail("Did not assert IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException iobe) {
			
		} catch (Exception e) {
			fail("Asserted " + e + " instead of IndexOutOfBoundsException");
		}
	}

	@Test
	void testGetCardsInDeck() {
		Deck d = new Deck(1);
		assertEquals(24, d.getCardsInDeck());
		assertEquals(24, d.size());
		d.getTopCard();
		assertEquals(24, d.getCardsInDeck());
		assertEquals(23, d.size());
	}

}
