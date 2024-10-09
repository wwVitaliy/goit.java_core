package module4;

import java.util.Arrays;
import java.util.Random;

/**
 * Class that tests quick sorting algorithm for array of random integers.
 */
public class QuickSort2 {

    private static final int ARRAY_MAX_LEN = 20;
    static final int ELEMENT_MAX_VAL = 20;

    public static void main(String[] args) {
        int[] generatedArray = getRandomIntArray(ARRAY_MAX_LEN, ELEMENT_MAX_VAL);
        System.out.println("Generated array:");
        System.out.println(Arrays.toString(generatedArray));

        quickSortOfIntArray(generatedArray);
        System.out.println("Array after quick sorting:");
        System.out.println(Arrays.toString(generatedArray));

        System.out.println("Is the array sorted?");
        System.out.println(isIntArraySorted(generatedArray) ? "Yes!" : "No:(");
    }

    /**
     * Generates array of random size filled with random positive integers.
     *
     * @param arrayMaxSize max size of the generated array
     * @param elemMaxValue max value of arrays elements
     * @return array with random integers
     */
    private static int[] getRandomIntArray(int arrayMaxSize, int elemMaxValue) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(arrayMaxSize)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(elemMaxValue);
        }

        return numbers;
    }

    /**
     * Starter method of quick search for an array
     */
    private static void quickSortOfIntArray(int[] array) {
        quickSortOfIntArray(array, 0, array.length - 1);
    }

    /**
     * Recursive method of quick search
     */
    private static void quickSortOfIntArray(int[] array,
                                            int lowIndex,
                                            int highIndex) {
        if (lowIndex >= highIndex) return;

        int partitionIndex = getPartitionIndex(array, lowIndex, highIndex);

        quickSortOfIntArray(array, lowIndex, partitionIndex - 1);
        quickSortOfIntArray(array, partitionIndex + 1, highIndex);
    }

    /**
     * Returns an index of a pivot element after moving it into sorted position in the array
     */
    private static int getPartitionIndex(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);

        }
        if (array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }

    /**
     * Swaps values of two array slots
     */
    private static void swap(int[] array, int index1, int index2) {
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
    private static boolean isIntArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
