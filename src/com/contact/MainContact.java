package com.contact;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainContact {
    public static void main(String[] args) {
        List<Contact> emails=ContactData.getData("email");
        List<Contact> phones=ContactData.getData("phone");
        printData("Phones List",phones);
        printData("Email List", emails);


        Set<Contact> emailContacts=new HashSet<>(emails);
        Set<Contact> phoneContacts=new HashSet<>(phones);

        printData("Phones Contacts",phoneContacts);
        printData("EmailContacts", emailContacts);

        Set<Contact> UnionAB=new HashSet<>();
        UnionAB.addAll(emailContacts);
        UnionAB.addAll(phoneContacts);
        //addAll is a union, like join in sets it combines and removes duplicates.

       // System.out.println("-----------Union---------------");
        printData("Union", UnionAB);

        Set<Contact> intersectAB=new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
       // System.out.println("---------Intersection of Two Sets---------------");
        printData("Intersection of two sets", intersectAB);

        Set<Contact> differenceAB=new HashSet<>(emailContacts);
        differenceAB.removeAll(phoneContacts);
        // System.out.println("---------Difference of Two Sets A minus B---------------");
        printData("Difference of two sets A minus B", differenceAB);

        Set<Contact> differenceBA=new HashSet<>(phoneContacts);
        differenceBA.removeAll(emailContacts);
        // System.out.println("---------Difference of Two Sets B minus A---------------");
        printData("Difference of two sets B minus A", differenceBA);

        System.out.println("not present in both A and B");
        Set<Contact> simmetricDiff=new HashSet<>(differenceAB);
        simmetricDiff.addAll(differenceBA);
        printData("Simmetric Difference",simmetricDiff);

        System.out.println("not present in both A and B another way");
        Set<Contact> simmetricDiff2=new HashSet<>(UnionAB);
        simmetricDiff2.removeAll(intersectAB);
        printData("Simmetric Difference2",simmetricDiff2);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("---------------------------");
        System.out.println(header);
        System.out.println("---------------------------");
        contacts.forEach(x->System.out.println(x));
    }
}
