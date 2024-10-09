package module4;

import java.util.Arrays;

/**
 * Class that tests quick sorting algorithm for array of random integers.
 */
public class QuickSort {

    private static final int ARRAY_MAX_LEN = 20;
    static final int ELEMENT_MAX_VAL = 20;

    public static void main(String[] args) {

        int[] generatedArray = ArraysUtils.getRandomIntArray(ARRAY_MAX_LEN, ELEMENT_MAX_VAL);
        System.out.println("Generated array:");
        System.out.println(Arrays.toString(generatedArray));

        quickSortOfIntArray(generatedArray);
        System.out.println("Array after quick sorting:");
        System.out.println(Arrays.toString(generatedArray));

        System.out.println("Is the array sorted?");
        System.out.println(ArraysUtils.isIntArraySorted(generatedArray) ? "Yes!" : "No:(");
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
            ArraysUtils.swap(array, leftPointer, rightPointer);

        }
        if (array[leftPointer] > array[highIndex]) {
            ArraysUtils.swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }

}
