package mainPackage;

public class Card {
	private int id;
	private String name;
	
	public Card(int id, String name) {
		this.id = id;
		this.name = name;		
	}
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public String toString() {
		return "id: " + id + ", name: " + name;
	}
}
