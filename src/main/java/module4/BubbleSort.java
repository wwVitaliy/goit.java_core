package module4;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] testArray1 = {5, 4, 3, 2, 1};
        int[] testArray2 = {1,2,3,4,5,6};
        int[] testArray3 = {6,1,2,3,4};
        int[] testArray4 = {6,5,3,4,7,9,10,6};
        int[] testArray5 = {11,100,2,6,88};
        sortIntArrayBubble(testArray1);
        sortIntArrayBubble(testArray2);
        sortIntArrayBubble(testArray3);
        sortIntArrayBubble(testArray4);
        sortIntArrayBubble(testArray5);
        System.out.println("Sorted testArray1 = " + Arrays.toString(testArray1));
        System.out.println("Sorted testArray2 = " + Arrays.toString(testArray2));
        System.out.println("Sorted testArray3 = " + Arrays.toString(testArray3));
        System.out.println("Sorted testArray4 = " + Arrays.toString(testArray4));
        System.out.println("Sorted testArray5 = " + Arrays.toString(testArray5));
    }

    private static void sortIntArrayBubble(int[] array) {

        boolean isSorted = false;
        int comparisonEndIndex = array.length - 1;
        int buf;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < comparisonEndIndex; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
            comparisonEndIndex--;
        }
    }

}
