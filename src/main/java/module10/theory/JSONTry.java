package module10.theory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

class JSONTry {
    private record Person(String name, int age, double height, boolean married) {
    }

    public static void main(String[] args) {
        Person person1 = new Person("Sam", 33, 178, true);

        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person1);
        System.out.println("json = " + json);

        Person person = gson.fromJson(json, Person.class);
        System.out.println("person = " + person);

    }
}