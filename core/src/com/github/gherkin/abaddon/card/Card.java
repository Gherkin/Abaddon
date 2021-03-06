package com.github.gherkin.abaddon.card;

import java.util.Random;

public class Card {
    private int rank, suit = 0;
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    
    Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    Card() {
    }
    
    Card(Boolean randomy) {
        Random random = new Random();
        rank = random.nextInt(13);
        suit = random.nextInt(4);
    }
    
    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
}
