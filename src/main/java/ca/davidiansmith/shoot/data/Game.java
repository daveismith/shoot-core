package ca.davidiansmith.shoot.data;

import java.util.List;
import java.util.Random;

public class Game {

	private GameSettings settings;
	
	private int id;	// This Should be a UUID for distributed
	private String name;
	private int numPlayers = 0;
	private boolean inProgress = false;
	
	// Card Counter?
	// clients
	// client[] position around the table
	// disconnected players
	// team scores
	private int[] score = new int[] { 0, 0 };
	
	private int dealer;
	// current player
	private int nextShootNum;
	// list of bids
	// highest bid
	private Trump currentTrump;
	private int requiredTricks;
	// calling team
	private int[] tricksTaken;
	
	private List<Card> playedCards;
	private Card highCard;
	private Card leadCard;
	
	public Game(String name) {
		this.name = name;
		
		Random r = new Random();
		//this.dealer = r.nextInt();
		
		
	}
	
}
