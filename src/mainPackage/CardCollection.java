package mainPackage;
import java.util.*;
public class CardCollection {
	private boolean visible;
	private List<Card> cards = new ArrayList<Card>();
	private int amountOfCards;
	
	public CardCollection(boolean visible)
	{
		this.visible = visible;
	}
	public CardCollection(List<Card> cards, boolean visible)
	{
		this.cards = cards;
		amountOfCards = cards.size();
		this.visible = visible;
	}
	public void remove(int removeCounter)
	{
		for (int i = 0; i < removeCounter;i++)
		{
			this.cards.remove(i);
		}
	}
	public void addCard(Card c)
	{
		this.cards.add(c);
	}
	public void addList(List<Card> discard)
	{
	
		this.cards.addAll(discard);
	}
	public List<Card> getAllCards()
	{
		System.out.println("All cards" + " " + this.cards.size() + "\n");
		
		if (this.cards.size() != 0)
		{
			List<Card> cards = new ArrayList<Card>();
			for(int i = 0; i < this.cards.size(); i++){
				cards.add(this.cards.get(i));
			}
			return cards;

		}
		return null;
	}
	public CardCollection getHand(int handsize)
	{
		System.out.println("Hand" + " " + handsize + "\n");
		CardCollection cards = new CardCollection(true);
		for(int i = 0 ; i < handsize;i++)
		{
			cards.addCard(this.cards.get(i));
		}
		System.out.println("");
		return cards;
	}
	public Card getCard(int i)
	{
		return cards.get(i);
	}
	public void Shuffle()
	{

		Random rndShuffle = new Random();
		rndShuffle.nextInt();
		for (int i = 0;i < amountOfCards;i++)
		{
			int change =i + rndShuffle.nextInt(amountOfCards - i);
			Card helper = this.cards.get(i);
			
			this.cards.set(i, this.cards.get(change));
			this.cards.set(change, helper);
		}
		
	}	
}
