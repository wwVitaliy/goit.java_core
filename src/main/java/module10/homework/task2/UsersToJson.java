package module10.homework.task2;

import com.google.gson.Gson;

import java.io.*;
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
class UsersToJson {
    private static final String PATH_FROM = "src/main/java/module10/homework/task2/file.txt";
    private static final String PATH_TO = "src/main/java/module10/homework/task2/user.json";

    private record User(String name, int age) {
    }

    public static void main(String[] args) {
        File fileFrom = new File(PATH_FROM);
        File fileTo = new File(PATH_TO);

        List<User> users = createUsersFromFile(fileFrom);

        try (FileOutputStream fos = new FileOutputStream(fileTo)) {
            fos.write(usersToJson(users).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String usersToJson(List<User> users) {
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        return gson.toJson(users);
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
