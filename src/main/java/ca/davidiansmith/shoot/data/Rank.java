package ca.davidiansmith.shoot.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Rank {
	NINE(9, '9', "Nine", ContextualRank.NINE),
	TEN(10, '0', "Ten", ContextualRank.TEN),
	JACK(11, 'J', "Jack", ContextualRank.JACK),
	QUEEN(12, 'Q', "Queen", ContextualRank.QUEEN),
	KING(13, 'K', "King", ContextualRank.KING),
	ACE(14, 'A', "Ace", ContextualRank.ACE);
	
	private static Map<String, Rank> nameMap;
	private static Map<Integer, Rank> rankingMap;
	private static Map<Character, Rank> codeMap;
	private static Rank[] allRanks;

	static {
		nameMap = new HashMap<String, Rank>();
		rankingMap = new HashMap<Integer, Rank>();
		codeMap = new HashMap<Character, Rank>();
		
		for (Rank r : EnumSet.allOf(Rank.class)) {
			nameMap.put(r.name, r);
			rankingMap.put(r.ranking, r);
			codeMap.put(r.code, r);
		}
		
		allRanks = rankingMap.values().toArray(new Rank[rankingMap.values().size()]);
	}
	
	public static Rank getRankByName(String name) {
		return nameMap.get(name);
	}
	
	public static Rank getRankByRanking(int ranking) {
		return rankingMap.get(ranking);
	}
	
	public static Rank getRankByCode(char code) {
		return codeMap.get(code);
	}
	
	public static Rank[] getAllRanks() {
		return allRanks;
	}
	
	public static int getRankCount() {
		return allRanks.length;
	}
	
	@Getter private int ranking;
	@Getter private char code;
	@Getter private String name;
	@Getter private ContextualRank contextualRank;

}
