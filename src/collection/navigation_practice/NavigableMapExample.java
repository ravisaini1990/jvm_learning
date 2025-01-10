package collection.navigation_practice;

import java.util.TreeMap;

public class NavigableMapExample {
    public static void main(String[] args) {

        TreeMap<String, Integer> navigableTreeMap = new TreeMap<>();
        navigableTreeMap.put("a", 1);
        navigableTreeMap.put("b" , 4);
        navigableTreeMap.put("c" ,7);
        navigableTreeMap.put("d" ,10);
        navigableTreeMap.put("e" ,15);
        navigableTreeMap.put("f" ,20);

        System.out.println(navigableTreeMap);

        //add duplicate key
        navigableTreeMap.put("e" ,15);
        System.out.println(navigableTreeMap);

        System.out.println("Navigable ceiling key ::: "+navigableTreeMap.ceilingKey("bb"));
        System.out.println("Navigable ceiling entry ::: "+navigableTreeMap.ceilingEntry("b"));
        System.out.println("Navigable ceiling entry::: "+navigableTreeMap.ceilingEntry("a").getValue());

        System.out.println("Navigable floor key ::: "+navigableTreeMap.floorKey("bbbb"));
        System.out.println("Navigable floor entry ::: "+navigableTreeMap.floorEntry("b"));
        System.out.println("Navigable floor entry::: "+navigableTreeMap.floorEntry("a").getValue());

        //high, lower
        System.out.println("Navigable higherKey key ::: "+navigableTreeMap.higherKey("bbbb"));
        System.out.println("Navigable lowerKey key ::: "+navigableTreeMap.lowerKey("bbbb"));

        //first, last
        System.out.println("Navigable firstKey::: "+navigableTreeMap.firstKey());
        System.out.println("Navigable firstEntry ::: "+navigableTreeMap.firstEntry());
        System.out.println("Navigable pollFirstEntry::: "+navigableTreeMap.pollFirstEntry());

        System.out.println("Navigable pollLastEntry ::: "+navigableTreeMap.pollLastEntry());
        System.out.println("Navigable lastEntry ::: "+navigableTreeMap.lastEntry()); //give the key override value of e at line 19
        System.out.println("Navigable lastKey ::: "+navigableTreeMap.lastKey()); //give the key override value of e at line 19


        System.out.println("Navigable lastKey ::: "+navigableTreeMap.pollLastEntry()); //give the key override value of e at line 19
        System.out.println(navigableTreeMap);

        //headset and trail set
        System.out.println("Navigable headMap::: "+navigableTreeMap.headMap("c"));
        System.out.println("Navigable tailMap::: "+navigableTreeMap.tailMap("c"));
    }
}
