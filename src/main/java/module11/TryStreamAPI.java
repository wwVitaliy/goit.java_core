package module11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class TryStreamAPI {
    public static void main(String[] args) {


        List<String> names = List.of("John", "Bill", "Liam", "Jack");
        System.out.println("names.getFirst().toCharArray() = " + names.getFirst().toCharArray());

        names.stream().filter(name -> name.startsWith("J"))
                .peek(System.out::println)
                .map(name -> name.toCharArray())
                .peek(System.out::println)

                .count();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 2, 65, 3, 7, 100, 9, 5, 8, 1);

        numbers.stream()
                .min((x,y) -> x - y);

    }

}
