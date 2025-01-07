package thread;

/**
 * Create thread extending Thread and set Daemon example
 */
public  class RunnableExample implements   Runnable {

    @Override
    public void run() {

        for(int i=0 ; i< 5; i++) {
            System.out.println("Current Thread "+ Thread.currentThread().getName() +":" + i);
        }
    }
}

class RunnableExampleRunner {
    public static void main(String[] args) {

        System.out.println("Main Started");
        new Thread(new RunnableExample()).start();
        Thread demonThread=  new ThreadExample("Thread2");
        demonThread.setDaemon(true);
        demonThread.start();
        System.out.println("Main Ended");

    }
}
