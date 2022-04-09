package com.skilldistillery.blackjack.cards;

public enum Suit {
	// HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	HEARTS("\u2665\uFE0F"), SPADES("\u2660\uFE0F"), CLUBS("\u2663\uFE0F"), DIAMONDS("\u2666\uFE0F");

	private String name;

	Suit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}