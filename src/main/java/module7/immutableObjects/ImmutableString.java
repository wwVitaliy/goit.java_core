package module7.immutableObjects;

import java.util.Arrays;

public class ImmutableString {
    public static void main(String[] args) {

        // String is immutable
        String text = "Java";
        text.toUpperCase(); // text will not be changed
        String newText = text.toUpperCase(); // new String is created
        System.out.println("text = " + text);
        System.out.println("newText = " + newText);

        System.out.println("======================");

        //String <=> byte[]
        byte[] bytes = {74, 97, 118, 97};
        System.out.println("bytes = " + Arrays.toString(bytes));
        String fromBytes = new String(bytes);
        System.out.println("fromBytes = " + fromBytes);

        byte[] fromString = fromBytes.getBytes();
        System.out.println("fromString = " + Arrays.toString(fromString));

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(i);
            System.out.println(stringBuilder);
        }
    }
}
