# Java-Collections

**Date:** Tuesday, December 5, 2023

- Collection is just an object that represents a group of objects
- All collection objects implements collection interface excepts maps
- Collection ( I ) -> List ( I ) , Set ( I ) , Queue ( I )
- List ( I ) -> LinkedList, ArrayList ( C )
- Set interface implemented -> HashSet, LinkedHashSet class
- Set ( I ) ->  SortedSet ( I ) -> TreeSet ( C )
- Queue ( I ) -> Deque ( I )
- Deque ( I ) -> ArrayDeque, LinkedList ( C )
- Map ( I ) -> SortedMap ( I )
- Map ( I ) -> HashMap, LinkedHashMap
- SortedMap ( I ) -> TreeMap (C)


**Date:** Monday, December 11, 2023

- Set Is not ordered, can contain single null element, no duplicates, operations are fast, O(1), HashSet uses HashMap in its implementation.
- For ordered set, either LinkedHashSet or TreeSet should be used.
- LinkedHashSet maintains insertion order , TreeSet sorted naturally, or by specifying sort during creation of class.
- LinkedHashSet maintains relationship b/w entries using doubly linked list.
- In a TreeSet , tree remains balanced as elements are added, underlying uses binary tree data structures, internally uses red black trees.
- TreeSet relies on Comparable or Comparator methods.
- Map interface - interface Map<K,V> 
- Map can’t have duplicate keys, Each key only map to single value
- HashMap - unordered, LinkedHashMap - ordered by insertion, TreeMap - sorted Map.
- HashMap - if key is present, then value is replaced
- Views, keySet( ), - the set returned from the keySet method, is backed by map, if map changes then they are reflected in the set as well.
