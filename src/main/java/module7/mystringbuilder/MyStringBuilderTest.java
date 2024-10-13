package module7.mystringbuilder;

public class MyStringBuilderTest {
    public static void main(String[] args) {

        MyStringBuilder myStringBuilder = new MyStringBuilder();
        myStringBuilder.append("Hello");
        myStringBuilder.append(" ");
        myStringBuilder.append("world");
        myStringBuilder.append("!");

        System.out.println("myStringBuilder = " + myStringBuilder);
        myStringBuilder.clear();
        System.out.println("myStringBuilder = " + myStringBuilder);

        System.out.println("==========================");

        MyStringBuilder myStringBuilder2 = new MyStringBuilder();
        String myString = "";
        StringBuilder stringBuilder = new StringBuilder();
        long startMillis;
        int limit = 100000;

        //StringBuilder test
        startMillis = System.currentTimeMillis();

        for (int i = 0; i < limit; i++) {
            stringBuilder.append(i);
        }

        System.out.println("Time StringBuilder: " + (System.currentTimeMillis() - startMillis));

        //MyStringBuilderTest
        startMillis = System.currentTimeMillis();

        for (int i = 0; i < limit; i++) {
            myStringBuilder2.append(String.valueOf(i));
        }

        System.out.println("Time MyStringBuilder: " + (System.currentTimeMillis() - startMillis));

        //StringTest
        startMillis = System.currentTimeMillis();

        for (int i = 0; i < limit; i++) {
            myString += i;
        }

        System.out.println("Time String: " + (System.currentTimeMillis() - startMillis));


    }
}
