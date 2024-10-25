package module8.numbertransformer.splitter;

import java.util.Arrays;

public class DigitSplitterTests {
    public static void main(String[] args) {

        DigitSplitter digitSplitter = new DigitSplitter();

        System.out.println("Arrays.toString(\ndigitSplitter.split(157)) = "
                + Arrays.toString(digitSplitter.split(157)));
    }
}
