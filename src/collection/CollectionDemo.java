package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//parallel sort works after 8192 element else default search quick sort
public class CollectionDemo {
    public static void main(String[] args) {

        Collection<String> stringCollection = new ArrayList<>();
        stringCollection.add("John");
        stringCollection.add("Smith");
        System.out.println(stringCollection);

        final List<String> tempCollection = new ArrayList<>();
        tempCollection.add("Joy");
        stringCollection.addAll(tempCollection);

        System.out.println(stringCollection);

        stringCollection.remove("Smith");
        System.out.println(stringCollection);

        final List<String> updatedList = stringCollection.stream().map(String::toUpperCase).toList();
        System.out.println(updatedList);

        stringCollection.clear();
        System.out.println(stringCollection);
    }
}
