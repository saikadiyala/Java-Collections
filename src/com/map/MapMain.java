package com.map;

import com.contact.Contact;
import com.contact.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {
        List<Contact> phones= ContactData.getData("phone");
        List<Contact> emails= ContactData.getData("email");

        List<Contact> fullList=new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------");

        Map<String,Contact> contacts=new HashMap<>();
        for(Contact contact: fullList){
            contacts.put(contact.getName(),contact);
        }

        contacts.forEach((k,v)-> System.out.println("key="+k+" value="+v));
        System.out.println("---------------------------------");
        System.out.println(contacts.get("Charlie Brown"));

        //contacts.clear( ) -- clears the contact elements




    }
}
