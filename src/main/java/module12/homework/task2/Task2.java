package module12.homework.task2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Завдання 2
 * Напишіть програму, що виводить в консоль рядок,
 * що складається з чисел від 1 до n, але з заміною деяких значень:
 * <p>
 * якщо число ділиться на 3 - вивести fizz
 * якщо число ділиться на 5 - вивести buzz
 * якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
 * Наприклад, для n = 15, очікується такий результат:
 * 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
 * <p>
 * Програма повинна бути багатопотоковою, і працювати з 4 потоками:
 * <p>
 * Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3,
 * і якщо так - додати в чергу на виведення для потоку D рядок fizz.
 * Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5,
 * і якщо так - додати в чергу на виведення для потоку D рядок buzz.
 * Потік C викликає fizzbuzz(), щоб перевірити, чи ділиться число на 3 та 5 одночасно,
 * і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.
 * Потік D викликає метод number(), щоб вивести наступне число з черги, якщо є таке число для виведення.
 */
class Task2 {
    public static void main(String[] args) {
        // number to check to
        int n = 20;
        // create new printer executor
        PrintFizzBuzz printFizzBuzz = new PrintFizzBuzz();
        // number of checks
        AtomicInteger checks = new AtomicInteger(0);

        // fizz thread
        ProcessThread fizz = new ProcessThread((num) -> {
            checks.incrementAndGet();
            if (num % 3 == 0) {
                printFizzBuzz.addToPrint(Thread.currentThread().getName() + " ---> " + num + " Fizz");
            }
        });

        // buzz thread
        ProcessThread buzz = new ProcessThread((num) -> {
            checks.incrementAndGet();
            if (num % 5 == 0) {
                printFizzBuzz.addToPrint(Thread.currentThread().getName() + " ---> " + num + " Buzz");
            }
        });

        // fizzBuzz thread
        ProcessThread fizzBuzz = new ProcessThread((num) -> {
            if (num % 3 == 0 && num % 5 == 0) {
                printFizzBuzz.addToPrint(Thread.currentThread().getName() + " ---> " + num + " FizzBuzz");
                checks.set(3);
            } else {
                checks.incrementAndGet();
                fizz.checkNumber(num);
                buzz.checkNumber(num);
            }
        });

        // set threads as daemon so the program will be finished after all checks
        fizz.setDaemon(true);
        buzz.setDaemon(true);
        fizzBuzz.setDaemon(true);

        // start all threads
        fizz.start();
        buzz.start();
        fizzBuzz.start();

        // check numbers
        for (int i = 1; i <= n; i++) {
            checks.set(0);
            fizzBuzz.checkNumber(i);

            // wait until all checks will be done
            while(checks.get() < 3){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // print raw number if nothing was printed
            if (printFizzBuzz.getCounter() < i) {
                printFizzBuzz.addToPrint(Thread.currentThread().getName() + " ---> " + i);
            }
        }

        // close printer
        printFizzBuzz.close();
    }
}
