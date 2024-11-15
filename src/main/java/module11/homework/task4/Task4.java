package module11.homework.task4;

/**
 * Завдання 4
 * Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел,
 * але не використовуючи Math.random().
 * <p>
 * Реалізуйте свій лінійний конгруентний генератор.
 * Для цього почніть з x[0] = seed
 * і далі кожний наступний елемент рахуйте за формулою на зразок
 * x[n + 1] = 1 (a * x[n] + c) % m
 * для коректних значень a, c, та m.
 * <p>
 * Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.
 * <p>
 * Для тесту використовуйте такі дані:
 * <p>
 * a = 25214903917
 * c = 11
 * m = 2^48 (2в степені48`)
 */

import java.util.stream.Stream;

/**
 * Creates an infinite stream of pseudo-random numbers based on next Linear congruential generator:
 * x[0] = seed
 * x[n + 1] = (a * x[n] + c) % m
 * where a, c and m are long-type numbers
 */
class Task4 {
    public static final long TEST_A = 25214903917L;
    public static final long TEST_C = 11L;
    public static final long TEST_M = (long) Math.pow(2, 48);
    public static final long TEST_SEED = 1;

    public static void main(String[] args) {
        // create new random numbers generator
        RandomNumberGenerator myGenerator = new LinearCongruentialGenerator(TEST_A, TEST_C, TEST_M, TEST_SEED);

        // create infinite stream of pseudo random numbers
        Stream.iterate(TEST_SEED, n -> myGenerator.next())
                .forEach(System.out::println);
    }
}
