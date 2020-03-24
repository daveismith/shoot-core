package ca.davidiansmith.shoot.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RankTest {
	
	@Test
	public void testGetRankByName() {
		Rank r = Rank.getRankByName("Nine");
		assertEquals(Rank.NINE, r);
		r = Rank.getRankByName("Ten");
		assertEquals(Rank.TEN, r);
		r = Rank.getRankByName("Jack");
		assertEquals(Rank.JACK, r);
		r = Rank.getRankByName("Queen");
		assertEquals(Rank.QUEEN, r);
		r = Rank.getRankByName("King");
		assertEquals(Rank.KING, r);
		r = Rank.getRankByName("Ace");
		assertEquals(Rank.ACE, r);
	}

	@Test
	public void testGetRankByRanking() {
		Rank r = Rank.getRankByRanking(9);
		assertEquals(Rank.NINE, r);
		r = Rank.getRankByRanking(10);
		assertEquals(Rank.TEN, r);
		r = Rank.getRankByRanking(11);
		assertEquals(Rank.JACK, r);
		r = Rank.getRankByRanking(12);
		assertEquals(Rank.QUEEN, r);
		r = Rank.getRankByRanking(13);
		assertEquals(Rank.KING, r);
		r = Rank.getRankByRanking(14);
		assertEquals(Rank.ACE, r);
	}
	
	@Test
	public void testGetRankByCode() {
		Rank r = Rank.getRankByCode('9');
		assertEquals(Rank.NINE, r);
		r = Rank.getRankByCode('0');
		assertEquals(Rank.TEN, r);
		r = Rank.getRankByCode('J');
		assertEquals(Rank.JACK, r);
		r = Rank.getRankByCode('Q');
		assertEquals(Rank.QUEEN, r);
		r = Rank.getRankByCode('K');
		assertEquals(Rank.KING, r);
		r = Rank.getRankByCode('A');
		assertEquals(Rank.ACE, r);
	}

	@Test
	public void testGetAllRanks() {
		Rank[] ranks = Rank.getAllRanks();
		assertEquals(6, ranks.length);
		boolean hasNine = false, hasTen = false, hasJack = false, hasQueen = false,
				hasKing = false, hasAce = false, hasOther = false;
		for(Rank r : ranks) {
			switch (r) {
			case NINE:
				hasNine = true;
				break;
			case TEN:
				hasTen = true;
				break;
			case JACK:
				hasJack = true;
				break;
			case QUEEN:
				hasQueen = true;
				break;
			case KING:
				hasKing = true;
				break;
			case ACE:
				hasAce = true;
				break;
			default:
				hasOther = true;
				break;
			}
		}
		assertTrue(hasNine);
		assertTrue(hasTen);
		assertTrue(hasJack);
		assertTrue(hasQueen);
		assertTrue(hasKing);
		assertTrue(hasAce);
		assertFalse(hasOther);
	}

	@Test
	public void testGetRankCount() {
		assertEquals(6, Rank.getRankCount());
	}

	@Test
	public void testNine() {
		assertEquals(9, Rank.NINE.getRanking());
		assertEquals('9', Rank.NINE.getCode());
		assertEquals("Nine", Rank.NINE.getName());
		assertEquals(ContextualRank.NINE, Rank.NINE.getContextualRank());
	}
	
	@Test
	public void testTen() {
		assertEquals(10, Rank.TEN.getRanking());
		assertEquals('0', Rank.TEN.getCode());
		assertEquals("Ten", Rank.TEN.getName());
		assertEquals(ContextualRank.TEN, Rank.TEN.getContextualRank());
	}

	@Test
	public void testJack() {
		assertEquals(11, Rank.JACK.getRanking());
		assertEquals('J', Rank.JACK.getCode());
		assertEquals("Jack", Rank.JACK.getName());
		assertEquals(ContextualRank.JACK, Rank.JACK.getContextualRank());
	}
	
	@Test
	public void testQueen() {
		assertEquals(12, Rank.QUEEN.getRanking());
		assertEquals('Q', Rank.QUEEN.getCode());
		assertEquals("Queen", Rank.QUEEN.getName());
		assertEquals(ContextualRank.QUEEN, Rank.QUEEN.getContextualRank());
	}
	
	@Test
	public void testKing() {
		assertEquals(13, Rank.KING.getRanking());
		assertEquals('K', Rank.KING.getCode());
		assertEquals("King", Rank.KING.getName());
		assertEquals(ContextualRank.KING, Rank.KING.getContextualRank());
	}
	
	@Test
	public void testAce() {
		assertEquals(14, Rank.ACE.getRanking());
		assertEquals('A', Rank.ACE.getCode());
		assertEquals("Ace", Rank.ACE.getName());
		assertEquals(ContextualRank.ACE, Rank.ACE.getContextualRank());
	}
}
