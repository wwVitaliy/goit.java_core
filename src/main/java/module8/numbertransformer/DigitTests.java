package module8.numbertransformer;

import java.util.Arrays;

public class DigitTests {
    public static void main(String[] args) {
        System.out.println("Digit.one.name() = " + Digit.one.name());

        System.out.println("Digit.valueOf(\"nine\") = " + Digit.valueOf("nine"));

        System.out.println("Digit.one.ordinal() = " + Digit.one.ordinal());

        System.out.println("Digit.values() = " + Arrays.toString(Digit.values()));
    }
}
