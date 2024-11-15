package module11;

import java.util.stream.IntStream;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 */
class FizzBuzzStreamAPI {
    public static void main(String[] args) {
        int n = 100;
        IntStream.range(0, n)
                .mapToObj(FizzBuzzStreamAPI::fizzBuzz)
                .forEach(System.out::println);
    }

    private static String fizzBuzz(int i) {
        String result = "";

        if (i % 3 == 0) result += "Fizz";
        if (i % 3 == 0) result += "Buzz";
        if (result.isBlank()) result += i;

        return result;
    }
}
