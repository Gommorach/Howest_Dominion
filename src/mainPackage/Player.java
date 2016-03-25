package mainPackage;

public class Player {
	
	private String name;
	private int turn;
	private int handSize = 5;
	private CardCollection deckList;
	private CardCollection discardlist;
	private CardCollection hand;
	private int actions = 1;
	private int buys = 0;
	private int coins  = 0;
	private int victoryPoints = 3;
	
	
	public Player(String name, int turn, CardCollection deckList){
		this.name = name;
		this.turn = turn;
		this.deckList = deckList;
	}
	public Player(String name, int turn, int handSize, CardCollection deckList, CardCollection discardList, int actions, int buys, int coins, int victoryPoints)
	{
		this.name = name;
		this.turn = turn;
		this.handSize = handSize;
		this.deckList = deckList;
		this.discardlist = discardList;
		this.actions = actions;
		this.buys = buys;
		this.coins = coins;
		this.victoryPoints = victoryPoints;
	}
	public void drawCard(int amount)
	{
		System.out.println(handSize);
		for (int i = 0;i < amount;i++)
		{
			hand.addCard(deckList.getCard(i));
		}
		System.out.println("");
		handSize +=amount;
		System.out.println(handSize);
	}
	public CardCollection getDeckList()
	{
		return deckList;
	}
	public CardCollection fillHand()
	{
		hand = deckList.getHand(handSize);
		return hand;
	}
	public CardCollection getHand()
	{
		return hand;
	}
	public void discardCard(Card c)
	{
		discardlist.addCard(c);
	}
	public void buyCard(Card c)
	{
		discardlist.addCard(c);
	}
	public String getname(){
		return name;
	}
	
	public int getturn(){
		return turn;
	}
	
	public int gethandSize(){
		return handSize;
	}
	
	public int actions(){
		return actions;
	}
	
	public int buys(){
		return buys;
	}
	
	public int coins(){
		return coins;
	}
	
	public int victorypoints(){
		return victoryPoints;
	}		
}



