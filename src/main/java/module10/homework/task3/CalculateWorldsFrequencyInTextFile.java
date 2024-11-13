package module10.homework.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Завдання 3
 * Напишіть метод, який буде рахувати частоту кожного слова у файлі words.txt.
 * <p>
 * Вважаємо що:
 * <p>
 * words.txt містить лише слова в нижньому регістрі, розділені пробілом
 * Кожне слово містить лише літери в нижньому регістрі
 * Слова розділені одним або декількома пробілами, або переносом рядка
 * Приклад:
 * <p>
 * Для файлу words.txt із вмістом:
 * <p>
 * the day is sunny the the
 * the sunny is is
 * <p>
 * Метод повинен повернути результат на кшталт:
 * <p>
 * the 4
 * is 3
 * sunny 2
 * day 1
 * <p>
 * Увага
 * Результат виводу в консоль повинен бути відсортований за частотою (спочатку йдуть слова, що зустрічаються найчастіше)
 */
class CalculateWorldsFrequencyInTextFile {
    private static final String PATH_FROM = "src/main/java/module10/homework/task3/words.txt";

    public static void main(String[] args) {
        File file = new File(PATH_FROM);
        Map<String, Integer> wordsQty = new HashMap<>();

        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()) {
                String wordToAdd = scanner.next();
                if (wordsQty.containsKey(wordToAdd)) {
                    wordsQty.compute(wordToAdd, (k, qty) -> qty + 1);
                } else {
                    wordsQty.put(wordToAdd, 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Comparator<Map.Entry<String, Integer>> entryComparator = Map.Entry.comparingByValue();
        List<Map.Entry<String, Integer>> list = wordsQty.entrySet()
                .stream()
                .sorted(entryComparator.reversed())
                .toList();

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }



}
