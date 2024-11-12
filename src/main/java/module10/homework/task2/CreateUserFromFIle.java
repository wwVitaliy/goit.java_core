package module10.homework.task2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Завдання 2
 * Є текстовий файл file.txt.
 * Необхідно прочитати файл,
 * перетворити його в список об'єктів типу User,
 * і записати їх у новий файл user.json.
 * <p>
 * Формат файлу:
 * <p>
 * перший рядок - заголовок
 * кожний наступний рядок - окремий об'єкт, кожна колонка розділена пробілом
 * Приклад:
 * <p>
 * Для файлу file.txt із вмістом:
 * <p>
 * name age
 * alice 21
 * ryan 30
 * <p>
 * необхідно створити наступний файл user.json:
 * <p>
 * [
 * {
 * "name": "alice",
 * "age":21
 * },
 * {
 * "name": "ryan",
 * "age":30
 * }
 * ]
 */
class CreateUserFromFIle {
    private static final String FILE_PATH = "src/main/java/module10/homework/task2/file.txt";

    private record User(String name, int age) {
    }

    public static void main(String[] args) {

        File file = new File(FILE_PATH);

        List<User> users = createUsersFromFile(file);
        System.out.println(users);

    }

    private static List<User> createUsersFromFile(File file) {
        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // read head and skip
            }

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine()
                        .strip()
                        .split(" ");
                users.add(new User(split[0], Integer.parseInt(split[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
