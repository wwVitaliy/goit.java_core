package module8.numbertransformer.output;

import module8.numbertransformer.Digit;

public class SevenSegmentDigitPrinter
        implements DigitPrinter {
    private static final int RAWS_TO_PRINT = 5;

    private static final String[][] SEGMENTS_FOR_NUMBERS =
            {
                    {" === ", "|| ||", "|| ||", "|| ||", " === "},  //0
                    {"   /|", "  /||", "   ||", "   ||", "   ||"},  //1
                    {" === ", "   ||", " === ", "||   ", " === "},  //2
                    {" === ", "   ||", " === ", "   ||", " === "},  //3
                    {"|| ||", "|| ||", " === ", "   ||", "   ||"},  //4
                    {" === ", "||   ", " === ", "   ||", " === "},  //5
                    {" === ", "||   ", " === ", "|| ||", " === "},  //6
                    {" === ", "   ||", "   ||", "   ||", "   ||"},  //7
                    {" === ", "|| ||", " === ", "|| ||", " === "},  //8
                    {" === ", "|| ||", " === ", "   ||", " === "},  //9
            };

    @Override
    public void print(Digit[] digits) {

        for (int i = 0; i < RAWS_TO_PRINT; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < digits.length; j++) {
                stringBuilder.append(SEGMENTS_FOR_NUMBERS[digits[j].getValue()][i]);
                if (j < digits.length - 1) stringBuilder.append(" ");
            }
            System.out.println(stringBuilder);
        }
    }
}
