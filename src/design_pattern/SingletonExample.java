package design_pattern;

public class SingletonExample {

    private static  volatile  SingletonExample singletonExample = null;

    private SingletonExample() {
        System.out.println("SingletonExample Constructor");
    }


    public static SingletonExample getInstance() {
        if(singletonExample == null) {
            synchronized (SingletonExample.class) {
                if (singletonExample == null) {
                    singletonExample = new SingletonExample();
                }
            }
        }
        return  singletonExample;
    }
}


