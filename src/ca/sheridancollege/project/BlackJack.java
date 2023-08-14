/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author adits
 */   
import java.util.Scanner;
public class BlackJack {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialPoints = 5000;
        Player player = new Player(initialPoints); // Create a player with initial points
        Game game = new Game(); // Create a game instance

        System.out.println("Welcome to Blackjack!");

        while (true) {
            int betAmount = getBetAmount(player, scanner); // Get the bet amount from the player
            player.placeBet(betAmount); // Set the player's bet amount

            // Deal initial cards to the player
            player.resetHand();
            player.addCardToHand(game.dealCard());
            player.addCardToHand(game.dealCard());

            while (true) {
                System.out.println("Your hand: " + player.getHand());
                System.out.println("Total value: " + player.getHandValue());
                System.out.print("Do you want to hit or stand? ");
                String choice = scanner.next().toLowerCase();

                if (choice.equals("hit")) {
                    player.addCardToHand(game.dealCard()); // Player draws a card
                    int handValue = player.getHandValue();

                    if (handValue > 21) {
                        System.out.println("Bust! Your hand value is over 21.");
                        player.subtractPoints(player.getBet()); // Player loses the bet
                        break;
                    }
                } else if (choice.equals("stand")) {
                    break; // Player chooses to stand
                } else {
                    System.out.println("Invalid choice. Please enter 'hit' or 'stand'.");
                }
            }

            System.out.println("Your hand: " + player.getHand());
            System.out.println("Your hand value: " + player.getHandValue());

            // Dealer's turn
            Player dealer = new Player(0); // Create a dealer
            dealer.addCardToHand(game.dealCard()); // Dealer draws a card
            dealer.addCardToHand(game.dealCard()); // Dealer draws another card

            while (dealer.getHandValue() < 17) {
                dealer.addCardToHand(game.dealCard()); // Dealer keeps drawing until hand value is at least 17
            }

            System.out.println("Dealer's hand: " + dealer.getHand());
            System.out.println("Dealer's hand value: " + dealer.getHandValue());

            // Result comparison
            int playerHandValue = player.getHandValue();
            int dealerHandValue = dealer.getHandValue();

            if (playerHandValue > 21) {
                System.out.println("You lose! Your hand value is over 21.");
            } else if (dealerHandValue > 21) {
                System.out.println("You win! Dealer's hand value is over 21.");
                player.addPoints(player.getBet() * 2); // Player wins double the bet
            } else if (playerHandValue > dealerHandValue) {
                System.out.println("You win! Your hand value is higher than the dealer's.");
                player.addPoints(player.getBet() * 2); // Player wins double the bet
            } else if (playerHandValue < dealerHandValue) {
                System.out.println("You lose! Dealer's hand value is higher than yours.");
            } else {
                System.out.println("It's a tie! Your hand value is equal to the dealer's.");
                player.addPoints(player.getBet()); // Player gets back the bet amount
            }

            System.out.println("Available points: " + player.getPoints());

            while (true) {
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (playAgain.equals("yes")) {
                    player.resetHand();
                    dealer.resetHand();
                    player.resetBet();
                    player.addCardToHand(game.dealCard());
                    player.addCardToHand(game.dealCard());
                    dealer.addCardToHand(game.dealCard());
                    dealer.addCardToHand(game.dealCard());
                    break; // Restart the game
                } else if (playAgain.equals("no")) {
                    System.out.println("Thanks for playing!");
                    scanner.close();
                    return; // Exit the program
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }
    }

    // Get the bet amount from the player
    private static int getBetAmount(Player player, Scanner scanner) {
        while (true) {
            System.out.println("Available points: " + player.getPoints());
            System.out.print("Place your bet: ");
            
            try {
                int betAmount = scanner.nextInt();
                if (betAmount <= 0 || betAmount > player.getPoints()) {
                    System.out.println("Invalid bet amount. Please bet between 1 and your available points.");
                } else {
                    return betAmount;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid bet amount.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
    }    
}
