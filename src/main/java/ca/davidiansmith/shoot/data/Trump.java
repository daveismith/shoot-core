package ca.davidiansmith.shoot.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Trump {
	SPADES("Spades", Suit.SPADES),
	HEARTS("Hearts", Suit.HEARTS),
	CLUBS("Clubs", Suit.CLUBS),
	DIAMONDS("Diamonds", Suit.DIAMONDS),
	HIGH("High", null),
	LOW("Low", null);
	
	private static Map<String, Trump> nameMap;
	private static Trump[] allTrumps;
	
	static {
		nameMap = new HashMap<String, Trump>();
		
		for (Trump t : EnumSet.allOf(Trump.class))
			nameMap.put(t.name, t);
		
		allTrumps = nameMap.values().toArray(new Trump[nameMap.values().size()]);
	}
	
	public static Trump getTrumpByName(String name) {
		return nameMap.get(name);
	}
	
	public static Trump[] getAllTrumps() {
		return allTrumps;
	}
	
	public static int getTrumpCount() {
		return allTrumps.length;
	}
	
	@Getter private String name;
	@Getter private Suit suit;
		
	public boolean isSuit() {
		return (null != this.suit);
	}
}
