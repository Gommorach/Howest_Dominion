package mainPackage;
import java.util.*;
public class CardCollection {
	private boolean visible;
	private List<Card> Cards = new ArrayList();
	private int AmountOfCards;
	
	public Card getCard(String name)
	{
		Card card = Cards.stream()
				.filter(Cards -> Cards.getName().equals(name))
				.collect(Collectors.toList());
		return card;
	}
	
}
