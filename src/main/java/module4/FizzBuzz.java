package module4;

public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String fizzBuzz = "";
            if (i % 3 == 0) fizzBuzz += "Fizz";
            if (i % 5 == 0) fizzBuzz += "Buzz";
            System.out.println(fizzBuzz.isBlank() ? i : fizzBuzz);
        }
    }
}
