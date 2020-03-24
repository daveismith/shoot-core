package ca.davidiansmith.shoot.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ContextualRankTest {
	
	@Test
	public void testGetContextualRankByName() {
		ContextualRank r = ContextualRank.getContextualRankByName("Nine");
		assertEquals(ContextualRank.NINE, r);
		r = ContextualRank.getContextualRankByName("Ten");
		assertEquals(ContextualRank.TEN, r);
		r = ContextualRank.getContextualRankByName("Jack");
		assertEquals(ContextualRank.JACK, r);
		r = ContextualRank.getContextualRankByName("Queen");
		assertEquals(ContextualRank.QUEEN, r);
		r = ContextualRank.getContextualRankByName("King");
		assertEquals(ContextualRank.KING, r);
		r = ContextualRank.getContextualRankByName("Ace");
		assertEquals(ContextualRank.ACE, r);
		r = ContextualRank.getContextualRankByName("Left");
		assertEquals(ContextualRank.LEFT, r);
		r = ContextualRank.getContextualRankByName("Right");
		assertEquals(ContextualRank.RIGHT, r);
	}

	@Test
	public void testGetContextualRankByRanking() {
		ContextualRank r = ContextualRank.getContextualRankByRanking(9);
		assertEquals(ContextualRank.NINE, r);
		r = ContextualRank.getContextualRankByRanking(10);
		assertEquals(ContextualRank.TEN, r);
		r = ContextualRank.getContextualRankByRanking(11);
		assertEquals(ContextualRank.JACK, r);
		r = ContextualRank.getContextualRankByRanking(12);
		assertEquals(ContextualRank.QUEEN, r);
		r = ContextualRank.getContextualRankByRanking(13);
		assertEquals(ContextualRank.KING, r);
		r = ContextualRank.getContextualRankByRanking(14);
		assertEquals(ContextualRank.ACE, r);
		r = ContextualRank.getContextualRankByRanking(15);
		assertEquals(ContextualRank.LEFT, r);
		r = ContextualRank.getContextualRankByRanking(16);
		assertEquals(ContextualRank.RIGHT, r);
		r = ContextualRank.getContextualRankByRanking(17);
	}

	@Test
	public void testGetAllContextualRanks() {
		ContextualRank[] ranks = ContextualRank.getAllContextualRanks();
		assertEquals(8, ranks.length);
		boolean hasNine = false, hasTen = false, hasJack = false, hasQueen = false,
				hasKing = false, hasAce = false, hasLeft = false, hasRight = false,
				hasOther = false;
		for(ContextualRank r : ranks) {
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
			case LEFT:
				hasLeft = true;
				break;
			case RIGHT:
				hasRight = true;
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
		assertTrue(hasLeft);
		assertTrue(hasRight);
		assertFalse(hasOther);
	}

	@Test
	public void testGetContextualRankCount() {
		assertEquals(8, ContextualRank.getContextualRankCount());
	}

	@Test
	public void testNine() {
		assertEquals(9, ContextualRank.NINE.getRanking());
		assertEquals("Nine", ContextualRank.NINE.getName());
	}
	
	@Test
	public void testTen() {
		assertEquals(10, ContextualRank.TEN.getRanking());
		assertEquals("Ten", ContextualRank.TEN.getName());
	}

	@Test
	public void testJack() {
		assertEquals(11, ContextualRank.JACK.getRanking());
		assertEquals("Jack", ContextualRank.JACK.getName());
	}
	
	@Test
	public void testQueen() {
		assertEquals(12, ContextualRank.QUEEN.getRanking());
		assertEquals("Queen", ContextualRank.QUEEN.getName());
	}
	
	@Test
	public void testKing() {
		assertEquals(13, ContextualRank.KING.getRanking());
		assertEquals("King", ContextualRank.KING.getName());
	}
	
	@Test
	public void testAce() {
		assertEquals(14, ContextualRank.ACE.getRanking());
		assertEquals("Ace", ContextualRank.ACE.getName());
	}
	
	@Test
	public void testLeft() {
		assertEquals(15, ContextualRank.LEFT.getRanking());
		assertEquals("Left", ContextualRank.LEFT.getName());
	}
	
	@Test
	public void testRight() {
		assertEquals(16, ContextualRank.RIGHT.getRanking());
		assertEquals("Right", ContextualRank.RIGHT.getName());
	}
}
