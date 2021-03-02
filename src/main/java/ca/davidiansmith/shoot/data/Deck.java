package ca.davidiansmith.shoot.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;

public final class Deck extends ArrayList<Card> implements List<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3960626170933419454L;
	
	@Getter private int cardsInDeck;

	public Deck(int numDuplicateCards) {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				for (int i = 0; i < numDuplicateCards; i++) {
					this.add(new Card(rank, suit));
				}
			}
		}
		this.cardsInDeck = this.size();
		shuffle();
	}
	
	private void shuffle() {
		// Handle Random
		Random random = new Random();
		for (int i = 0; i < this.size(); i++) {
			int j = random.nextInt(this.size() - i) + i;
			Card tmp = this.get(i);
			this.set(i, this.get(j));
			this.set(j, tmp);
		}
	}
	
	/**
	 * Takes the top card off the deck and returns it.
	 * 
	 * @return a single random card from the top of the deck.
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	public Card getTopCard() {
		return this.remove(0);
	}
}
