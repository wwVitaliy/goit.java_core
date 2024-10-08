package module3;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {

        //Creation
        int[] apples;
        int peaches[];

        //Initialization
        apples = new int[3];

        //Add values
        int[] someDigits = {1, 2, 3, 4};

        //Get length
        int length = someDigits.length;
        System.out.println(length);

        //Copy
        int[] newArray = Arrays.copyOf(someDigits, 10);
        System.out.println("newArray.length = " + newArray.length);

        //Output
        System.out.println(Arrays.toString(newArray));
    }


}
