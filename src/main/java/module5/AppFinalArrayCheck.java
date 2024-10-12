package module5;


import java.util.Arrays;

/**
 * Arrays are similar to objects.
 * Final do not make the object immutable.
 */
class AppFinalArrayCheck {
    private static final int[] myArray = {1,2,3};

    public static void main(String[] args) {

        System.out.println("Arrays.toString(myArray) = " + Arrays.toString(myArray));
        myArray[0] = 0;
        System.out.println("Arrays.toString(myArray) = " + Arrays.toString(myArray));

    }

}
