package mainPackage;
import java.util.*;
public class CardCollection {
	private boolean visible;
	private List<Card> cards = new ArrayList();
	private int amountOfCards;
	
	public CardCollection(List<Card> cards, boolean visible)
	{
		this.cards = cards;
		amountOfCards = cards.size();
		this.visible = visible;
	}
	public void getString()
	{
		for(int i = 0; i < cards.size(); i++){
			System.out.println(cards.get(i).toString());
		}
	}
	public void getCard(int i)
	{
		System.out.println(cards.get(i).toString());
	}
	public void Shuffle()
	{
		Random rndShuffle = new Random();
		rndShuffle.nextInt();
		for (int i = 0;i < amountOfCards;i++)
		{
			int change = rndShuffle.nextInt(amountOfCards - 1);
			Card helper = this.cards.get(i);
			
			this.cards.set(i, this.cards.get(change));
			this.cards.set(change, helper);
		}
		
	}
	
}
