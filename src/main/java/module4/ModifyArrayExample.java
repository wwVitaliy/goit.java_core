package module4;

import java.util.Arrays;

public class ModifyArrayExample {
    public static void main(String[] args) {
        String[] fruits = {
                "apple",
                "banana",
                "mango"
        };

// For-each does not work, because fruit is not an array element
//        for (String fruit : fruits) {
//            fruit = fruit.substring(0,1).toUpperCase()
//                    + fruit.substring(1);
//        }

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = fruits[i].substring(0, 1).toUpperCase()
                    + fruits[i].substring(1);
        }

        System.out.println(Arrays.toString(fruits));

    }
}
