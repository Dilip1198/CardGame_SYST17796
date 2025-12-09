/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.*;

public class Player {

    private String name;
    private Queue<Card> hand = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public void addCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public Card playCard() {
        return hand.poll();
    }

    public int getCardCount() {
        return hand.size();
    }

    public String getName() {
        return name;
    }
}

