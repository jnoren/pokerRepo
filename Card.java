

public class Card {
	private String suit;  
	private int value;
	
	public Card(int a, String b) throws ruleException{
		valueSet (a);
		suitSet(b);
	}

	public int getValue() {
		return value;
	}

	public void valueSet (int value) throws ruleException{
		if(value >= 2 && value <= 14) {
			this.value = value;
		} else {
			throw new ruleException();
		}
	}

	public String getSuit() {
		return suit;
	}

	public void suitSet(String suit) throws ruleException {
		if(suit == "Hearts" || suit == "Spades" || suit == "Diamonds" || suit == "Clubs") {
			this.suit = suit;
		} else {
			throw new ruleException();
		}
	}
	
	public void print()
	{
		if(getValue() <= 10)
		{
			System.out.print(getValue());
		}
		else if(getValue() == 11)
		{
			System.out.print("J");
		}
		else if(getValue() == 12)
		{
			System.out.print("Q");
		}
		else if(getValue() == 13)
		{
			System.out.print("K");
		}
		else if(getValue() == 14)
		{
			System.out.print("A");
		}

		System.out.print(" of ");
		System.out.print( getSuit());
	}
}