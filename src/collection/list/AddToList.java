package collection.list;

import java.util.ArrayList;
import java.util.List;

public class AddToList {

    public static void main(String[] args) {
        List<Integer> userIds = new ArrayList<>();

        userIds.add(201);
        userIds.add(204);
        userIds.add(205);
        userIds.add(207);

        //add to list via constructor
        List<Integer> users = new ArrayList<>(userIds);
        System.out.println(users);

        int element = userIds.get(2);
        System.out.println("Element at index 2 :" + element);
        System.out.println("Is empty list ? " + userIds.isEmpty());

        //set item at index
        userIds.set(0, 203);
        System.out.println("updated user list >>" + userIds);

        //via addall
        List<Integer> newUsers = new ArrayList<>();
        newUsers.add(202);
        newUsers.add(208);

        userIds.addAll(newUsers);
        System.out.println(userIds);

        //will insert new element and shift existing element down , no override
        newUsers.add(1, 209);
        System.out.println(newUsers);

        //override value
        newUsers.set(1, 207);
        System.out.println(newUsers);

        System.out.println(newUsers.contains(209));
    }
}
