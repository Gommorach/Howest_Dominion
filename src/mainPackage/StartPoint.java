package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;

public class StartPoint {
	public static void main(String[] args) {
		ConnectToDatabase ctd = new ConnectToDatabase();
		
		List<Card> test= new ArrayList();
		for (int i=0;i<5;i++)
		{
			test.add(new Card("Copper", 0, "treasure"));
			
		}
		for (int i=0;i<5;i++)
		{
			test.add(new Card("Estate", 2, "Victory"));
		}
		CardCollection Cc = new CardCollection(test,true);
		Cc.getAllCards();
		Cc.Shuffle();
		Cc.getAllCards();
		Player p = new Player("Johno",0,Cc);
	}

}
