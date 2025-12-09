/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.*;

public class WarGame {

    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();
    private int roundCount = 0;

    public WarGame() {
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
    }

    public void startGame() {
        deck.shuffle();

        // Deal 26 cards to each player
        for (int i = 0; i < 26; i++) {
            players.get(0).addCard(deck.draw());
            players.get(1).addCard(deck.draw());
        }
    }

    public void playGame() {
        startGame();

        while (roundCount < 50 &&
               players.get(0).getCardCount() > 0 &&
               players.get(1).getCardCount() > 0) {

            playRound();
            roundCount++;
        }

        Player winner = determineWinner();
        System.out.println("Winner: " + winner.getName());
    }

    public void playRound() {
        Card p1 = players.get(0).playCard();
        Card p2 = players.get(1).playCard();

        System.out.println("\nRound " + roundCount);
        System.out.println("Player 1 plays: " + p1);
        System.out.println("Player 2 plays: " + p2);

        if (p1.getRank() > p2.getRank()) {
            players.get(0).addCards(Arrays.asList(p1, p2));
            System.out.println("Player 1 wins this round!");
        } else if (p2.getRank() > p1.getRank()) {
            players.get(1).addCards(Arrays.asList(p1, p2));
            System.out.println("Player 2 wins this round!");
        } else {
            resolveWar(p1, p2);
        }
    }

    public void resolveWar(Card p1Card, Card p2Card) {
        System.out.println("*** WAR! ***");

        List<Card> warPile = new ArrayList<>();
        warPile.add(p1Card);
        warPile.add(p2Card);

        // Check if players have enough cards
        if (players.get(0).getCardCount() < 4 || players.get(1).getCardCount() < 4) {
            System.out.println("A player does not have enough cards for war!");
            return;
        }

        // Add 3 face-down cards each
        for (int i = 0; i < 3; i++) {
            warPile.add(players.get(0).playCard());
            warPile.add(players.get(1).playCard());
        }

        // Final face-up card
        Card final1 = players.get(0).playCard();
        Card final2 = players.get(1).playCard();

        System.out.println("Player 1 war card: " + final1);
        System.out.println("Player 2 war card: " + final2);

        warPile.add(final1);
        warPile.add(final2);

        if (final1.getRank() > final2.getRank()) {
            players.get(0).addCards(warPile);
            System.out.println("Player 1 wins the war!");
        } else {
            players.get(1).addCards(warPile);
            System.out.println("Player 2 wins the war!");
        }
    }

    public Player determineWinner() {
        if (players.get(0).getCardCount() > players.get(1).getCardCount()) {
            return players.get(0);
        } else {
            return players.get(1);
        }
    }
}

