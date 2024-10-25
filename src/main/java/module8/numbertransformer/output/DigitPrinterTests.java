package module8.numbertransformer.output;

import module8.numbertransformer.Digit;

public class DigitPrinterTests {
    public static void main(String[] args) {
        DigitPrinter digitPrinter = new SevenSegmentDigitPrinter();

        digitPrinter.print(
                new Digit[]{
                        Digit.one,
                        Digit.two,
                        Digit.three,
                        Digit.four,
                        Digit.five,
                        Digit.six,
                        Digit.sever,
                        Digit.eight,
                        Digit.nine
                }
        );

        Digit[] oneDigitNumber = new Digit[1];
        for (Digit value : Digit.values()) {
            oneDigitNumber[0] = value;
            digitPrinter.print(oneDigitNumber);
        }

    }
}
