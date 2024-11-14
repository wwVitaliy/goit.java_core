package module11;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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
    interface SayableTwoParam{
        public String say(String sayFirst, String saySecond);
    }

    public static void main(String[] args) {

//        interfaceWithoutLambda();   //  1.  Interface Without Lambda Expression
//        lambdaNoParam();
//        lambdaOneParam();
//        lambdaTwoParam();
//        lambdaComplexLogic();
        lambdaForEach();
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
        SayableTwoParam mySayableTwoParam = (a , b) -> "Said: " + a + " " + b;

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
