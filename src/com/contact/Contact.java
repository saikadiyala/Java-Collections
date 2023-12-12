package com.contact;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails=new HashSet<>();
    private Set<String> phones=new HashSet<>();
    private NumberFormat formatter = new DecimalFormat("(###) ###-####");

    public Contact(String name){
        this(name, null,0);
    }

    public Contact(String name, String email){
            this(name,email,0);
    }

    public Contact(String name, long phone){
       this(name,null,phone);
    }

    public Contact(String name, String email, long phone){
            this.name=name;
            if(email!=null){
                emails.add(email);
            }
            if(phone>=0){
                phones.add(formatter.format(phone));
            }
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
       return "%s: %s %s".formatted(name,emails,phones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return 33*getName().hashCode();
    }

    public Contact mergeContactDat(Contact contact){
        Contact newContact=new Contact(name);
        newContact.emails=new HashSet<>(this.emails);
        newContact.phones=new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
        return newContact;
    }

}
