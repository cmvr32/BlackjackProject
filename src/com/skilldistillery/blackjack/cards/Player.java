package com.skilldistillery.blackjack.cards;

public class Player {

	private Hand hand;

	public Player() {
		super();
		this.hand = new Hand();
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getHandValue();

	}

}
