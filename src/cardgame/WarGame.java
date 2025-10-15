/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author DELL
 */
public class WarGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Deal 26 cards each
        for (int i = 0; i < 26; i++) {
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }

        // Play game
        while (player1.hasCards() && player2.hasCards()) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            if (card1.getRank() > card2.getRank()) {
                player1.addCard(card1);
                player1.addCard(card2);
                System.out.println(player1.getName() + " wins this round.\n");
            } else if (card2.getRank() > card1.getRank()) {
                player2.addCard(card1);
                player2.addCard(card2);
                System.out.println(player2.getName() + " wins this round.\n");
            } else {
                System.out.println("Tie! Cards discarded.\n");
            }
        }

        // Declare winner
        if (player1.hasCards()) {
            System.out.println(player1.getName() + " wins the game!");
        } else {
            System.out.println(player2.getName() + " wins the game!");
        }
    }
}
