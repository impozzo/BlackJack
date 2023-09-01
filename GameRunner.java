package xyz.mweisinger.blackjack;


import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		
		
		//init
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		Player me = new Player("Mike");
		Player dealer = new Player("Dealer");
		
		// Init players
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		// Print initial hands
		System.out.println("Cards are dealt:\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while(!meDone || !dealerDone) {
			
			// player's turn
			if (!meDone) {
				System.out.print("Hit or Stay? [Enter H or S]: ");
				ans = sc.next();
				System.out.println();
				
				// if the player hits
				if(ans.compareToIgnoreCase("H") == 0) {
					
					meDone = !me.addCard(theDeck.dealNextCard());
					me.printHand(true);
					//dealer.printHand(false);
					
					
				}
				else {
					meDone = true;
				}
				
				// dealer's turn
				if (!dealerDone) {
					
					if(dealer.getHandSum()	< 17) {
						
						System.out.println("The Dealer hits\n");
						dealerDone = !dealer.addCard(theDeck.dealNextCard());
						dealer.printHand(false);
					} else {
						System.out.println("The Dealer stays'n");
						dealerDone = true;
					}
				}
			}
		}
		
		sc.close();	
		
		//print final hands
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
			System.out.println("You win");
		}
		else {
			System.out.println("Dealer Wins");
		}
		
		
	}

}
