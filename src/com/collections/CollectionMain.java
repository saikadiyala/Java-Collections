package com.collections;

import java.util.List;


public class CollectionMain {
    public static void main(String[] args) {
        List<Card> deck=Card.getStandardDeck();
        Card.printDeck(deck);
    }
}
