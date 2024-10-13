package module7;

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

        long startMillis;
        int limit = 100000;
        String string = new String();
        StringBuilder stringBuilder = new StringBuilder();

        startMillis = System.currentTimeMillis();
        for (int i = 0; i < limit; i++) {
            string += i;
        }
        System.out.println("TimeString: " + (System.currentTimeMillis() - startMillis));

        startMillis = System.currentTimeMillis();
        for (int i = 0; i < limit; i++) {
            stringBuilder.append(i);
        }
        System.out.println("TimeStringBuilder: " + (System.currentTimeMillis() - startMillis));

        //String pool
        String someVar = "Hello";
        String anotherVar = "Hello";
        String newVar = new String("Hello");

        System.out.println("someVar.equals(anotherVar) = " + someVar.equals(anotherVar));
        System.out.println("someVar.equals(newVar) = " + someVar.equals(newVar));
        System.out.println("someVar == anotherVar = " + someVar == anotherVar);
        System.out.println("someVar == newVar = " + someVar == newVar);

    }
}
