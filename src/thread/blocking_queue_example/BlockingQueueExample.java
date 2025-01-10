package thread.blocking_queue_example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Multithreaded Queue
 * O/p - Adding >> 0
 * Removing >> 0
 * Adding >> 1
 * Removing >> 1
 * Adding >> 2
 * Removing >> 2
 * Adding >> 3
 * Removing >> 3
 * Adding >> 4
 * Removing >> 4
 * Adding >> 5
 * Removing >> 5
 * Adding >> 6
 * Removing >> 6
 * Adding >> 7
 * Removing >> 7
 * Adding >> 8
 * Removing >> 8
 * Adding >> 9
 * Removing >> 9
 * Adding >> 10
 * Removing >> 10
 * Adding >> 11
 * Removing >> 11
 * Adding >> 12
 * Removing >> 12
 * Adding >> 13
 * Removing >> 13
 * Adding >> 14
 * Removing >> 14
 * Adding >> 15
 * Removing >> 15
 * Adding >> 16
 * Removing >> 16
 * Adding >> 17
 * Removing >> 17
 * Adding >> 18
 * Removing >> 18
 * Adding >> 19
 * Removing >> 19
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(2);

        new Thread(() -> {
            for (int i=0; i<20 ; i++) {
                blockingQueue.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "T1").start();

        new Thread(() -> {
            for (int i=0; i<20 ; i++) {
                blockingQueue.remove();
            }
        }, "T2").start();
    }
}

class BlockingQueue {
    private final Queue<Integer> queue;
    private final int capacity;


    public BlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int item) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Adding >> "+item);
            queue.add(item);
            queue.notifyAll();
            return true;
        }

    }

    public int remove() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int element = queue.poll();
            System.out.println("Removing >> "+element);
            queue.notifyAll();
            return element;
        }

    }
}
