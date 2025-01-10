package collection;

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


        //via addall
        List<Integer> newUsers = new ArrayList<>();
        newUsers.add(202);
        newUsers.add(208);

        userIds.addAll(newUsers);
        System.out.println(userIds);

    }
}
