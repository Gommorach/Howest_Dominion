package mainPackage;

public class Card {
	private int id;
	private String name;
	private int cost;
	private String type;
	
	public Card(int id, String name, int cost, String type) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.type = type;
	}
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public String toString() {
		return "id: " + id + ", name: " + name + " cost: " + cost + " type: " + type ;
	}
}
