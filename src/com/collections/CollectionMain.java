package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//printing cards , deck of cards

public class CollectionMain {
    public static void main(String[] args) {
        List<Card> deck=Card.getStandardDeck();
        Card.printDeck(deck);  //prints all 522 cards

       // working with functions from Collections Class
        Card[] cardArray=new Card[13];
        Card aceOfHearts=Card.getFaceCard(Suit.HEART,'A');
        //Arrays.fill belongs to Arrays method
        Arrays.fill(cardArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray),"Ace of Hearts",1 );
        //same fill method in collections class
        List<Card> cards=new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size()="+cards.size());

    }
}
