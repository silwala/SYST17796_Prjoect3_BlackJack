/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author adits
 */ 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final List<Card> deck = new ArrayList<>(); // List to hold the deck of cards
    private final Random random = new Random(); // Random number generator

    public Game() {
        // Initialize the deck with all possible combinations of ranks and suits
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    // Method to deal a card from the deck
    public Card dealCard() {
        int index = random.nextInt(deck.size()); // Generate a random index
        return deck.remove(index); // Remove and return the card at the chosen index
    }
}
