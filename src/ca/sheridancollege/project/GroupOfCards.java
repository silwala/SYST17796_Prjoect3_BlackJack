//@Author: gautasan

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {
    private final List<Card> cards = new ArrayList<>(); // List to store the cards

    // Add a card to the group
    public void addCard(Card card) {
        cards.add(card);
    }

    // Calculate the total value of the cards in the group
    public int getValue() {
        int totalValue = 0;
        int numAces = 0;

        for (Card card : cards) {
            totalValue += card.getRank().ordinal() + 2; // Add the value of each card
            if (card.getRank() == Rank.ACE) {
                numAces++; // Count the number of Aces in the group
            }
        }

        // Adjust the value if there are Aces and the total value is over 21
        while (numAces > 0 && totalValue > 21) {
            totalValue -= 10;
            numAces--;
        }

        return totalValue;
    }

    // Clear the cards from the group
    public void clear() {
        cards.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : cards) {
            stringBuilder.append(card.toString()).append(", "); // Append each card's string representation
        }
        return stringBuilder.toString();
    }
}