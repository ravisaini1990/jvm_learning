package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Duplicate and null element in list
 */
public class ListDemo {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(5);

        stringList.add("element1");
        stringList.add("element1");
        stringList.add("element2");
        stringList.add("element1");

        System.out.println(stringList);

        /*
         Adding this line will give error - Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 10, Size: 4
         **/
        //stringList.add(10, "element10");

        stringList.add(null);

        System.out.println(stringList.get(1));

        String elementRemoved = stringList.remove(1);
        System.out.println("removed this element : "+elementRemoved);

    }
}
