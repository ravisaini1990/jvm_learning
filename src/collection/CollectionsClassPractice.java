package collection;

import java.util.*;

public class  CollectionsClassPractice {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(34);
        integerList.add(134);
        integerList.add(4);
        integerList.add(13);
        integerList.add(302);
        integerList.add(54);

        System.out.println(integerList);

        Collections.sort(integerList);
        System.out.println("Sort"+ integerList);

        integerList.sort(Comparator.reverseOrder());
        System.out.println("reverse sort"+integerList);

        //Custom Object sorting
        List<User> users = new ArrayList<>();
        users.add(new User("Ramesh", 12));
        users.add(new User("Jay", 2111));
        users.add(new User("Abdul", 11));
        users.add(new User("Jimmy", 102));
        System.out.println("User No sort"+ users);

        Collections.sort(users);

        System.out.println("Frequency of element > "+ Collections.frequency(users, new User("Abdul 9", 11)));

        System.out.println("User Sorted"+ users);

        users.sort((o1, o2) -> o2.userName.compareTo(o1.userName));
        System.out.println("User Sorted Comparator 1 reversed"+ users);
        //or
        users.sort(Comparator.comparing(o -> o.userName));
        System.out.println("User Sorted Comparator "+ users);
    }
}

class  User implements Comparable<User> {
    String userName;
    int userId;

    User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(userName, user.userName) && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userId);
    }

    @Override
    public int compareTo(User that) {
        return this.userId - that.userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
