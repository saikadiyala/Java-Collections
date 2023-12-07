package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkCollections {
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        l.add("Hello");
        String names[]={"Hi","How","Are"};
        l.addAll(Arrays.asList(names));
        System.out.println(l);
        System.out.println(l.contains("Hello"));
    }

}
