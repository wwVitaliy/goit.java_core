package module10;

import java.io.*;

class SerializationTry {
    private static final String MODULE_10_THEORY = "src/main/java/module10/theory/";
    private static final String PATH_TO = MODULE_10_THEORY + "seriliazationTry.dat";
    private static final String PATH_FROM = MODULE_10_THEORY + "seriliazationTry.dat";


    private record Person(String name, int age, double height, boolean married)
            implements Serializable {
    }

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_TO));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_FROM));
        ) {
            oos.writeObject(new Person("Sam", 33, 178, true));
            oos.writeObject(new Person("Tom", 30, 175, true));

            Person person = (Person) ois.readObject();
            System.out.println("person = " + person + ", " + person.getClass());

            person = (Person) ois.readObject();
            System.out.println("person = " + person + ", " + person.getClass());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
