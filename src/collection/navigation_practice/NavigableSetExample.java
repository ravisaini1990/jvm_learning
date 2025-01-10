package collection.navigation_practice;

import java.util.Collections;
import java.util.TreeSet;

public class NavigableSetExample {

    public static void main(String[] args) {

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(1);
        integerTreeSet.add(4);
        integerTreeSet.add(7);
        integerTreeSet.add(10);
        integerTreeSet.add(15);
        integerTreeSet.add(20);

        System.out.println(integerTreeSet);

        System.out.println("Navigable ceiling::: "+integerTreeSet.ceiling(3));
        System.out.println("Navigable floor::: "+integerTreeSet.floor(11));
        System.out.println("Navigable higher::: "+integerTreeSet.higher(1));
        System.out.println("Navigable lower ::: "+integerTreeSet.lower(10));
        System.out.println("Navigable lower ::: "+integerTreeSet.lower(1)); //null since no lower value


        System.out.println("Navigable pollFirst ::: "+integerTreeSet.pollFirst());
        System.out.println("Navigable pollLast ::: "+integerTreeSet.pollLast());


        System.out.println("Navigable first ::: "+integerTreeSet.first());
        System.out.println("Navigable last ::: "+integerTreeSet.last());
        System.out.println("Navigable getLast ::: "+integerTreeSet.getLast());


        //headTail, tailSet
        System.out.println("Navigable headSet ::: "+integerTreeSet.headSet(10));
        System.out.println("Navigable tailSet ::: "+integerTreeSet.tailSet(10));


        System.out.println("Navigable tailSet  fist and last of subset::: "+integerTreeSet.tailSet(10).first());
        System.out.println("Navigable tailSet  fist and last of subset::: "+integerTreeSet.tailSet(10).last());

        //reverse order of tree
        TreeSet<Integer> reverseIntegerTreeSet = new TreeSet<>(Collections.reverseOrder());
        reverseIntegerTreeSet.add(1);
        reverseIntegerTreeSet.add(4);
        reverseIntegerTreeSet.add(7);
        reverseIntegerTreeSet.add(10);
        reverseIntegerTreeSet.add(15);
        reverseIntegerTreeSet.add(20);

        System.out.println(reverseIntegerTreeSet);

        System.out.println("reverseIntegerTreeSet Navigable headSet ::: "+reverseIntegerTreeSet.headSet(10));
        System.out.println(" reverseIntegerTreeSet Navigable tailSet ::: "+reverseIntegerTreeSet.tailSet(10));


    }
}
