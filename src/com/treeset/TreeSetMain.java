package com.treeset;

import com.contact.Contact;
import com.contact.ContactData;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones= ContactData.getData("phone");
        List<Contact> emails= ContactData.getData("email");
        NavigableSet<Contact> sorted=new TreeSet<>(phones);
        //this will give an error as comparator or comparable method should be implemented.
        sorted.forEach(System.out::println);
    }
}
