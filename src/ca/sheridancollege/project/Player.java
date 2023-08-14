/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author adits
 */ 
public class Player {
    private int points; // Player's available points
    private int bet; // Player's bet amount
    private final GroupOfCards hand = new GroupOfCards(); // Player's hand of cards

    public Player(int initialPoints) {
        this.points = initialPoints; // Initialize player's points
    }

    // Add points to the player's total
    public void addPoints(int amount) {
        points += amount;
    }

    // Subtract points from the player's total
    public void subtractPoints(int amount) {
        points -= amount;
    }

    // Get the player's current points
    public int getPoints() {
        return points;
    }

    // Place a bet and subtract the bet amount from points
    public void placeBet(int amount) {
        bet = amount;
        subtractPoints(amount);
    }

    // Reset the player's bet amount to zero
    public void resetBet() {
        bet = 0;
    }

    // Get the player's current bet amount
    public int getBet() {
        return bet;
    }

    // Add a card to the player's hand
    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    // Get the value of the player's hand
    public int getHandValue() {
        return hand.getValue();
    }

    // Get the string representation of the player's hand
    public String getHand() {
        return hand.toString();
    }

    // Reset the player's hand by clearing the cards
    public void resetHand() {
        hand.clear();
    }
}
