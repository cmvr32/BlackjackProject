package com.skilldistillery.blackjack.cards;

public class Dealer {
	
	private Hand hand;

	public Dealer() {
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
	
	public int getHandValue () {
		return hand.getHandValue();
	}
	
	public int firstCardValue() {
		//hand.getHand().get(0);
		return hand.getHand().get(0).getValue();
	}
}
