package thread.scheduler;

/**
 * O/p - Running task : Task14 on Threadpool-1-thread-1
 * Running task : Task13 on Threadpool-1-thread-2
 * Running task : Task12 on Threadpool-1-thread-3
 * Running task : Task11 on Threadpool-1-thread-4
 * Running task : Task10 on Threadpool-1-thread-5
 * Running task : Task9 on Threadpool-1-thread-6
 * Running task : Task8 on Threadpool-1-thread-7
 * Running task : Task7 on Threadpool-1-thread-8
 * Running task : Task6 on Threadpool-1-thread-9
 * Running task : Task5 on Threadpool-1-thread-10
 * Running task : Task4 on Threadpool-1-thread-1
 * Running task : Task4 on Threadpool-1-thread-2
 * Running task : Task3 on Threadpool-1-thread-3
 * Running task : Task2 on Threadpool-1-thread-4
 * Running task : Task1 on Threadpool-1-thread-5
 */
public class TaskSchedulerExample {

    public static void main(String[] args) {

        TaskScheduler taskScheduler = new TaskScheduler(Runtime.getRuntime().availableProcessors());

        taskScheduler.addTask(new Task("Task1"));
        taskScheduler.addTask(new Task("Task2"));
        taskScheduler.addTask(new Task("Task3"));
        taskScheduler.addTask(new Task("Task4"));
        taskScheduler.addTask(new Task("Task4"));
        taskScheduler.addTask(new Task("Task5"));
        taskScheduler.addTask(new Task("Task6"));
        taskScheduler.addTask(new Task("Task7"));
        taskScheduler.addTask(new Task("Task8"));
        taskScheduler.addTask(new Task("Task9"));
        taskScheduler.addTask(new Task("Task10"));
        taskScheduler.addTask(new Task("Task11"));
        taskScheduler.addTask(new Task("Task12"));
        taskScheduler.addTask(new Task("Task13"));
        taskScheduler.addTask(new Task("Task14"));

        taskScheduler.runTasks();
        taskScheduler.shutdown();
    }
}
