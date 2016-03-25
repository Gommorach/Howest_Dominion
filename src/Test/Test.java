package Test;

import static org.junit.Assert.*;
import mainPackage.*;
import java.util.*;
public class Test {
	private Player p;
	public void setup()
	{
		List<Card> test = new ArrayList<Card>();
		for (int i=0;i<5;i++)
		{
			test.add(new Card("Copper", 0, "treasure"));
			
		}
		for (int i=0;i<5;i++)
		{
			test.add(new Card("Estate", 2, "Victory"));
		}
		
		CardCollection Cc = new CardCollection(test, true);
		p = new Player("Johno",0,Cc);
	}
	/*@org.junit.Test
	public void testgetHand() {
		setup();
		p.getDeckList().Shuffle();
		assertEquals(p.fillHand(),p.getHand());
	}*/
	
	@org.junit.Test
	public void testDrawCard()
	{
		setup();
		p.getDeckList().Shuffle();
		p.fillHand();
		p.drawCard(2);
		assertEquals(p.fillHand(),p.getHand());
	}

}
