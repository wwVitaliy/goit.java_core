package module11.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Завдання 5
 * Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
 * який "перемішує" елементи зі стрімів first та second,
 * зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.
 */

/**
 * Shuffles elements from two streams one by one until one of the streams is run out of elements.
 */
class Task5 {
    public static void main(String[] args) {
        List<String> first = Arrays.asList("Ivan", "Taras", "Peter", "Andrii", "Pavlo");
        List<String> second = Arrays.asList("1", "2", "3");

        zip(first.stream(), second.stream())
                .peek(System.out::println)
                .toList();
    }

    /**
     * Shuffles elements from two streams one by one until one of the streams is run out of elements.
     *
     * @param firstStream  First stream to shuffle
     * @param secondStream Second stream to shuffle
     * @return Stream of shuffled equal quantity of elements from two streams
     */
    public static <T> Stream<T> zip(Stream<T> firstStream, Stream<T> secondStream) {
        Iterator<T> firstIterator = firstStream.iterator();
        Iterator<T> secondIterator = secondStream.iterator();

        Stream<T> result = Stream.empty();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result = Stream.concat(result, Stream.of(firstIterator.next()));
            result = Stream.concat(result, Stream.of(secondIterator.next()));
        }

        return result;
    }
}
