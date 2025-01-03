package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            Runnable worker = new Processor1(countDownLatch);
            executor.execute(worker);
        }
        executor.shutdown();
        System.out.println("executor = " + executor);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished all threads");
    }
}


class  Processor1 implements  Runnable {

    private final CountDownLatch countDownLatch;

    public  Processor1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" Start");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName()+" Ended");

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
