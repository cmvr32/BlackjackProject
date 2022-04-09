package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<>();

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clearHand() {
		hand.clear();
	}

	public List<Card> getHand() {
		return hand;
	}

	public int getHandValue() {
		int total = 0;
		for (Card card : hand) {
			total += card.getValue();
		}
		return total;
	}

	public int getCardValue() {
		int value = 0;

		value = hand.get(0).getValue();
		return value;
	}
}
