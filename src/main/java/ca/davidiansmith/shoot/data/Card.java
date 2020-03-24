package ca.davidiansmith.shoot.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public final class Card {
	
	@Getter
	private final Rank rank;
	@Getter
	private final Suit suit;
	
	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public static Card getCardFromCode(String code) throws IllegalArgumentException {
		if (2 != code.length())
			throw new IllegalArgumentException("code must be of length 2");
		
		Rank rank = Rank.getRankByCode(code.charAt(0));
		Suit suit = Suit.getSuitByCode(code.charAt(1));
		if (null == rank)
			throw new IllegalArgumentException("invalid rank");
		if (null == suit)
			throw new IllegalArgumentException("invalid suit");
		
		return new Card(rank, suit);
	}
	
	/* Instance Methods
	 */
	
	public ContextualRank getContextualRank(Trump t) {
		ContextualRank returnRank = rank.getContextualRank();
		
		if ((rank == Rank.JACK) && t.isSuit()) {
			Suit trumpSuit = t.getSuit();
			if (suit.equals(trumpSuit)) {
				returnRank = ContextualRank.RIGHT;
			} else if (suit.equals(trumpSuit.getSameColourSuit())) {
				returnRank = ContextualRank.LEFT;
			}
		}
		return returnRank;
	}
	
	/**
	 * Get a card's suit in the context of trump
	 * 
	 * @param t current trump
	 * @return the suit of the card accounting for trump
	 */
	public Suit getContextualSuit(Trump t) {
		Suit returnSuit = suit;
		
		//If trump is a suit and the card is a jack
		if ((rank == Rank.JACK) && t.isSuit()) {
			Suit trumpSuit = t.getSuit();
			if (suit.equals(trumpSuit) || suit.equals(trumpSuit.getSameColourSuit()))
					returnSuit = trumpSuit;
		}
		
		return returnSuit;
	}
	
}
