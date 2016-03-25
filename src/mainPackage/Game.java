package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;


public class Game {
	private HashMap<Card, Integer> numberOfCardsInGame;	
	private CardCollection trashpile;
	private int numberOfRounds;
	private int numberOfPlayers;
	private Player[] players;
	
	public Game(int numberOfPlayers) 
	{
		this(numberOfPlayers, defaultActionCards());
		this.numberOfPlayers = numberOfPlayers;
	}
	public void trashCard(Card c)
	{
		trashpile.addCard(c);
	}
	public Game(int numberOfPlayers, List<Card> choosenActionCards) 
	{
		numberOfCardsInGame = new HashMap<Card, Integer>();
		switch (numberOfPlayers) 
		{
			case 2:
				numberOfCardsInGame.put(new Card("Estate", 2, "Victory"), 8);
				numberOfCardsInGame.put(new Card("Duch", 5, "Victory"), 8);
				numberOfCardsInGame.put(new Card("Province", 8, "Victory"), 8);
				numberOfCardsInGame.put(new Card("Curse", 0, "Curse"), 10);
				break;
			case 3:
				numberOfCardsInGame.put(new Card("Estate", 2, "Victory"), 12);
				numberOfCardsInGame.put(new Card("Duch", 5, "Victory"), 12);
				numberOfCardsInGame.put(new Card("Province", 8, "Victory"), 12);
				numberOfCardsInGame.put(new Card("Curse", 0, "Curse"), 20);
				break;
			case 4:
				numberOfCardsInGame.put(new Card("Estate", 2, "Victory"), 12);
				numberOfCardsInGame.put(new Card("Duch", 5, "Victory"), 12);
				numberOfCardsInGame.put(new Card("Province", 8, "Victory"), 12);
				numberOfCardsInGame.put(new Card("Curse", 0, "Curse"), 30);
				break;			
		}
		numberOfCardsInGame.put(new Card("Copper", 0, "Treasure"), 60 - 7 * numberOfPlayers);
		numberOfCardsInGame.put(new Card("Silver", 3, "Treasure"), 40);
		numberOfCardsInGame.put(new Card("Estate", 6, "Treasure"), 30);
		// add action Cards
		
		System.out.println("Game initialised: ");
		for (Map.Entry<Card, Integer> entry: numberOfCardsInGame.entrySet()) 
		{
			System.out.println("name: " + entry.getKey().getName() + "number of cards left: " + entry.getValue());
		}		
		
		List<Card> trash = new ArrayList<Card>();
		trashpile = new CardCollection(trash, true);
		
		numberOfRounds = 0;
		players = new Player[numberOfPlayers-1];	
		
	}

	/*public static void main(String[] args)
	{
		Game game1 = new Game(3);
		game1.setupAmountPlayers();
		for(int i = 0; i < game1.getNumberOfPlayers();i++)
		{
			System.out.println("Player: " + game1.players[i] + "Deck: " + game1.players[i].getDeckList().getAllCards());
		}
	}
	
	// can be written easier with array[#player - 1]
	
	public void addPlayer(Player player) 
	{
		int i = 0;
		while (players[i] == null)
		{
			i++;
		}
		players[i] = player;
	}*/
	
	public int getNumberOfPlayers()
	{
		return numberOfPlayers - 1;
	}
	
	public void addPlayer(Player player)
	{
		int i = 0;
		if(i < getNumberOfPlayers())
		{
			players[i] = player;
			i++;
		}
	}
	
	private static List<Card> defaultActionCards() 
	{		
		ConnectToDatabase ctd = new ConnectToDatabase();
		List<Card> cards = ctd.getDatabaseContent("select * from cards");
		return cards;
	}
	
	private void setupAmountPlayers()
	{
		for(int i = 0; i < getNumberOfPlayers(); i++)
		{
			addPlayer(new Player("player" + (i+1)));
			GiveDeck(players[i]);
		}
	}
	 
	private void GiveDeck(Player player)
	{
		for(int i = 0; i < getNumberOfPlayers(); i++)
		{
			player.setDeckList();
		}
	}
}
