package module12.homework;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Завдання 2
 * Напишіть програму, що виводить в консоль рядок,
 * що складається з чисел від 1 до n, але з заміною деяких значень:
 *
 * якщо число ділиться на 3 - вивести fizz
 * якщо число ділиться на 5 - вивести buzz
 * якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
 * Наприклад, для n = 15, очікується такий результат:
 * 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
 *
 * Програма повинна бути багатопотоковою, і працювати з 4 потоками:
 *
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

        Queue<String> queueToPrint = new ArrayDeque<>();

        // Create thread A to check if number is Fizz
        Thread threadA = new Thread(()->{

        });

        // Create thread B to check if number is Buzz
        Thread threadB = new Thread(()->{

        });

        // Create thread C to check if number is FizzBuzz
        Thread threadC = new Thread(()->{

        });

        // Create thread D to print next value
        Thread threadD = new Thread(()->{

        });

        int n = 100;
        for (int i = 0; i < n; i++) {

        }

    }

}
