package thread.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class TaskScheduler implements ITaskScheduler {

    int maximumTaskAllowed;
    List<Task> tasks;
    ExecutorService executor;
    ReentrantLock reentrantLock;

    TaskScheduler(int threadCount) {
        this.maximumTaskAllowed = threadCount;
        tasks = new ArrayList<>();
        executor = Executors.newFixedThreadPool(maximumTaskAllowed);
        reentrantLock = new ReentrantLock(true);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void runTasks() {
        for (int i = 0; i < maximumTaskAllowed; i++) {
            executor.execute(() -> {
                while (true) {
                    reentrantLock.lock();
                    try {
                        if (!tasks.isEmpty()) {
                            Task t = tasks.removeLast();
                            Thread.sleep(10);
                            System.out.println("Running task : " + t.getTaskName() +" on Thread"+Thread.currentThread().getName());
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    finally {
                        reentrantLock.unlock();
                    }
                }
            });
        }
    }

    @Override
    public void shutdown() {
        executor.shutdown();
    }
}

interface ITaskScheduler {

    void addTask(Task task);

    void runTasks();

    void shutdown();
}

class Task {

    Task(String taskName) {
        this.taskName = taskName;
    }

    String taskName;

    public String getTaskName() {
        return taskName;
    }
}