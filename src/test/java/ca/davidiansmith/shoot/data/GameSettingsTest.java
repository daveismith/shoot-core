package ca.davidiansmith.shoot.data;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.davidiansmith.shoot.data.GameSettings;

public class GameSettingsTest {

	@Test
	public void testGetDeckSize() {
		assertEquals(24, GameSettings.FOUR_PLAYERS.getDeckSize());
		assertEquals(48, GameSettings.SIX_PLAYERS.getDeckSize());
		assertEquals(72, GameSettings.EIGHT_PLAYERS.getDeckSize());
	}

	@Test
	public void testGetPlayersPerTeam() {
		assertEquals(2, GameSettings.FOUR_PLAYERS.getPlayersPerTeam());
		assertEquals(3, GameSettings.SIX_PLAYERS.getPlayersPerTeam());
		assertEquals(4, GameSettings.EIGHT_PLAYERS.getPlayersPerTeam());
	}

	@Test
	public void testGetDuplicateCardCount() {
		assertEquals(1, GameSettings.FOUR_PLAYERS.getDuplicateCardCount());
		assertEquals(2, GameSettings.SIX_PLAYERS.getDuplicateCardCount());
		assertEquals(3, GameSettings.EIGHT_PLAYERS.getDuplicateCardCount());
	}

	@Test
	public void testGetWinningScore() {
		assertEquals(51, GameSettings.FOUR_PLAYERS.getWinningScore());
		assertEquals(51, GameSettings.SIX_PLAYERS.getWinningScore());
		assertEquals(51, GameSettings.EIGHT_PLAYERS.getWinningScore());
	}

}
