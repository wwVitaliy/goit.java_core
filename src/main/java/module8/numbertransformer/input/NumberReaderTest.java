package module8.numbertransformer.input;

public class NumberReaderTest {
    public static void main(String[] args) {
        NumberReader numberReader = new KeyboardNumberReader();
        System.out.println("numberReader.readNumber() = " + numberReader.readNumber());
    }
}
