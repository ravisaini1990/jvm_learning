package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        /*ExecutorService threadPool = Executors.newFixedThreadPool(3);

        System.out.println(Thread.currentThread().getName()+" Start. Command");
        for (int i = 0 ; i< 7; i ++) {
            threadPool.submit(Processor::new);
        }

        threadPool.shutdown();
        System.out.println(Thread.currentThread().getName()+" End.");*/

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new Processor();
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }
}


class  Processor implements  Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" Start");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" Ended");

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
