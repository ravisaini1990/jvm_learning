package collection.linkedlist;

import java.util.*;

/**
 * Linked list either via list or queue
 */
public class LinkedListPractice {
    public static void main(String[] args) {

        //combined method of list and queue
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Kiwi");
        fruits.add("Grapes");

        fruits.offer("Guvava");
        fruits.offer("Blueberry");
        System.out.println(fruits);

        //queue specific method
        Queue<String> fruitsQueue = new LinkedList<>();
        fruitsQueue.offer("Mango");
        fruitsQueue.offer("Strawberry");
        fruitsQueue.offer("Apple");
        fruitsQueue.offer("Orange");

        System.out.println("Queue Peek :: >" + fruitsQueue.peek());
        System.out.println("Queue :: >" + fruitsQueue);

        System.out.println("Queue poll :: >" + fruitsQueue.poll());
        System.out.println("Queue :: >" + fruitsQueue);

        System.out.println("Queue size :: >" + fruitsQueue.size());
        System.out.println("Queue element :: >" + fruitsQueue.element()); //error of queue empty
        System.out.println("Queue contain :: >" + fruitsQueue.contains("Orange")); //return -1 , since its not present
        System.out.println("Queue remove :: >" + fruitsQueue.remove("Apple")); //return 1 , since its topmost
        System.out.println("Queue size :: >" + fruitsQueue.size()); //r

        Queue<String> fruitsQueueReverse = new PriorityQueue<>(Comparator.naturalOrder());
        fruitsQueueReverse.offer("Mango");
        fruitsQueueReverse.offer("Strawberry");
        fruitsQueueReverse.offer("Apple");
        fruitsQueueReverse.offer("Orange");
        System.out.println("reverse >>> " + fruitsQueueReverse);

        //linked list - list specific method
        List<String> fruitsLinkedList = new LinkedList<>();
        fruitsLinkedList.add("Mango");
        fruitsLinkedList.add("Strawberry");

        System.out.println(fruitsLinkedList);
    }
}
