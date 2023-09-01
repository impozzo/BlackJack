package xyz.mweisinger.blackjack;

import java.util.Random; 


/**
 * Implementation of a deck of cards
 * 
 * @author Michael Weisinger
 * @since 08/15/2023
 *
 */
public class Deck {
	
	/**
	 * The array of cards in the deck, where the top card is in the first index
	 */
	private Card[] myCards;
	
	/**
	 * The number of cards currently in the deck
	 */
	private int numCards;

	
	/**
	 * constructor with default of 1 deck and no shuffle
	 */
	public Deck() {
		
		// call the other constructor
		this(1, false);
	}
    
	/**
	 * Constructor that defines the number of decks and should it be shuffled
	 * @param numDeck 	the number of decks in this deck
	 * @param shuffle	whether to shuffle cards or not
	 */
	public Deck(int numDeck, boolean shuffle) {
		
		this.numCards= numDeck * 52;


		this.myCards = new Card[this.numCards];
		
		// init card index
		int c = 0;
		
		
		// for each deck
		for (int d = 0; d < numDeck; d++) {
			
			//for each suit
			for (int s = 0; s<4; s++) {
				
				// for each value
				
				for (int n = 1 ; n<=13; n++)
				{
					
					// add a new card to the deck
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
		}
		
		//shuffle if necessary
		if (shuffle) {
			this.shuffle();
		}
	}

	
	/**
	 * Shuffle the deck by swapping pairs of cards
	 */
	public void shuffle() {
		
		Random rng = new Random();		
		Card temp;
		int j;
		
		for (int i = 0; i < this.numCards; i++) {
			
			// get a random card j to swap i's value with
			j = rng.nextInt(this.numCards);			
			
			//do swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
	}
	
	
	/**
	 * 
	 * Deal the next card from the top of the deck
	 * 
	 * @return	the dealt card.
	 */	
	public Card dealNextCard() {
		
		// get the top card
		Card top = this.myCards[0];
		
		
		// shift all subsequent cards to the left by 1 index
		for (int c=1; c < this.numCards; c++)
		{
			this.myCards[c-1] = this.myCards[c];			
		}
		// delete the last card
		this.myCards[this.numCards-1] = null;
		
		// decrement the number of cards in the deck
		this.numCards--;
		
		return top;
		
	}
	
	
	/**
	 * print the top cards in the deck
	 * 
	 * @param numToPrint 	the number of cards from the top of the deck to print
	 */
	public void printDeck(int numToPrint) {
		for (int c=0; c < numToPrint; c++) {
			System.out.printf("% 3d/%d %s", c+1, this.numCards, this.myCards[c].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);
		
	}
}
