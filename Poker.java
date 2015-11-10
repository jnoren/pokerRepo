import java.util.ArrayList;

public class Poker {
	
	// We are just int our classes / different hands here 
	
	// setting all to 0  except our seven or 5 card 
	private int sevenOrFiveCard = -1;
	
	private int royal_Flush = 0;
	
	private int Pair = 0;
	
	private int high_Card = 0;
	
	private int straight_Flush = 0;
	
	private double number_Hands_Active;
	
	private int four_of_kind = 0;
	
	private ArrayList <Card> poker_hand = new ArrayList <Card>();

	private int full_house = 0;
	
	private int Flush = 0;
	
	private int Straight = 0;
	
	private int threeOfAKind = 0;
	
	private int two_Pair = 0;
	;

public ArrayList<Card> getpokerHand() {
		
		return poker_hand;
	}

	//  here we just want to make test 
	
	
	
	

	public Poker(int i) throws HandSizeException
	
	
	// creating if else to check if card is correct 
	{
		if(i != 7 && i != 5)
		{
			throw new HandSizeException();
		}
		else
		{
			sevenOrFiveCard = i;
		}
	}
	
	public  ArrayList <Card> get_straight_flush()
	{
		int spades = 0;
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;
		ArrayList <Card> straightCards = new ArrayList <Card>();
		int numStraightCards = 0;
		
		straightCards.add(poker_hand.get(0));

		for(int i = 0; i < poker_hand.size() - 1; i++)
		{
			//checks if the cards are in sequential order
			if((poker_hand.get(i+1).getValue() - poker_hand.get(i).getValue()) == 1)
			{
				straightCards.add(poker_hand.get(i+1));
				numStraightCards++;

			}
			//checks if the two cards are equal
			else if((poker_hand.get(i+1).getValue() - poker_hand.get(i).getValue()) == 0)
			{
				numStraightCards = numStraightCards + 0;
			}
			//means that the two cards could not be a part of a straight. 
			else
			{
				numStraightCards = 0;
				straightCards.clear();
				straightCards.add(poker_hand.get(i));
			}
		}


		if(straightCards.size() >= 5)
		{
			for(int i = 0; i < straightCards.size(); i++)
			{
				if(straightCards.get(i).getSuit() == "Spades")
				{
					spades++;
				}
				if(straightCards.get(i).getSuit() == "Clubs")
				{
					clubs++;
				}
				if(straightCards.get(i).getSuit() == "Hearts")
				{
					hearts++;
				}
				if(straightCards.get(i).getSuit() == "Diamonds")
				{
					diamonds++;
				}
			}
			if(!(spades >= 5 || clubs >= 5 || hearts >= 5 || diamonds >= 5))
			{
				straightCards.clear();
			}

		}
		return straightCards;
	}
	
	
	public void set_poker_hand(ArrayList <Card> Hand) {
		
		poker_hand = Hand;
	}
	public void sortHand() throws ruleException
	{
		for(int j = 0; j < (poker_hand.size() - 1); j++)
		{
			for(int i = 0; i < (poker_hand.size() - 1); i++)
			{
				if(poker_hand.get(i).getValue() > poker_hand.get(i+1).getValue())
				{
					
					
					Card temp = new Card(poker_hand.get(i+1).getValue(), poker_hand.get(i+1).getSuit());
					
					
					// grab the value that is set with the pokerhand   
					poker_hand.get(i+1).valueSet (poker_hand.get(i).getValue());
					//  same as I did before just setting this one up to equal it 
					poker_hand.get(i+1).suitSet(poker_hand.get(i).getSuit());
					// grab the value that is set with the pokerhand   

					poker_hand.get(i).valueSet (temp.getValue());
					// grab the value that is set with the pokerhand   

					poker_hand.get(i).suitSet(temp.getSuit());
				}
			}
		}
	}
	
	public boolean isRoyalFlush()
	{
		boolean retVal = false;
		ArrayList < Card > sf = get_straight_flush();
		if(sf.size() >= 5 && sf.get(sf.size() - 1).getValue() == 14)
		{
			retVal = true;
		}
		return retVal;
	}
	public boolean isStraightFlush()
	{
		boolean retVal = false;
		ArrayList < Card > sf = get_straight_flush();
		if(sf.size() >= 5)
		{
			retVal = true;
		}
		return retVal;
	}
	public boolean isFourOfAKind()
	{
		//counter of values
		int numOfValue = 0;
		for(int i = 0; i < poker_hand.size() - 1; i++)
		{
			//if the value ever hits three there are 4 of a kind and will break the loop
			if(numOfValue == 3)
			{
				break;
			}
			if(poker_hand.get(i).getValue() == poker_hand.get(i+1).getValue())
			{
				numOfValue++;
			}
			else
			{
				numOfValue = 0;
			}
		}
		return numOfValue == 3;
	}
	public boolean isFullHouse()
	{
		//counter of values
		int numPairs = 0;
		boolean retVal = false;
		for(int i = 0; i < poker_hand.size() - 2; i++)
		{
			//if there is a three of a kind it will be found
			if(poker_hand.get(i).getValue() == poker_hand.get(i+1).getValue() && poker_hand.get(i+1).getValue() == poker_hand.get(i + 2).getValue())
			{
				for(int j = 0; j < poker_hand.size() - 1; j++)
				{
					if(poker_hand.get(j).getValue() == poker_hand.get(j+1).getValue())
					{
						numPairs++;
					}
				}
				if(numPairs >=3)
				{
					retVal = true;
				}
			}
		}
		return retVal;
	}
	public boolean isFlush()
	{
		//counters
		int spades = 0;
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;
		for(int i = 0; i < poker_hand.size(); i++)
		{
			if(poker_hand.get(i).getSuit() == "Spades")
			{
				spades++;
			}
			if(poker_hand.get(i).getSuit() == "Clubs")
			{
				clubs++;
			}
			if(poker_hand.get(i).getSuit() == "Hearts")
			{
				hearts++;
			}
			if(poker_hand.get(i).getSuit() == "Diamonds")
			{
				diamonds++;
			}
		}
		return spades >= 5 || clubs >= 5 || hearts >= 5 || diamonds >= 5;
	}
	public boolean isStraight()
	{
		//creates a vector that will store the possible straight or any cards that are in sequencial order
		int straightCards = 0;
		for (int i = 0; i < poker_hand.size() - 1; i++)
		{
			//checks if the cards are in sequential order
			if((poker_hand.get(i+1).getValue() - poker_hand.get(i).getValue()) == 1)
			{
				straightCards++;
			}
			//checks if the two cards are equal
			else if((poker_hand.get(i+1).getValue() - poker_hand.get(i).getValue()) == 0)
			{
				straightCards = straightCards  + 0;
			}
			//means that the two cards could not be a part of a straight. 
			else
			{
				straightCards = 0;
			}
			if(straightCards == 4)
			{
				break;
			}

		}
		return straightCards >= 4; 

	}
	public boolean isThreeOfAKind()
	{
		//counter of values
		int numOfValue = 0;
		for(int i = 0; i < poker_hand.size() - 1; i++)
		{
			//if the value ever hits three there are 4 of a kind and will break the loop
			if(numOfValue == 2)
			{
				break;
			}
			if(poker_hand.get(i).getValue() == poker_hand.get(i + 1).getValue())
			{
				numOfValue++;
			}
			else
			{
				numOfValue = 0;
			}
		}
		return numOfValue == 2;
	}
	public boolean isTwoPair()
	{
		int numOfValue = 0;
		for(int i = 0; i < poker_hand.size() - 1; i++)
		{
			if( numOfValue == 2 )
			{
				break;
			}
			
			if(poker_hand.get(i).getValue() == poker_hand.get(i+1).getValue())
				
			{
				numOfValue++;
			}
		}
		return numOfValue == 2;
	}
	public boolean isPair()
	{
		//counter of values
		int numOfValue = 0;
		for(int i = 0; i < poker_hand.size() - 1; i++)
		{
			//if the value ever hits three there are 4 of a kind and will break the loop
			if(numOfValue == 1)
			{
				break;
			}
			if(poker_hand.get(i).getValue() == poker_hand.get(i+1).getValue())
			{
				numOfValue++;
			}
			else
			{
				numOfValue = 0;
			}
		}
		return numOfValue == 1;
	}

	public void playAndDisplay() throws ruleException, NoCardLeftInDeck 
	{
		for(int i = 0; i < getNumberOfHandsToPlay(); i++)
		{
			
			// creating what will come out and add on  with it 
			// grab deck shuffle 
			
			Deck theDeck = new Deck();
			theDeck.shuffle();
			theDeck.dealCards(poker_hand, sevenOrFiveCard);
			sortHand();
			if(isRoyalFlush())
			{
				royal_Flush++;
			}
			
			// do flush 
			
			else if (isStraightFlush())
			{
				straight_Flush++;	
			}
			else if (isFlush())
			{
				Flush++;
			}

			else if (isStraight())
			{
				Straight++;	
			}
			else if (isFullHouse())
			{
				full_house++;
			}
			
			else if (isFourOfAKind())
			{
				four_of_kind++;
			}
			

			else if (isThreeOfAKind())
			{
				threeOfAKind++;	
			}
			else if (isTwoPair())
			{
				two_Pair++;	
			}
			else if (isPair())
			{
				Pair++;
			}
			
		
			else
			{
				high_Card++;
			}
			//empty out the  collection of cards for the next Hand
			poker_hand.clear();
		}
		
		
		 // here we just need to build the system or the print out the information // needed to change the C code to cout in a different 
		// way sense it was 
		System.out.println("Percentage was " + (royal_Flush/getNumberOfHandsToPlay()) * 100 + "% you'll get a Royal Flush ." );
		System.out.println("Percentage was " + (straight_Flush/getNumberOfHandsToPlay()) * 100 + "% you'll get a  Straight Flush" );
		System.out.println("Percentage was " + (four_of_kind/getNumberOfHandsToPlay()) * 100 + "% you'll get a Four of a Kind" );
		System.out.println("Percentage was  " + (full_house/getNumberOfHandsToPlay()) * 100 + "% you'll get a  Full Houses" );
		System.out.println("Percentage was " + (Flush/getNumberOfHandsToPlay()) * 100 + "% you'll get a Flush." );
		System.out.println("Percentage was " + (Straight/getNumberOfHandsToPlay()) * 100 + "% you'll get a Straight." );
		System.out.println("Percentage was " + (threeOfAKind/getNumberOfHandsToPlay()) * 100 + "% you'll get a Three of a Kind" );
		System.out.println("Percentage was " + (two_Pair/getNumberOfHandsToPlay()) * 100 + "% you'll get a  Two Pairs." );
		System.out.println("Percentage was " + (Pair/getNumberOfHandsToPlay()) * 100 + "% you'll get a  Pair." );
		System.out.println("Percentage was " + (high_Card/getNumberOfHandsToPlay()) * 100 + "% you'll get a High Card." );
	}
	
	
	
	
	public int getFiveOrSevenCard() {
		return sevenOrFiveCard;
	}
	public void setFiveOrSevenCard(int sevenOrFiveCard) {
		this.sevenOrFiveCard = sevenOrFiveCard;
	}
	public int getRoyalFlushCounter() {
		return royal_Flush;
	}
	public void setRoyalFlushCounter(int royal_Flush) {
		this.royal_Flush = royal_Flush;
	}
	public int getStraightFlushCounter() {
		return straight_Flush;
	}
	public void setStraightFlushCounter(int straight_Flush) {
		this.straight_Flush = straight_Flush;
	}
	public int getFourOfAKindCounter() {
		return four_of_kind;
	}
	public void setFourOfAKindCounter(int four_of_kind) {
		this.four_of_kind = four_of_kind;
	}
	public int getFullHouseCounter() {
		return full_house;
	}
	public void setFullHouseCounter(int full_house) {
		this.full_house = full_house;
	}
	public int getFlushCounter() {
		return Flush;
	}
	public void setFlushCounter(int Flush) {
		this.Flush = Flush;
	}
	public int getStraightCounter() {
		return Straight;
	}
	public void setStraightCounter(int Straight) {
		this.Straight = Straight;
	}
	public int getThreeOfAKindCounter() {
		return threeOfAKind;
	}
	public void setThreeOfAKindCounter(int threeOfAKind) {
		this.threeOfAKind = threeOfAKind;
	}
	public int getTwoPairCounter() {
		return two_Pair;
	}
	public void setTwoPairCounter(int two_Pair) {
		this.two_Pair = two_Pair;
	}
	public int getPairCounter() {
		return Pair;
	}
	public void setPairCounter(int Pair) {
		this.Pair = Pair;
	}
	public int getHighCardCounter() {
		return high_Card;
	}
	public void setHighCardCounter(int high_Card) {
		this.high_Card = high_Card;
	}


	public double getNumberOfHandsToPlay() {
		return number_Hands_Active;
	}


	public void setNumberOfHandsToPlay(double number_Hands_Active) {
		this.number_Hands_Active = number_Hands_Active;
	}

}