package module5;

public class AppClassCastingCheck {

    public static void main(String[] args) {

        Person personDev = new Developer("Stepan", 30, "Java");
        Developer developerDev = new Developer("Max", 31, "Java");

        System.out.println("personDev.getClass() = " + personDev.getClass());
        System.out.println("developerDev.getClass() = " + developerDev.getClass());

        Developer devFromPersonDev = (Developer) personDev;

        System.out.println("========================");

        Person.printHello();
        Developer.printHello();


    }

}
