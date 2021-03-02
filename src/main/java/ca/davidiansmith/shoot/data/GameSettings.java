package ca.davidiansmith.shoot.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameSettings {

	@Getter private int playersPerTeam;
	@Getter private int duplicateCardCount;
	@Getter private int winningScore;
	
	/**
	 * @return the number of cards in the deck
	 */
	public int getDeckSize() {
		return Suit.getSuitCount() * Rank.getRankCount() * this.duplicateCardCount;
	}
	
	/**
	 * The settings for a standard four player game.
	 * (4 players, 1 euchre deck, 51 point game
	 */
	public static GameSettings FOUR_PLAYERS = new GameSettings(2, 1, 51);
	
	/**
	 * The settings for a standard six player game.
	 * (6 players, 2 euchre deck, 51 point game)
	 */
	public static GameSettings SIX_PLAYERS = new GameSettings(3, 2, 51);
	
	/**
	 * The settings for an eight player game.
	 * (8 players, 3 euchre deck, 51 point game)
	 */
	public static GameSettings EIGHT_PLAYERS = new GameSettings(4, 3, 51);
	
}
