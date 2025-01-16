package lambda;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfacesExample {

    //Function
    static  Function<String, Integer> stringIntegerFunction = (String value) -> value.length();
    //Method Ref
    static Function<String, Integer> methodRef = String::length;

    static  Function<Integer, Integer> func2 = x -> x * 2;


    /// By Function
    // takes two Integers and return an Integer
    static BiFunction<Integer, Integer, Integer> byFunc = (x1, x2) -> x1 + x2;

    // take two Integers and return an Double
    static BiFunction<Integer, Integer, Double> func3 = Math::pow;

    // take two Integers and return a List<Integer>
    static BiFunction<Integer, Integer, List<Integer>> func4 = (x1, x2) -> Arrays.asList(x1 + x2);

    // Math.pow(a1, a2) returns Double
    static BiFunction<Integer, Integer, Double> func5 = (a1, a2) -> Math.pow(a1, a2);

    // takes Double, returns String
    static Function<Double, String> func6 = (input) -> "Result : " + String.valueOf(input);


    /// Supplier -  it takes no arguments and returns a result.
    static Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();

    /// Consumer is a functional interface; it takes an argument and returns nothing.
    static Consumer<String> consumerPrint = System.out::println;

    /// BiConsumer is a functional interface; it takes two arguments and returns nothing.
    static BiConsumer<Integer, Integer> biConsumerAddTwo = (x, y) -> System.out.println(x + y);


    ///Predicate is a functional interface, which accepts an argument and returns a boolean. Usually, it used to apply in a filter for a collection of objects.
    static Predicate<Integer> noGreaterThan5 =  x -> x > 5;

    /// BiPredicate is a functional interface, which accepts two arguments and returns a boolean,
    static BiPredicate<String, Integer> filter = (x, y) -> {
        return x.length() == y;
    };

    ///The BinaryOperator takes two arguments of the same type and returns a result of the same type of its arguments.

    public static void main(String[] args) {
        System.out.println(stringIntegerFunction.apply("Random Text"));
        System.out.println(methodRef.apply("Random Text : New"));

        //add then
        System.out.println(stringIntegerFunction.andThen(func2).apply("Random World"));


        /// ByFunction
        System.out.println(byFunc.apply(21, 22));
        System.out.println(func3.apply(11, 2));

        System.out.println(func4.apply(11, 2));
        System.out.println(func5.andThen(func6).apply(2, 4));


        /// supplier
        LocalDateTime time = supplier.get();
        System.out.println("Supplier ::"+time);

        //consumer
        consumerPrint.accept("Consumer value no O/P");

        biConsumerAddTwo.accept(1, 2);

        //Predicate
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());

        System.out.println(collect); // [6, 7, 8, 9,

        //Predicate.and() - multiple filters
        List<Integer> collect2 = list.stream()
                .filter(x -> x > 5 && x < 8).collect(Collectors.toList());

        System.out.println(collect2);

        //Predicate.or() - - multiple filters
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");
        List<String> listNew = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        List<String> collect4 = listNew.stream()
                .filter(lengthIs3.or(startWithA))
                .toList();

        System.out.println(collect4);

        //Predicate.negate() -
        List<String> collect5 = listNew.stream()
                .filter(startWithA.negate())
                .toList();
        System.out.println(collect5);


        /// Predicate Chaining
        Predicate<String> startWithSmallA = x -> x.startsWith("a");

        // start with "a" or "m"
        boolean result = startWithSmallA.or(x -> x.startsWith("m")).test("mkyong");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithSmallA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);// false

        /// BiPredicate
        boolean resultNew = filter.test("mkyong", 6);
        System.out.println(resultNew);  // true

        boolean result2New = filter.test("java", 10);
        System.out.println(result2New);


        //bioperator take bi function but it should be of same time unlike bi-function can be anytype
        BiFunction<Integer, String, String> func = (x1, x2) -> String.valueOf(x1 + Integer.valueOf(x2));

        String results = func.apply(2, "3");

        System.out.println(results); // 5

        // BinaryOperator
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;

        Integer results2 = func2.apply(2, 3);

        System.out.println("BiOperator" + results2); // 5
    }
}

