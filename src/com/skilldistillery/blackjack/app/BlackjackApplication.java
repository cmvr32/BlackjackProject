package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.GamePlay;

public class BlackjackApplication {

	public static void main(String[] args) {
		BlackjackApplication app = new BlackjackApplication();
		app.run();
	}

	public void run() {

		GamePlay gp = new GamePlay();
		Deck deck = new Deck();
		deck.shuffle();

		Scanner sc = new Scanner(System.in);
		printLaunchMenu();
		int userInput = sc.nextInt();

		if (userInput == 1) {
			gp.run();
		} else {
			printQuitScreen();
		}

	}

	private void printLaunchMenu() {
		System.out.println("");
		System.out.println("======== Let's play Blackjack! ========");
		System.out.println("=                                     =");
		System.out.println("=             1. Play                 =");
		System.out.println("=             2. Quit                 =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");
	}// printMenu

	private void printQuitScreen() {
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("=                                     =");
		System.out.println("=        Thanks for playing!          =");
		System.out.println("=                                     =");
		System.out.println("=======================================");
		System.out.println("");
	}// printQuitScreen

}// class
