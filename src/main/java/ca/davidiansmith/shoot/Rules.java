package ca.davidiansmith.shoot;

import java.util.List;
import java.util.stream.Collectors;

import ca.davidiansmith.shoot.data.Card;
import ca.davidiansmith.shoot.data.Suit;
import ca.davidiansmith.shoot.data.Trump;

public final class Rules {
	
	private Rules() {}
	
	public static boolean isCardLegal(List<Card> hand, Card card, Card leadCard, Trump trump) {
		
		final Suit leadSuit = (leadCard != null) ? leadCard.getContextualSuit(trump) : null;
		
		// check that the card is contained in the hand
		if (!hand.contains(card)) {
			// indicate that the card isn't contained in the hand
			return false;
		}
		
		// If no card has been lead yet, then and card (as long as it is in the hand) is legal
		if (leadSuit == null)
			return true;
		
		// if the suit lead is the same as the suit played, the card is always legal
		if (leadSuit == card.getContextualSuit(trump)) {
			return true;
		} else if (hand.stream().noneMatch(c -> c.getContextualSuit(trump).equals(leadSuit))){
			return true;
		} else {
			// indicate card is of the wrong suit
			return false;
		}
	}
	
	/**
	 * Returns a new List<Card> containing all legal cards in a hand for a given lead Card and Trump.
	 * 
	 * @param hand the hand to filter
	 * @param leadCard the card that was lead
	 * @param trump the current trump
	 * @return a list of cards filtered by lead and trump
	 */
	public static List<Card> getLegalCards(List<Card> hand, Card leadCard, Trump trump) {
		return hand.parallelStream().filter(c -> Rules.isCardLegal(hand, c, leadCard, trump)).collect(Collectors.toList());
	}
	
	public static boolean isCardBetter(Card c1, Card c2, Card leadCard, Trump trump) {
	
		final Suit leadSuit = (leadCard != null) ? leadCard.getContextualSuit(trump) : null;
		
		// Case 1: The two cards are in the same suit
		// if the two cards are in the same suit, simply compare their contextual
		// ranks (with a reverse decision if trump is low)
		if (c1.getContextualSuit(trump).equals(c2.getContextualSuit(trump))) {
			if (trump == Trump.LOW) {
				return c2.getContextualRank(trump).getRanking() < c1.getContextualRank(trump).getRanking();
			} else {
				return c2.getContextualRank(trump).getRanking() > c1.getContextualRank(trump).getRanking();
			}
		}
		
		// Case 2: Trump is a suit and the two cards played are different suits
		if (trump.isSuit()) {
			// if c1 is a trump, c1 must win (since they do not have the
			// suit)
			if (c1.getContextualSuit(trump).equals(trump.getSuit())) {
				return false;
				// if c2 is a trump, c2 must win (since they do not have the
				// same suit)
			} else if (c2.getContextualSuit(trump).equals(trump.getSuit())) {
				return true;
				// at this point, we know that the trump is a suit, both cards
				// are different suits, and neither is trump so if c1 is the
				// suit that was lead, it must beat c2
			} else if (c1.getContextualSuit(trump).equals(leadSuit)) {
				return false;
				// if c2 is of the suit lead, then it must beat c1
			} else if (c2.getContextualSuit(trump).equals(leadSuit)) {
				return true;
				// otherwise, neither cards follow suit, say c1 wins
			} else {
				return false;
			}
			// Case 3: Trump is not a suit, and the two cards played are
			// different suits
		} else {
			// whichever card followed suit must win (since they are different
			// suits, and trump is not a suit)
			// so if c1 is the suit that was lead, it must beat c2
			if (c1.getContextualSuit(trump).equals(leadSuit)) {
				return false;
				// if c2 is not of the suit lead, then it must beat c1
			} else if (c2.getContextualSuit(trump).equals(leadSuit)) {
				return true;
				// otherwise, neither cards follow suit, say c1 wins
			} else
			{
				return false;
			}
		}
		
	}
}
