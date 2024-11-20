package module12.homework.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintFizzBuzz {
    private final ExecutorService printer;
    private int counter;

    public PrintFizzBuzz() {
        this.printer = Executors.newSingleThreadExecutor();
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void addToPrint(String s) {
        this.printer.execute(() -> System.out.println(s));
        this.counter++;
    }

    public void close() {
        this.printer.close();
    }
}
