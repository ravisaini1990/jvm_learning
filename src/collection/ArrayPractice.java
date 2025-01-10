package collection;

import java.util.Arrays;

public class ArrayPractice {

    public static void main(String[] args) {
        Integer[] numbers = new Integer[5];
        numbers[0]= 0;
        numbers[1]= 1;
        numbers[2]= 2;
        numbers[3]= 3;
        numbers[4]= 4;

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        Integer[] emptyArray = new Integer[5];
        System.out.println(Arrays.toString(emptyArray));
        Arrays.fill(emptyArray, -1);
        System.out.println(Arrays.toString(emptyArray));

        System.out.println(Arrays.binarySearch(numbers, 4));

    }
}
