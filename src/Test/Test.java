package Test;

import static org.junit.Assert.*;
import mainPackage.*;
import java.util.*;
public class Test {
	private Player p;
	private CardCollection CcHand;
	public void setup()
	{
		List<Card> deck = new ArrayList<Card>();
		List<Card> discard = new ArrayList<Card>();
		for (int i=0;i<5;i++)
		{
			deck.add(new Card("Copper", 0, "treasure"));
			
		}
		for (int i=0;i<5;i++)
		{
			deck.add(new Card("Estate", 2, "Victory"));
		}
		
		CardCollection Cc = new CardCollection(deck, true);
		p = new Player("Johno",0,Cc);
	}
	@org.junit.Test
	public void testRemoveCard()
	{
		setup();
		System.out.println("testREMOVE");
		assertEquals(p.getDeckList().getAllCards().size() ,5);
		System.out.println(
		p.getDeckList().getAllCards().toString());
	}
	@org.junit.Test
	public void testgetHand() {		
		setup();
		CcHand = p.fillHand();
		System.out.println("testHand");
		assertEquals(p.getDeckList().getAllCards().size(), 5);
	}
	@org.junit.Test
	public void testDrawCard()
	{
		
		setup();
		CcHand = p.fillHand();
		System.out.println("testDRAW");
		p.drawCard(2);
		assertEquals(CcHand.getAllCards().size(),7);
	}

}
