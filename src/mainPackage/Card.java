package mainPackage;

public class Card {
	private String name;
	private int cost;
	private String type;
	private int amount;
	
	public Card(String name, int cost, String type) {
		this.name = name;
		this.cost = cost;
		this.type = type;
	}
	public String getName(){
		return name;
	}
	
	public String toString() {
		return "name: " + name + " cost: " + cost + " type: " + type + "\n" ;
	}
}
