package com.operations;

import java.util.*;

public class MainOperations {

    public static void main(String[] args) {
        Set<Task> tasks=TaskData.getTasks("all");
        //sortAndPrint("All Tasks", tasks);

       Set<Task> annstasks=TaskData.getTasks("ann");
//        sortAndPrint("Anns Tasks", annstasks); //these uses compareTo method because passing as null
//
       Set<Task> bobstasks=TaskData.getTasks("bob");
//        sortAndPrint("Bobs  Tasks", bobstasks);
//
        Set<Task> carolstasks=TaskData.getTasks("caroll");
//        sortAndPrint("Carols Tasks", carolstasks);

        /* comparing by priority
        Comparator<Task> sortByPriority=Comparator.comparing(Task::getPriority);
        Set<Task> annstasks=TaskData.getTasks("ann");
        sortAndPrint("Anns Tasks", annstasks,sortByPriority);
         */

        List<Set<Task>> t=new ArrayList<>();
        t.add(tasks);
        t.add(annstasks);
        t.add(bobstasks);
        t.add(carolstasks);

        sortAndPrint("Union of all Tasks",getUnion(t));

    }

    private static Set<Task> getUnion(List<Set<Task>> sets){
        int len=sets.size();
        Set<Task> union=new HashSet<>();
        for(int i=0;i<len;i++){
            union.addAll(sets.get(i));
        }
        return union;
    }

    private static Set<Task> getInterSection(HashSet<Task> set1, HashSet<Task> set2){
            Set<Task> intersect=new HashSet<>(set1);
            intersect.retainAll(set2);
            return intersect;
    }

    private static Set<Task> getDifference(HashSet<Task> set1, HashSet<Task> set2){
        Set<Task> difference=new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    private static void sortAndPrint(String header, Collection<Task> collection){
             sortAndPrint(header,collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter){
        String lineSeperator="_".repeat(90);
        System.out.println(lineSeperator);
        System.out.println(header);
        System.out.println(lineSeperator);

        List<Task> list=new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}
