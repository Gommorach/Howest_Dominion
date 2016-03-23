package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;


public class Game {
	private HashMap<Card, Integer> numberOfCardsInGame;	
	private CardCollection trashpile;
	private int numberOfRounds;
	private Player[] players;
	
	public Game(int numberOfPlayers) {
		this(numberOfPlayers, defaultActionCards());
	}
	
	public Game(int numberOfPlayers, List<Card> choosenActionCards) {
		numberOfCardsInGame = new HashMap<Card, Integer>();
		switch (numberOfPlayers) {
			case 2:
				numberOfCardsInGame.put(new Card(4, "Estate", 2, "Victory"), 8);
				numberOfCardsInGame.put(new Card(5, "Duch", 5, "Victory"), 8);
				numberOfCardsInGame.put(new Card(6, "Province", 8, "Victory"), 8);
				numberOfCardsInGame.put(new Card(7, "Curse", 0, "Curse"), 10);
				break;
			case 3:
				numberOfCardsInGame.put(new Card(4, "Estate", 2, "Victory"), 12);
				numberOfCardsInGame.put(new Card(5, "Duch", 5, "Victory"), 12);
				numberOfCardsInGame.put(new Card(6, "Province", 8, "Victory"), 12);
				numberOfCardsInGame.put(new Card(7, "Curse", 0, "Curse"), 20);
				break;
			case 4:
				numberOfCardsInGame.put(new Card(4, "Estate", 2, "Victory"), 12);
				numberOfCardsInGame.put(new Card(5, "Duch", 5, "Victory"), 12);
				numberOfCardsInGame.put(new Card(6, "Province", 8, "Victory"), 12);
				numberOfCardsInGame.put(new Card(7, "Curse", 0, "Curse"), 30);
				break;			
		}
		numberOfCardsInGame.put(new Card(1, "Copper", 0, "Treasure"), 60 - 7 * numberOfPlayers);
		numberOfCardsInGame.put(new Card(2, "Silver", 3, "Treasure"), 40);
		numberOfCardsInGame.put(new Card(3, "Gold", 6, "Treasure"), 30);
		// add action Cards
		
		System.out.println("Game initialised: ");
		for (Map.Entry<Card, Integer> entry: numberOfCardsInGame.entrySet()) {
			System.out.println("name: " + entry.getKey().getName() + " number of cards left: " + entry.getValue());
		}		
		
		List<Card> trash = new ArrayList<Card>();
		trashpile = new CardCollection(trash, true);
		
		numberOfRounds = 0;
		players = new Player[numberOfPlayers];	
		
	}
	
	public void addPlayer(Player player) {
		int i = 0;
		while (players[i] == null){
			i++;
		}
		players[i] = player;
	}
	
	public int getNumberOfPlayers() {
		return players.length;
	}
	
	private static List<Card> defaultActionCards() {		
		ConnectToDatabase ctd = new ConnectToDatabase();
		List<Card> cards = ctd.getDatabaseContent("select * from cards");
		return cards;
	}
	
}
