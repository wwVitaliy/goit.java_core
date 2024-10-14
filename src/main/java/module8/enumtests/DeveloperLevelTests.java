package module8.enumtests;

public class DeveloperLevelTests {
    public static void main(String[] args) {
        DeveloperLevel junior = DeveloperLevel.Junior;

        //Static method in enum
        DeveloperLevel.sayHello();

        //@Overrided method in enum
        System.out.println(junior.isJunior());


    }
}
