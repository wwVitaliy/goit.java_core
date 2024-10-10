package module4;

public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String tempString = "";
            if (i % 3 == 0) tempString += "Fizz";
            if (i % 5 == 0) tempString += "Buzz";
            System.out.println(tempString.isBlank() ? i : tempString);
        }
    }
}
