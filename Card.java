package xyz.mweisinger.blackjack;

/**
 * An implemtation of a playing card
 * 
 * @author Michael Weisinger
 * @since 08/15/2023
 *
 */

public class Card {

	/**
	 *  One of 4 suits for the card
	 */
	private Suit mySuit;
	
	/**
	 * the value of the card where ace = 1, jack-king = 11-13
	 * all others are the value
	 */
    private int myNumber;
    
    
    /**
     * Card constructor
     * @param aSuit		the suit of the card
     * @param aNumber	the value of the card
     */
	public Card(Suit aSuit, int aNumber ) {
		
		
		this.mySuit = aSuit;
		
		if (aNumber >= 1 && aNumber <= 13) {
		this.myNumber = aNumber;
		}else {
			System.err.println(aNumber + " is not valid card");
		}
	}
	
	/**
	 * 
	 * @return the cards value
	 */
	public int getNumber() {
		return myNumber;
	}
	
	
	
	public String toString() {
		
		String numStr = "Error";
		
		switch(this.myNumber) {
		case 2:
			numStr = "Two";
			break;
		case 3:
			numStr = "Three";
			break;
		case 4:
			numStr = "Four";
			break;
		case 5:
			numStr = "Five";
			break;
		case 6:
			numStr = "Six";
			break;
		case 7:
			numStr = "Seven";
			break;
		case 8:
			numStr = "Eight";
			break;
		case 9:
			numStr = "Nine";
			break;
		case 10:
			numStr = "Ten";
			break;
		case 11:
			numStr = "Jack";
			break;
		case 12:
			numStr = "Queen";
			break;
		case 13:
			numStr = "King";
			break;
		case 1:
			numStr = "Ace";
			break;

		}
		
		return numStr + " of " + this.mySuit ;

	}
		
}

