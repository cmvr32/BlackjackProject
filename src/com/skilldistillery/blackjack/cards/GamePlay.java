package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GamePlay {

	public void run() {
		Scanner sc = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		deck.shuffle();

		System.out.print("Dealing first card to player: ");
		Card c = deck.dealCard();
		player.addCard(c);
		System.out.print(c);

		System.out.print("\nDealing first card to dealer: ");
		c = deck.dealCard();
		dealer.addCard(c);
		System.out.print(c);

		System.out.print("\nDealing second card to player: ");
		c = deck.dealCard();
		player.addCard(c);
		System.out.print(c);

		System.out.print("\nDealing second card to dealer: ");
		c = deck.dealCard();
		dealer.addCard(c);
		System.out.print("[?] \n");

		System.out.println("\n=======================================");
		System.out.println("Players hand is valued at: " + player.getHandValue());
		System.out.println("Dealers hand is valued at: " + dealer.firstCardValue() + " + [?] ");
		System.out.println("=======================================");

		printHitOrStay();

		boolean keepGoing = true;

		do {
			int userInput = sc.nextInt();

			switch (userInput) {

			case 1: // hit
				System.out.print("Dealing another card to player: ");
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

			case 2: // stay

				keepGoing = false;
				break;
				
			default:
				System.out.println("Invalid entry");

			}

		} while (keepGoing);

		System.out.println("\n=======================================");
		System.out.println("          Dealers turn...              ");
		System.out.println("=======================================\n");

		while (dealer.getHandValue() < 17) {
			c = deck.dealCard();
			dealer.addCard(c);
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
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

		if (player.getHandValue() == dealer.getHandValue() ||(player.getHandValue() > 21 && dealer.getHandValue() > 21) ) {
			System.out.println("\n=======================================");
			System.out.println("Players hand is valued at: " + player.getHandValue());
			System.out.println("Dealers hand is valued at: " + dealer.getHandValue());
			System.out.println("=======================================");
			System.out.println("it's a tie");
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

	private void printHandAndValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
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
	}

	private void printLoserMessage() {
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("=                                     =");
		System.out.println("=  You lost, better luck next time.   =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");
	}
}
