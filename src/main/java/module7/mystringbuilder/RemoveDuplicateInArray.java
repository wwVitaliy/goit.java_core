package module7.mystringbuilder;

import java.util.Arrays;
import java.util.Random;

public class RemoveDuplicateInArray {

    public static void main(String[] args) {
        Random random = new Random();
        int arrayLength = random.nextInt(0, 10);
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(randomArray));
        System.out.println(Arrays.toString(removeDuplicates(randomArray)));
    }

    public static int[] removeDuplicates(int[] array) {
        if (array.length == 0) return new int[0];
        if (array.length == 1) return array;

        int[] uniques = new int[array.length];
        uniques[0] = array[0];
        int uniqueCount = 1;

        for (int i = 1; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (array[i] == uniques[j]) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniques[uniqueCount] = array[i];
                uniqueCount++;
            }
        }

        return Arrays.copyOf(uniques, uniqueCount);
    }
    
}
