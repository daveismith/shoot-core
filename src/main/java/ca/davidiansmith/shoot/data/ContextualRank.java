package ca.davidiansmith.shoot.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ContextualRank {
	NINE(9, "Nine"),
	TEN(10, "Ten"),
	JACK(11, "Jack"),
	QUEEN(12, "Queen"),
	KING(13, "King"),
	ACE(14, "Ace"),
	LEFT(15, "Left"),
	RIGHT(16, "Right");

	private static Map<String, ContextualRank> nameMap;
	private static Map<Integer, ContextualRank> rankingMap;
	private static ContextualRank[] allContextualRanks;

	static {
		nameMap = new HashMap<String, ContextualRank>();
		rankingMap = new HashMap<Integer, ContextualRank>();
		
		for (ContextualRank r : EnumSet.allOf(ContextualRank.class)) {
			nameMap.put(r.name, r);
			rankingMap.put(r.ranking, r);
		}
		
		allContextualRanks = rankingMap.values().toArray(new ContextualRank[rankingMap.values().size()]);
	}
	
	public static ContextualRank getContextualRankByName(String name) {
		return nameMap.get(name);
	}
	
	public static ContextualRank getContextualRankByRanking(int ranking) {
		return rankingMap.get(ranking);
	}
	
	public static ContextualRank[] getAllContextualRanks() {
		return allContextualRanks;
	}
	
	public static int getContextualRankCount() {
		return allContextualRanks.length;
	}

	@Getter private int ranking;
	@Getter private String name;
	
}
