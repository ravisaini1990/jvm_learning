package thread;

/**
 * Thread Join
 */
public class ThreadJoin {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread >> "+Thread.currentThread());
        } , "Thread1");

        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread Exit");
    }
}
