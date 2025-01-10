package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * remove(), removeAll() and clear()
 */
public class RemoveFromList {

    public static void main(String[] args) {
        List<Integer> userIds = new ArrayList<>();

        userIds.add(201);
        userIds.add(204);
        userIds.add(205);
        userIds.add(207);
        userIds.add(208);
        userIds.add(209);

        //remove from index
        userIds.remove(2);
        System.out.println(userIds);

        //remove specific object i.e INTEGER
        userIds.remove(Integer.valueOf(201));
        System.out.println(userIds);

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.remove("Apple");
        System.out.println("Remove object ::" +fruits);


        //removeAll
        List<Integer> subUserIds = new ArrayList<>();
        subUserIds.add(208);
        userIds.removeAll(subUserIds);

        System.out.println("Remove all ::: "+userIds);

        //clear
        userIds.clear();
        System.out.println(userIds);
        System.out.println("Is List Empty ::"+userIds.isEmpty());
    }
}
