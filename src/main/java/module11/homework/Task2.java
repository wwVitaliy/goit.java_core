package module11.homework;

import java.util.Comparator;
import java.util.List;

/**
 * Завдання 2
 * Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
 * Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).
 */
class Task2 {
    public static void main(String[] args) {
        //  create list dof strings
        List<String> list = List.of("John", "Bill", "Liam", "Jack");

        //  convert each element of list to upper case and sort in descending order (Z -> A)
        List<String> result = toUpperCaseAndSort(list);

        //  print a list of string
        System.out.println("result = " + result);
    }

    /**
     * Convert each element of list to upper case and sorts in descending order (Z -> A)
     * @param list  List<String>
     * @return  List<String>
     */
    private static List<String> toUpperCaseAndSort(List<String> list) {
       return list.stream() //  create stream from list
                .map(String::toUpperCase)   //  convert each element to upper case
                .sorted(Comparator.reverseOrder())  //  sort in descending order
                .toList();  //  create a list
    }

}
