package ca.davidiansmith.shoot.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Suit {
	SPADES("Spades", 1, 'S'),
	HEARTS("Hearts", 2, 'H'),
	CLUBS("Clubs", 3, 'C'),
	DIAMONDS("Diamonds", 4, 'D');
	
	private static Map<String, Suit> nameMap;
	private static Map<Integer, Suit> idMap;
	private static Map<Character, Suit> codeMap;
	private static Suit[] allSuits;
	
	static {
		nameMap = new HashMap<String, Suit>();
		idMap = new HashMap<Integer, Suit>();
		codeMap = new HashMap<Character, Suit>();
		
		for (Suit s : EnumSet.allOf(Suit.class)) {
			nameMap.put(s.name, s);
			idMap.put(s.id, s);
			codeMap.put(s.code, s);
		}
		
		allSuits = idMap.values().toArray(new Suit[idMap.values().size()]);
	}
	
	public static Suit getSuitByName(String name) {
		return nameMap.get(name);
	}
	
	public static Suit getSuitById(int id) {
		return idMap.get(id);
	}
	
	public static Suit getSuitByCode(char code) {
		return codeMap.get(code);
	}
	
	public static Suit[] getAllSuits() {
		return allSuits;
	}
	
	public static int getSuitCount() {
		return allSuits.length;
	}
	
	/* Enum Instances
	 */
	@Getter private String name;
	@Getter private int id;
	@Getter private char code;
	
	/**
	 * Returns the other suit of the same colour. eg, SPADES.getSameColourSuit() == CLUBS
	 * 
	 * @return the other suit of the same colour
	 */
	public Suit getSameColourSuit() {
		Suit retVal = null;
		switch (this) {
		case SPADES:
			retVal = CLUBS;
			break;
		case CLUBS:
			retVal = SPADES;
			break;
		case HEARTS:
			retVal = DIAMONDS;
			break;
		case DIAMONDS:
		default:
			retVal = HEARTS;
			break;
		}
		return retVal;
	}
	
	public boolean isBlack() {
		return (this.equals(CLUBS) || this.equals(SPADES));
	}
	
	public boolean isRed() {
		return (this.equals(DIAMONDS) || this.equals(HEARTS));
	}
}
