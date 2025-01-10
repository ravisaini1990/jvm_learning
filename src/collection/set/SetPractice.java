package collection.set;

import java.util.*;

public class SetPractice {

    public static void main(String[] args) {

        //No Insertion  order
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(23);
        integerSet.add(13);
        integerSet.add(2);
        integerSet.add(22);
        integerSet.add(102);

        System.out.println(integerSet);

        //add duplicate
        integerSet.add(2);
        System.out.println(integerSet);
        System.out.println(integerSet.contains(102));

        System.out.println(integerSet.isEmpty());
        System.out.println(integerSet.size());


        //LinkedHashSet - Maintained Insertion  order
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(23);
        linkedHashSet.add(13);
        linkedHashSet.add(2);
        linkedHashSet.add(22);
        linkedHashSet.add(102);

        System.out.println("LinkedHasSet >>> " +linkedHashSet);

        //TreeSet - Sorting  order
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(23);
        treeSet.add(13);
        treeSet.add(2);
        treeSet.add(22);
        treeSet.add(102);

        System.out.println("Tree set>> "+treeSet);

        Set<Integer> treeSet1 = new TreeSet<>(Comparator.reverseOrder());
        treeSet1.add(23);
        treeSet1.add(13);
        treeSet1.add(2);
        treeSet1.add(22);
        treeSet1.add(102);

        System.out.println("Tree set reverse>> "+treeSet1);

    }
}
