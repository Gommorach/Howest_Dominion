package Test;

import static org.junit.Assert.*;
import mainPackage.*;
import java.util.*;
public class Test {
	private Player p;
	private CardCollection CcHand;
	private CardCollection Cc;
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
		
		Cc = new CardCollection(deck, true);
		p = new Player("Johno",0);
		p.setDecklist(Cc);
	}
	@org.junit.Test
	public void testgetHand() {		
		setup();
		CcHand = p.fillHand();
		System.out.println("testHand");
		assertEquals(p.getDeckList().getAllCards().size(), 5);
		p.getHand();
	}
	@org.junit.Test
	public void testDrawCard()
	{
		
		setup();
		CcHand = p.fillHand();
		System.out.println("testDRAW");
		p.drawCard(2);
		assertEquals(CcHand.getAllCards().size(),7);
		p.getDeckList();
		p.getHand();
	}

}
