package thread;

/**
 * O/p - RUNNABLE
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TIMED_WAITING
 * TERMINATED
 */
public class ThreadState {

    public static void main(String[] args) {

       Thread stateThread = new Thread(() -> {

            try {
                Thread.sleep(1);

                for(int i = 4; i>0; i--);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "States");

        stateThread.start();

        while (true) {
            Thread.State state = stateThread.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED) break;
        }

    }
}
