package module11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


class LambdaTry {

    interface Printable {
        public void print(int a);
    }

    @FunctionalInterface
    interface SayableWOParam {
        public String say();
    }

    @FunctionalInterface
    interface SayableOneParam {
        public String say(String toSay);
    }

    @FunctionalInterface
    interface SayableTwoParam {
        public String say(String sayFirst, String saySecond);
    }

    public static void main(String[] args) {

//        interfaceWithoutLambda();   //  1.  Interface Without Lambda Expression
//        lambdaNoParam();
//        lambdaOneParam();
//        lambdaTwoParam();
//        lambdaComplexLogic();
//        lambdaForEach();

        //  Task1.  Write a Java program to implement a lambda expression to find the sum of two integers.
        int a = 1;
        int b = 3;
        System.out.println("task1(a, b) = " + task1(a, b));

        //  Task2.  Write a Java program to implement a lambda expression to check if a given string is empty.
        String texToCheck = " 1";
        System.out.println("task2(texToCheck) = " + task2(texToCheck));

        //  Task3.  Write a Java program to implement a lambda expression to convert a list of strings to uppercase.
        List<String> myList = Arrays.asList("text", "lambda", "UPPERcase");
        myList.replaceAll(String::toUpperCase);
        System.out.println("task3(myList) = " + myList);

        //  Task4.  Write a Java program to implement a lambda expression to print odd numbers from the list
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5);
        integers.forEach((n) -> {
            if (n % 2 == 0) System.out.println(n);
        });

    }

    private static boolean task2(String texToCheck) {
        Predicate<String> isBlank = String::isBlank;
        return isBlank.test(texToCheck);
    }

    private static int task1(int a, int b) {
        BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;
        return sum.apply(a, b);
    }


    private static void lambdaForEach() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Peter");
        names.add("Liam");
        names.add("Vik");
        names.add("<Maverick>");

        names.forEach(
                (n) -> System.out.println(n)
        );

        names.forEach(
                System.out::println
        );

    }

    private static void lambdaComplexLogic() {
        SayableTwoParam mySayableTwoParam = (a, b) -> {
            String sayHello = "Hello!";
            StringJoiner sj = new StringJoiner(" ");
            sj.add(sayHello)
                    .add(a)
                    .add(b);
            return sj.toString();
        };

        System.out.println("mySayableTwoParam.say(\"Hey!\", \"Who are you?\") = " + mySayableTwoParam.say("Hey!", "Who are you?"));
    }

    private static void lambdaTwoParam() {
        SayableTwoParam mySayableTwoParam = (a, b) -> "Said: " + a + " " + b;

        System.out.println("mySayableTwoParam.say(\"Hello!\", \"How are you?\") = " + mySayableTwoParam.say("Hello!", "How are you?"));
    }

    private static void lambdaOneParam() {
        SayableOneParam sayableOneParam = toSay -> "Said: " + toSay;

        System.out.println("sayableOneParam.say(\"hello!\") = " + sayableOneParam.say("hello!"));
    }

    private static void lambdaNoParam() {
        SayableWOParam mySayableWOParam = () -> "I have nothing to say";

        System.out.println("mySayableWOParam.say() = " + mySayableWOParam.say());
    }

    private static void interfaceWithoutLambda() {
        Printable myPrintable = new Printable() {
            @Override
            public void print(int a) {
                System.out.println("Printed: " + a);
            }
        };

        myPrintable.print(10);
    }

}
