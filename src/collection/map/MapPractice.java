package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapPractice {
    public static void main(String[] args) {

        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);

        System.out.println(numbers);

        if(!numbers.containsKey("Three")) {
            numbers.put("Three", 3);
        }

        if(!numbers.containsKey("Four")) {
            numbers.putIfAbsent("Four", 4);
        }
        System.out.println(numbers);

        //iteration

        for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
            System.out.println("Key :"+entry.getKey());
            System.out.println("Valeu :"+entry.getValue());
        }

        System.out.println(numbers.containsKey("Three"));
        System.out.println(numbers.containsValue(4));


        //TreeMap - sorting on key bases
        Map<String, Integer> integerTreeMap = new TreeMap<>();

        integerTreeMap.put("One", 1);
        integerTreeMap.put("Second", 2);
        integerTreeMap.put("Three", 3);
        integerTreeMap.put("Four", 4);
        System.out.println("TreeMap >>> "+integerTreeMap);

        integerTreeMap.remove("Two");
        System.out.println(integerTreeMap);
    }
}
