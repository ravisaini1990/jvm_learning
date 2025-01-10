package thread;

public class DeadLockExample {

    public static void main(String[] args) {
        String lock1 ="T1";
        String lock2 = "T2";

        Thread t1= new Thread(() ->{
            synchronized (lock1) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Lock Acquired by T1");
                }
            }

        }, "First");


        Thread t2= new Thread(() ->{
            synchronized (lock2) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Lock Acquired by T2");
                }
            }

        }, "Second");

        t1.start();
        t2.start();

        System.out.println("Main Method");
    }
}
