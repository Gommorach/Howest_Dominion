package mainPackage;

public class Player {
	
	private int id;
	private String name;
	private int turn;
	private int handSize;
	private int actions;
	private int buys;
	private int coins;
	private int victorypoints;
	
	
	public Player(int id, String name, int turn, int handSize, int actions, int buys, int coins, int victorypoints){
		this.id = id;
		this.name = name;
		this.turn = turn;
		this.handSize = handSize;
		this.actions = actions;
		this.buys = buys;
		this.coins = coins;
		this.victorypoints = victorypoints;
	}
	
	public int getPlayerid(){
		return id;
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
		return victorypoints;
	}		
}


