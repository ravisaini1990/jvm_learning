package collection.arraydequeue;

import java.util.ArrayDeque;

//Bi directional
public class ArrayDequeuePractice {

    public static void main(String[] args) {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();

        integerArrayDeque.offer(12);
        integerArrayDeque.offer(112);
        System.out.println(integerArrayDeque);

        integerArrayDeque.offerFirst(23);
        System.out.println(integerArrayDeque);
        integerArrayDeque.offerLast(13);
        System.out.println(integerArrayDeque);

        System.out.println("Peek First "+integerArrayDeque.peekFirst());
        System.out.println("Peek Last "+integerArrayDeque.peekLast());
        System.out.println("Peek "+integerArrayDeque.peek());

        integerArrayDeque.pollFirst();
        System.out.println(integerArrayDeque);

        integerArrayDeque.pollLast();
        System.out.println(integerArrayDeque);

    }
}
