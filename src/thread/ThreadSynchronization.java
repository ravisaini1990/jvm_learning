package thread;


/**
 * Thread class implementation using lambda , and race conditions
 */
public class ThreadSynchronization {

    public static void main(String[] args) {

        Stack stack = new Stack(5);
        new Thread(() -> {
            for (int i=0; i< 10; i++) {
                int value = stack.push(i);
                System.out.println("T2 Thread "+ value +":::" +i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } , "T1").start();


        new Thread(() -> {
            for (int i=0; i< 10; i++) {
                int value = stack.pop();
                System.out.println("T2 Thread "+ value +":::" +i);
            }
        } , "T2").start();
    }
}


class Stack  {

   int[] element;
   int capacity;
   int stackTop;

    Stack(int capacity) {
        this.element = new int[capacity];
        this.capacity = capacity;
        this.stackTop = -1;
    }

    public int push(int value) {
        if (isFull()) return value;
        stackTop++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        element[stackTop] = value;
        return value;
    }

    public  boolean isEmpty() {
        return  capacity > 0;
    }


    public  boolean isFull () {
        return  capacity == element.length -1;
    }

    public  int pop() {
        if (isEmpty()) return Integer.MIN_VALUE;
        stackTop--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int object =   element[stackTop];
        element[stackTop] = Integer.MIN_VALUE;

        return  object;
    }
}