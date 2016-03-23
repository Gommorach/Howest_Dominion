
package databaseMySQL;

import mainPackage.Card;

import java.sql.*;
import java.util.*;

public class ConnectToDatabase {
		   // JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/dominion";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "root";
		   
		   public List<Card> getDatabaseContent(String query) {
			   List<Card> result = new ArrayList<Card>();			   
			   Connection conn = null;
			   Statement stmt = null;
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database... --> test");
			      
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(query);
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int id  = rs.getInt("CardID");
			         String name = rs.getString("CardName");
					 int cost = rs.getInt("Cost");
					 String type = rs.getString("CardType");
			         
			         result.add(new Card(id, name, cost, type));
			      }
			      rs.close();
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			   }
			   return result;			   
		   }
}
