package com.skilldistillery.blackjack.cards;

import java.util.Scanner;

import com.skilldistillery.blackjack.app.BlackjackApplication;

public class GamePlay {
	BlackjackApplication bjapp = new BlackjackApplication();

	public void gamePlay() {
		Scanner sc = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		deck.shuffle();

		System.out.print("1st card dealt to player: ");
		Card c = deck.dealCard();
		player.addCard(c);
		System.out.print(c);

		System.out.print("\n1st card dealt to dealer: ");
		c = deck.dealCard();
		dealer.addCard(c);
		System.out.print(c);

		System.out.print("\n2nd card dealt to player: ");
		c = deck.dealCard();
		player.addCard(c);
		System.out.print(c);

		System.out.print("\n2nd card dealt to dealer: ");
		c = deck.dealCard();
		dealer.addCard(c);
		System.out.print("[?] \n");

		System.out.println("\n=======================================");
		System.out.println("Players hand is valued at: " + player.getHandValue());
		System.out.println("Dealers hand is valued at: " + dealer.firstCardValue() + " + [?] ");
		System.out.println("=======================================");

		if (player.getHandValue() == 21) {
			System.out.println("\nWow! You scored 21 on the first deal!");
			System.out.println("That's an automatic win!");
			System.out.println("Dealers hand: " + dealer.firstCardValue() + c);
			System.out.println("");
			printWinnerMessage();
		}

		if (dealer.getHandValue() == 21) {
			System.out.println("\nThe dealer scored 21 on the first deal!");
			System.out.println("That's an automatic win for them.");
			System.out.println("Dealers hand: " + dealer.firstCardValue() + c);
			System.out.println("");
			printLoserMessage();
		}

		printHitOrStay();

		boolean keepGoing = true;

		do {
			int userInput = sc.nextInt();

			switch (userInput) {

			case 1:
				System.out.print("New card dealt to player: ");
				c = deck.dealCard();
				player.addCard(c);
				System.out.print(c + "\n");

				System.out.println("\n=======================================");
				System.out.println("Players hand is valued at: " + player.getHandValue());
				System.out.println("Dealers hand is valued at: " + dealer.firstCardValue() + " + [?] ");
				System.out.println("=======================================");

				if (player.getHandValue() > 21) {
					printLoserMessage();
					keepGoing = false;
				} else {
					printHitOrStay();
				}
				break;

			case 2:

				keepGoing = false;
				dealerTurn(dealer, player, deck, c);
				break;

			default:
				System.out.println("Invalid entry");
				break;
			}

		} while (keepGoing);

		
	}

	public void dealerTurn(Dealer dealer, Player player, Deck deck, Card c) {

		System.out.println("\n=======================================");
		System.out.println("          Dealers turn...              ");
		System.out.println("=======================================\n");

		while (dealer.getHandValue() < 17) {
			c = deck.dealCard();
			dealer.addCard(c);
			System.out.println("The dealer was dealt: " + c);
		}

		if (dealer.getHandValue() >= 17) {
			System.out.println("\nDealers hand is valued at or above 17 \nTherfore no additional cards dealt");
		}

		if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22) {
			System.out.println("\n=======================================");
			System.out.println("Players hand is valued at: " + player.getHandValue());
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
			System.out.println("=======================================");
			printWinnerMessage();
		}

		if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() < 22) {
			System.out.println("\n=======================================");
			System.out.println("Players hand is valued at: " + player.getHandValue());
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
			System.out.println("=======================================");
			printLoserMessage();
		}

		if (player.getHandValue() == dealer.getHandValue()
				|| (player.getHandValue() > 21 && dealer.getHandValue() > 21)) {
			System.out.println("\n=======================================");
			System.out.println("Players hand is valued at: " + player.getHandValue());
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
			System.out.println("=======================================");
			printTiedMessage();
		}

		if (player.getHandValue() < 22 && dealer.getHandValue() > 21) {
			System.out.println("\n=======================================");
			System.out.println("Players hand is valued at: " + player.getHandValue());
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
			System.out.println("=======================================");
			printWinnerMessage();
		}
		if (dealer.getHandValue() < 22 && player.getHandValue() > 21) {
			System.out.println("\n=======================================");
			System.out.println("Players hand is valued at: " + player.getHandValue());
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
			System.out.println("=======================================");
			printLoserMessage();
		}

	}

	private static void printHitOrStay() {
		System.out.println("");
		System.out.println("============== Your Move ==============");
		System.out.println("=                                     =");
		System.out.println("=             1. Hit                  =");
		System.out.println("=             2. Stay                 =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");

	}

	private void printWinnerMessage() {
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("=                                     =");
		System.out.println("=      Congratulations, you won!      =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");
//		bjapp.run();
	}

	private void printLoserMessage() {
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("=                                     =");
		System.out.println("=  You lost, better luck next time.   =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");
//		bjapp.run();
	}

	private void printTiedMessage() {
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("=                                     =");
		System.out.println("=      You and the dealer tied.       =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");
//		bjapp.run();
	}
}
