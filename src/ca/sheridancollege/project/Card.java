/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
//@Author: gautasan

public class Card {
    private final Rank rank; // The rank of the card
    private final Suit suit; // The suit of the card

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank; // Return the rank of the card
    }

    @Override
    public String toString() {
        return rank + " of " + suit; // Return the card's rank and suit as a string
    }
}


