package mainPackage;
import java.util.*;
public class CardCollection {
	private boolean visible;
	private List<Card> cards = new ArrayList<Card>();
	private int amountOfCards;
	
	public CardCollection(List<Card> cards, boolean visible)
	{
		this.cards = cards;
		amountOfCards = cards.size();
		this.visible = visible;
	}
	public List<Card> getAllCards()
	{
		List<Card> cards = new ArrayList<Card>();
		for(int i = 0; i < this.cards.size(); i++){
			System.out.println(this.cards.get(i).toString());
			cards.add(this.cards.get(i));
		}
		return cards;
	}
	public List<Card> getHandSize(int handsize)
	{
		List<Card> cards = new ArrayList<Card>();
		for(int i = 0 ; i < handsize;i++)
		{
			System.out.println(this.cards.get(i).toString());
			cards.add(this.cards.get(i));
		}
		return cards;
	}
	public Card getCard(int i)
	{
		System.out.println(cards.get(i).toString());
		return cards.get(i);
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
