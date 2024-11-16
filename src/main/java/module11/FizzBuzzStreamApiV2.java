package module11;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 */
class FizzBuzzStreamApiV2 {
    public static void main(String[] args) {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }

        Stream.iterate(0, i -> i + 1)
                .map(FizzBuzzStreamApiV2::intToFizzBuzz)
                .limit(n)
                .forEach(System.out::println);
    }

    private static String intToFizzBuzz(Integer integer) {
        String result = "";
        if (integer % 3 == 0) result += "Fizz";
        if (integer % 5 == 0) result += "Buzz";
        return result.isBlank() ? String.valueOf(integer) : result;
    }
}
