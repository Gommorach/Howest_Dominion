package mainPackage;

import java.util.*;
import databaseMySQL.ConnectToDatabase;

public class StartPoint {
	public static void main(String[] args) {
		ConnectToDatabase ctd = new ConnectToDatabase();
		
		List<Card> test = ctd.getDatabaseContent("select * from cards");
		for(int i = 0; i < test.size(); i++){
			System.out.println(test.get(i).toString());
		}
		
	}

}
