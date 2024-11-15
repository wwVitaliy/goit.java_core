package module11.homework;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Завдання 1
 * Метод приймає на вхід список імен.
 * Необхідно повернути рядок вигляду 1. Ivan, 3. Peter... лише з тими іменами,
 * що стоять під непарним індексом (1, 3 тощо)
 */

/**
 * Creates a string with order numbers and names from the odd positions of names in list.
 */
class Task1 {

    public static void main(String[] args) {
        //  Create a list of names
        List<String> names = List.of("John", "Bill", "Liam", "Jack");

        //  Get all names on odd positions as a string with delimiter
        String oddNames = getOddNumberNamesAsString(names, ", ");

        //  Print string with all names on odd positions as a string with delimiter
        System.out.println("oddNames = " + oddNames);
    }

    /**
     * creates a string with order numbers and names from the odd positions of names in list.
     * @param names a list of names
     * @param delimiter a delimiter to separate names in string of names
     * @return a string with order numbers and names from the odd positions of names in list.
     */
    private static String getOddNumberNamesAsString(List<String> names, String delimiter) {

//        return IntStream.range(0, names.size())  //  Create a stream of numbers
//                .filter(index -> index % 2 == 0)    //  Keep only odd numbers
//                .mapToObj(index -> index + ". " + names.get(index)) //  Add a name from names
//                .collect(Collectors.joining(delimiter));    //  Join all elements from stream with delimiter

        return names.stream()   //  create string of names
                .filter(name -> names.indexOf(name) % 2 == 0)   // filter odd elements only
                .map(name -> names.indexOf(name) + ". " + name) //  add order number to each element
                . collect(Collectors.joining(delimiter));   //  collect as string with delimiter
    }
}
