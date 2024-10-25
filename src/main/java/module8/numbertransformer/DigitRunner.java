package module8.numbertransformer;

import module8.numbertransformer.input.KeyboardNumberReader;
import module8.numbertransformer.output.SevenSegmentDigitPrinter;
import module8.numbertransformer.splitter.DigitSplitter;

public class DigitRunner {

    public static void main(String[] args) {

        System.out.println("Enter a number:");
        int numberToPrint = 0;
        try {
            numberToPrint = readNumber();
        } catch (Exception e) {
            System.out.println("Try again");
        }
        Digit[] digits = new DigitSplitter().split(numberToPrint);
        new SevenSegmentDigitPrinter().print(digits);
    }

    private static int readNumber() {
        return new KeyboardNumberReader().readNumber();
    }
}
