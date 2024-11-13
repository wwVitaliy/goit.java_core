package module10.homework.task1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Завдання 1
 * Дано текстовий файл file.txt, в якому є список номерів телефонів
 * (один рядок - один телефон).
 * <p>
 * Необхідно написати метод, який буде читати файл, і виводити в консоль всі валідні номери телефонів.
 * <p>
 * Телефон вважається валідним, якщо він відповідає одному з двох форматів (x - це одна цифра):
 * <p>
 * (xxx) xxx-xxxx
 * <br>
 * xxx-xxx-xxxx
 * <p>
 * Приклад:
 * <p>
 * Для файлу file.txt з наступним змістом:
 * <p>
 * 987-123-4567
 * <br>
 * 123 456 7890
 * <br>
 * (123) 456-7890
 * <p>
 * Метод повинен вивести на екран:
 * <p>
 * 987-123-4567
 * <br>
 * (123) 456-7890
 */
class ReadFromFile {

    private static final String FILE_PATH = "src/main/java/module10/homework/task1/file.txt";

    public static void main(String[] args) throws IOException {

        // assign file to physical file
        File file = new File(FILE_PATH);

        readAndPrintAllValidNumbers(file);
    }


    private static void readAndPrintAllValidNumbers(File file) {
        /*
        1. If possible read next line from File
        2. If line is valid number Print to console
         */

        try (FileReader fileReader = new FileReader(file)) {    // create an InputStream (try with resources)
            Scanner scanner = new Scanner(fileReader);  // create a Scanner to easy read data
            while (scanner.hasNextLine()) { // check if there is a line to read (thanks to scanner)
                String line = scanner.nextLine();   //  read next line (thanks to scanner)
                if (isValid(line)) {    //  validate number
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValid(String line) {
        Pattern validPattern1 = Pattern.compile("[(]\\d{3}[)]\\s\\d{3}[-]\\d{4}");    //  (xxx) xxx-xxxx
        Pattern validPattern2 = Pattern.compile("\\d{3}[-]\\d{3}[-]\\d{4}");    //  xxx-xxx-xxxx
        Matcher matcher1 = validPattern1.matcher(line.strip());
        Matcher matcher2 = validPattern2.matcher(line.strip());
        return matcher1.find() || matcher2.find();
    }

}
