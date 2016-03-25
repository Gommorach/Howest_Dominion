package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;

public class StartPoint {
	public static void main(String[] args) {
		ConnectToDatabase ctd = new ConnectToDatabase();
		
		List<Card> test = ctd.getDatabaseContent("select * from cards");

		CardCollection Cc = new CardCollection(test,true);
		Cc.getAllCards();
		Cc.Shuffle();
		Cc.getAllCards();
		Player p = new Player("Johno",0,Cc);
	}

}
