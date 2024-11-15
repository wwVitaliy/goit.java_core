package module11.homework;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Завдання 3
 * Є масив:
 * <p>
 * ["1, 2, 0", "4, 5"]
 * <p>
 * Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,, наприклад:
 * <p>
 * "0, 1, 2, 4, 5"
 */

/**
 * Splits each element of string array to numbers and creates a string of sorted received numbers.
 */
class Task3 {
    public static void main(String[] args) {
        //  create an array of strings
        String[] array = new String[]{"1, 2, 0", "4, 5"};

        String sortedNumbers = Arrays.stream(array) //  create a stream from array
                .map(elem -> elem.split(", "))  //  split each element to a numbers and get Stream<String[]>
                .flatMap(Arrays::stream)    //  convert each element to stream and flat the nested streams
                .sorted()   //  sort element
                .collect(Collectors.joining(", ")); // join all elements to a string with delimiter

        System.out.println("sortedNumbers = " + sortedNumbers);

        String sortedNumbers2 = Arrays.stream(array)    //  create a stream from array
                .flatMap(elem -> Arrays.stream(elem.split(", ")))   //  convert each element to stream and flat the nested streams
                .sorted()   //  sort element
                .collect(Collectors.joining(", ")); // join all elements to a string with delimiter

        System.out.println("sortedNumbers2 = " + sortedNumbers2);

    }
}
