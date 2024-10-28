package module9.theory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

class GenericTest<T, K extends Number> {
    public static void main(String[] args) {
        List<? extends Number> myList = new ArrayList<>();
        List<BigDecimal> myList2 = new ArrayList<>();
        List<? extends Number> myList3 = new ArrayList<BigDecimal>();

        listIntegerTest(myList);
        listBigDecimalTest(myList2);

    }

    private void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
        K k = (K) new AtomicInteger();
    }
    private static void listIntegerTest(List<? extends Number> list){
        System.out.println("List<Integer>");
    }
    private static void listBigDecimalTest(List<? super BigDecimal> list){
        System.out.println("List<BigDecimal>");
    }
}

