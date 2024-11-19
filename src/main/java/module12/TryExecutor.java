package module12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class TryExecutor {
    //  Utility class of Runnable tasks for executor
    private record PrintRunnable(Object o) implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ---> " + "Object = " + this.o);
        }
    }

    //  Utility class of Callable tasks for executor
    private record SumCallable(long a, long b) implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            Thread.sleep(1000);
            return this.a + this.b;
        }
    }

    public static void main(String[] args) {
        // print name of main thread
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        // ---> Single Thread Executors
//        oneRunnableExecutor();
//        manyRunnableExecutor();
//        manyRunnableExecutorWithFutures();
//        oneCallableExecutorWithFutures();

        // ---> Fixed Thread Executor
        manyRunnableFixedThreadExecutor(10);

    }

    private static void manyRunnableFixedThreadExecutor(int threadsQty) {
        // create list of Futures
        List<Future<?>> taskFutures = new ArrayList<>();

        // create FixedThread executor
        try (ExecutorService executorService = Executors.newFixedThreadPool(threadsQty)) {
            for (int i = 0; i < 100; i++) {
                Future<?> taskFuture = executorService.submit(new PrintRunnable(i));
                taskFutures.add(taskFuture);
            }
            //check tasks status
            // it has to be in twr brackets, so main-thread do not have to wait to autoclose ExecutorService
            printDoneTasksQty(taskFutures);
        }


    }

    private static void printDoneTasksQty(List<Future<?>> taskFutures) {
        while (true) {
            System.out.println(Thread.currentThread().getName()
                    + " ---> "
                    + "Done: "
                    + taskFutures.stream()
                    .filter(Future::isDone)
                    .count());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void oneCallableExecutorWithFutures() {
        // create SingleThread executor
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            // add new task as Callable and get Future object
            // Future object is long parametrized because Callable returns Long value
            Future<Long> taskFuture = executorService.submit(new SumCallable(2, 3));
            // get Callable result through get()
            System.out.println("taskFuture.get() = " + taskFuture.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void manyRunnableExecutorWithFutures() {
        // create list to save Future objects
        List<Future<?>> taskFutures = new ArrayList<>();

        // create SingleThread executor
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            for (int i = 5; i < 10; i++) {
                // add new task as runnable
                Future<?> taskFuture = executorService.submit(new PrintRunnable(i));
                // save Future objects for the task in List
                taskFutures.add(taskFuture);
            }

            //check tasks status
            // it has to be in twr brackets, so main-thread do not have to wait to autoclose ExecutorService
            printDoneTasksQty(taskFutures);

        }
    }

    private static void manyRunnableExecutor() {
        // create SingleThread executor
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            //  add many new tasks as Runnable
            for (int i = 0; i < 5; i++) {
                executorService.execute(new PrintRunnable(i));
            }
        }
    }

    private static void oneRunnableExecutor() {
        // create SingleThread executor
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            // add new task as Runnable
            executorService.execute(() -> {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

}
