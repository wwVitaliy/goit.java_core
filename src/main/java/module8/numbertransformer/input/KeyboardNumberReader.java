package module8.numbertransformer.input;

import java.util.Scanner;

public class KeyboardNumberReader
        implements NumberReader {

    @Override
    public int readNumber() {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        return number;
    }
}
