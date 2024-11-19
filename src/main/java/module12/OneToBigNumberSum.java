package module12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Calculates sum of numbers from 1 to BIG_NUMBER in 1-thread way and multi-threads way.
 */
class OneToBigNumberSum {

    public static final int BIG_NUMBER = 2_000_000_000;
    public static final int THREADS_QTY = 16;

    private static class SumThread extends Thread {
        private final long start;
        private final long finish;
        private final Collection<Long> results;

        public SumThread(long start, long finish, Collection<Long> results) {
            this.start = start;
            this.finish = finish;
            this.results = results;
        }

        @Override
        public void run() {
            long result = 0;
            for (long i = start; i < finish; i++) {
                result += i;
            }
            addThreadResult(result, results);
        }
    }

    public static void main(String[] args) {

        long start;
        long result;
        long duration;

        //  1-thread way
        start = System.currentTimeMillis();
        result = oneThreadCalculation();
        duration = System.currentTimeMillis() - start;

        System.out.println("final result = " + result);
        System.out.println("duration one thread, ms = " + duration);

        //  multi-threads way
        start = System.currentTimeMillis();
        result = multiThreadsCalculation();
        duration = System.currentTimeMillis() - start;

        System.out.println("final result = " + result);
        System.out.println("duration " + THREADS_QTY + "-thread, ms = " + duration);

    }

    private static long multiThreadsCalculation() {
        long result = BIG_NUMBER;
        long step = BIG_NUMBER / THREADS_QTY;

        List<Long> results = new CopyOnWriteArrayList<>();
        List<Thread> threads = new ArrayList<>();

        long[][] borders = new long[THREADS_QTY][2];
        for (int i = 0; i < THREADS_QTY; i++) {
            borders[i][0] = i * step;
            borders[i][1] = (i + 1) * step;
        }

        for (int i = 0; i < THREADS_QTY; i++) {
            SumThread sumThread = new SumThread(borders[i][0], borders[i][1], results);
            sumThread.start();
            threads.add(sumThread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (Long l : results) {
            result += l;
        }

        return result;
    }

    public static synchronized void addThreadResult(long result, Collection<Long> collection) {
        collection.add(result);
    }

    private static long oneThreadCalculation() {
        long result = 0L;

        for (long i = 1L; i <= BIG_NUMBER; i++) {
            result += i;
        }

        return result;
    }
}

