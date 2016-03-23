package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;

public class StartPoint {
	public static void main(String[] args) {
		ConnectToDatabase ctd = new databaseMySQL.ConnectToDatabase();
		
		Game testGame = new Game(2);
//		List<Card> test = ctd.getDatabaseContent("select * from cards");

//		CardCollection Cc = new CardCollection(test,true);
//		Cc.getCards();
//		Cc.Shuffle();
//		Cc.getCards();
	}

}
