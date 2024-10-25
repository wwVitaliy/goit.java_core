package module8.numbertransformer.splitter;

import module8.numbertransformer.Digit;

public class DigitSplitter {
    public Digit[] split(int number) {
        String[] digitsString = Integer.toString(number).split("");
        Digit[] result = new Digit[digitsString.length];

        for (int i = 0; i < digitsString.length; i++) {
           result[i] = Digit.valueOf(Integer.parseInt(digitsString[i]));
        }
        return result;
    }
}
