
public class Main {
	// needed "warning" exp at first, was able to get to turned off 

	public static void main(String[] args) throws HandSizeException, ruleException, NoCardLeftInDeck {
		
		// TODO Auto-generated method stub
		//i added a line
		
		
		System.out.println("The 5 card list: "); 
		
		// here we are just calling this and the 
		// 5 - 7 card list so that we can print to screen 
		Poker p1 = new Poker(5); 
		
		
		Poker p2 = new Poker(7);
		
		
		p1.setNumberOfHandsToPlay(100000);
		
		p1.playAndDisplay();
		
		System.out.println("The 7 card list: ");
		
		p2.setNumberOfHandsToPlay(100000);
		
		p2.playAndDisplay();
	}
}