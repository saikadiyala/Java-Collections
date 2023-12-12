package com.Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String aText="Hello";
        String bText="Hello";
        String cText=String.join("l","He","lo");
        String dText="Hel".concat("lo");
        String eText="hello";



        List<String> list= Arrays.asList(aText,bText,cText,dText,eText);

        for(String l:list){
            System.out.println(l+" "+l.hashCode());
        }


        //aText and bText points to the same string object in memory
        //uses both hashcode() and equal() method to check whether they are equal or not and
        //add into the HashSet


        //Hashset creation using another collection
        //checking  which Hello is storing
        Set<String> mySet=new HashSet<>(list);
        System.out.println(mySet);
        System.out.println(mySet.size());
        System.out.println("--------");
        for(String str: mySet){
            System.out.print(str+": ");
            for(int i=0;i<list.size();i++){
                if(str == (list.get(i)) ){
                    //checking which Hello in the Set is same as Hello in the array
                    System.out.print(i+",");  //Hello: 0,1
                }
            }
            System.out.println(" ");
        }

        //playingCard
        PlayingCard aceHearts=new PlayingCard("Hearts","Ace");
        PlayingCard kingClubs=new PlayingCard("Clubs","King");
        PlayingCard queenOfSpades=new PlayingCard("Spades","Queen");

        List<PlayingCard> pc=Arrays.asList(aceHearts,kingClubs,queenOfSpades);

        System.out.println("-------------------------");

        pc.forEach(s-> System.out.println(s+": "+s.hashCode()));

        //adding elements to hashset
        Set<PlayingCard> deck=new HashSet<>();
        for(PlayingCard c:pc){
            //if element is added to hashset , it returns true
            //otherwise false, if element is not added we are printing the duplicate
            if(!deck.add(c)){
                System.out.println("duplicate found "+c);
            }
        }
        System.out.println(deck);
    }
}
