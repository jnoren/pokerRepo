
import java.util.Random;


import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
	
	private ArrayList<Card> deckOfCards = new ArrayList<Card>();
	
	// needed to throw an exception right here.
	// had error when first came out 
	
	public Deck() throws ruleException {
		
		
		
		// creating the array for all the suits that are needed 
		ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Spades", "Clubs"));
		
		for(int suitCounter = 0; suitCounter < suits.size(); suitCounter++) {
			
			for(int valuesCounter = 2; valuesCounter < 15; valuesCounter++) {
				
				// grabbing the card for temp-card = new and  // 
				Card tempCard = new Card(valuesCounter, suits.get(suitCounter));
				deckOfCards.add(tempCard);
			}
		}
	}
	
	
	public int getDeckSize() {
		
		// return the total size 
		
		return deckOfCards.size();
	}
	
	// 
	public void shuffle() throws ruleException {
		
		// this rule exception needs to be thrown so that cards that are set not legal to current rules get 
		// thrown out of play when this runs 
		Random r = new Random();
		
		for(int i = 0; i < deckOfCards.size(); i++) {
			
			int pos = r.nextInt(52-0) + 0;
			// get the deck of cards get 
			Card tempCard = new Card(deckOfCards.get(i).getValue(), deckOfCards.get(i).getSuit());
			// grab your deck of cards // get value 
			deckOfCards.get(i).valueSet (deckOfCards.get(pos).getValue());
			
			deckOfCards.get(i).suitSet(deckOfCards.get(pos).getSuit());
			
			deckOfCards.get(pos).valueSet (tempCard.getValue());
			
			deckOfCards.get(pos).suitSet(tempCard.getSuit());
		}
	}
	
	
	// was vector 
	public void dealCards(ArrayList <Card> Hand, int numCards) throws NoCardLeftInDeck
	{
		for(int i = 0; i<numCards;i++)
		{
			if(!deckOfCards.isEmpty()) {
				Hand.add(deckOfCards.get(deckOfCards.size() - 1));
				deckOfCards.remove(deckOfCards.size() - 1);
			}
			else {
				throw new NoCardLeftInDeck();
			}
		}
	}
	
	public void printDeck() {
		for(int i = 0; i < 52; i++) {
			deckOfCards.get(i).print();
		}
	}
}


	
