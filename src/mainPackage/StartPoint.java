package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;

public class StartPoint {
	public static void main(String[] args) {
		ConnectToDatabase ctd = new ConnectToDatabase();
		
		List<Card> test = ctd.getDatabaseContent("select * from cards");

		CardCollection Cc = new CardCollection(test,true);
		Cc.getString();
		Cc.Shuffle();
		Cc.getString();
	}

}
