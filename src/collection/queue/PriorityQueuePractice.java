package collection.queue;

import java.util.*;

/**
 * Priority queue used for implement min heap , max heap
 */
public class PriorityQueuePractice {

    public static void main(String[] args) {
        PriorityQueue<Integer> userIds = new PriorityQueue<>();
        userIds.offer(29);
        userIds.offer(202);
        userIds.offer(22);
        userIds.offer(1022);
        userIds.offer(5);
        System.out.println("priority queue : "+userIds);

        //Queue<String> fruitsQueue = new PriorityQueue<>(String::compareToIgnoreCase);
        //or
        Queue<String> fruitsQueue = new PriorityQueue<>((type1, type2) -> type2.compareToIgnoreCase(type1));
        fruitsQueue.offer("Mango");
        fruitsQueue.offer("Strawberry");
        fruitsQueue.offer("Apple");
        fruitsQueue.offer("Orange");

        System.out.println("Queue Peek :: >"+fruitsQueue.peek());
        System.out.println("Queue :: >"+fruitsQueue);

        System.out.println("Queue poll :: >"+fruitsQueue.poll());
        System.out.println("Queue :: >"+fruitsQueue);

        System.out.println("Queue size :: >"+fruitsQueue.size());
        System.out.println("Queue element :: >"+fruitsQueue.element()); //error of queue empty
        System.out.println("Queue contain :: >"+fruitsQueue.contains("Orange")); //return -1 , since its not present
        System.out.println("Queue remove :: >"+fruitsQueue.remove("Apple")); //return 1 , since its topmost
        System.out.println("Queue size :: >"+fruitsQueue.size()); //r

        Queue<String> fruitsQueueReverse = new PriorityQueue<>(Comparator.naturalOrder());
        fruitsQueueReverse.offer("Mango");
        fruitsQueueReverse.offer("Strawberry");
        fruitsQueueReverse.offer("Apple");
        fruitsQueueReverse.offer("Orange");
        System.out.println("reverse >>> "+ fruitsQueueReverse);


        //linked list
        Queue<String> fruitsLinkedList = new LinkedList<>();
        fruitsLinkedList.offer("Mango");
        fruitsLinkedList.offer("Strawberry");

        System.out.println(fruitsLinkedList);

        //dequeue list
        Queue<String> fruitsDequeueList = new ArrayDeque<>();
        fruitsDequeueList.offer("Mango");
        fruitsDequeueList.offer("Strawberry");

        System.out.println("array dequeue"+fruitsDequeueList);
    }
}
