package module4;

import java.util.Random;

public class ArraysUtils {

    /**
     * Generates array of random size filled with random positive integers.
     *
     * @param arrayMaxSize max size of the generated array
     * @param elemMaxValue max value of arrays elements
     * @return array with random integers
     */
    protected static int[] getRandomIntArray(int arrayMaxSize, int elemMaxValue) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(arrayMaxSize)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(elemMaxValue);
        }

        return numbers;
    }

    /**
     * Swaps values of two array slots
     */
    protected static void swap(int[] array, int index1, int index2) {
        if (index1 == index2
                || index1 > array.length - 1
                || index2 > array.length - 1) {
            return;
        }

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Checks if the array of integers is sorted.
     */
    protected static boolean isIntArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
