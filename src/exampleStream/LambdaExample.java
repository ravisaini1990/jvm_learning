package exampleStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExample {


    public static void main(String[] args) {

        //Stream.reduce() combine elements of a stream and produces a single value.
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);

        int sum1 = Arrays.stream(numbers).reduce(0, Integer::sum);

        System.out.println("sum : " + sum +" OR " + sum1); // 5


        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //  flatMap to convert the above 2 levels Stream into one Stream level or a 2d array into a 1d array.
        String[] result = Stream.of(array)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);    // [a, b, c, d, e, f]

        for (String s : result) {
            System.out.println(s);
        }


        String[][] array2 = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array2)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a
                .toList();      // return a List

        collect.forEach(System.out::println);


        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);


        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);

        dummyValues.forEach((key,value) -> System.out.println(key+"-"+value));
    }
}
