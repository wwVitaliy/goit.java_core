package module12.homework;

/**
 * Завдання 1
 * Напишіть програму, яка кожну секунду відображає на екрані дані про час, що минув від моменту запуску програми.
 * <p>
 * Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.
 */

import java.util.concurrent.atomic.AtomicLong;

/**
 * Prints each second how much time have passed since the program started.
 * Prints each 5 second message "5 seconds past"
 */
class Task1 {
    public static void main(String[] args) {

        //  Prints each second how much time have passed since the program started.
        new Thread(() -> {  //  create new Thread
            long seconds = 0L;  //  initialize variable to count seconds
            while (true) {  //  infinite cycle
                System.out.println("seconds = " + seconds); //  Print seconds
                try {
                    Thread.sleep(1000); //  wait
                    seconds++;  //  increment seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start(); //  start thread

        //  Prints each 5 second message "5 seconds past"
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); //  wait
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("5 seconds past");   // print message
            }
        }).start();
    }
}
