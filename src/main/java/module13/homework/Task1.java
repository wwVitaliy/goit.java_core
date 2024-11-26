package module13.homework;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Завдання 1
 * Напишіть програму, що буде взаємодіяти з API https://jsonplaceholder.typicode.com.
 * <p>
 * Програма повинна містити методи для реалізації наступного функціоналу:
 * <p>
 * створення нового об'єкта в https://jsonplaceholder.typicode.com/users.
 * Можливо, ви не побачите одразу змін на сайті.
 * Метод працює правильно, якщо у відповідь на JSON з об'єктом повернувся такий самий JSON,
 * але зі значенням id більшим на 1, ніж найбільший id на сайті.
 * <p>
 * оновлення об'єкту в https://jsonplaceholder.typicode.com/users.
 * Можливо, ви не побачите одразу змін на сайті.
 * Вважаємо, що метод працює правильно, якщо у відповідь ви отримаєте оновлений JSON
 * (він повинен бути таким самим, що ви відправили).
 * <p>
 * видалення об'єкта з https://jsonplaceholder.typicode.com/users.
 * Тут будемо вважати коректним результат - статус відповіді з групи 2xx (наприклад, 200).
 * <p>
 * отримання інформації про всіх користувачів https://jsonplaceholder.typicode.com/users
 * <p>
 * отримання інформації про користувача за id https://jsonplaceholder.typicode.com/users/{id}
 * <p>
 * отримання інформації про користувача за username - https://jsonplaceholder.typicode.com/users?username={username}
 */
public class Task1 {
    public static final String HOST = "https://jsonplaceholder.typicode.com";
    public static final String USERS_PATH = "/users";
    public static final Gson GSON
            = new Gson().newBuilder().setPrettyPrinting().create();

    public static final String MY_USER = "src/main/java/module13/homework/task1_user.json";

    public record User(
            int id,
            String name,
            String userName,
            String email,
            Address address,
            String phone,
            String website,
            Company company
    ) {
    }

    public record Address(
            String street,
            String suite,
            String city,
            String zipcode,
            Geo geo
    ) {
    }

    public record Geo(
            String lat,
            String lng
    ) {
    }

    public record Company(
            String name,
            String catchPhrase,
            String bs
    ) {
    }

    public static void main(String[] args) throws IOException {
        // read user from file
        String userText = Files.readString(Path.of(MY_USER));
        User user = GSON.fromJson(userText, User.class);


//        // create new user
//        HttpResponse<String> postUserRespond = postNewUser(user);
//        System.out.println("postUserRespond.body() = " + postUserRespond.body());

//        // update user
//        HttpResponse<String> putUserRespond = putUser(user);
//        System.out.println("putUserRespond.body() = " + putUserRespond.body());

        // delete user
        int id = 5;
        HttpResponse<String> deleteUserRespond = deleteUser(id);
        System.out.println("deleteUserRespond.statusCode() = " + deleteUserRespond.statusCode());
        System.out.println("deleteUserRespond.body() = " + deleteUserRespond.body());

//        // get all users
//        HttpResponse<String> getUsers = getUsers();
//        User[] users = GSON.fromJson(getUsers.body(), User[].class);

//        // get user by id
//        int id = 2;
//        HttpResponse<String> getUserById = getUser(id);
//        System.out.println("getUserById.body() = " + getUserById.body());

//        // get user by username
//        String username = "Samantha";
//        HttpResponse<String> getUserByUsername = getUser(username);
//        System.out.println("getUserByUsername.body() = " + getUserByUsername.body());

    }

    // delete user with specific Id by sending DELETE request
    private static HttpResponse<String> deleteUser(int id) {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HOST + USERS_PATH + "/" + id))
                    .header("Content-type", "application/json; charset=UTF-8")
                    .DELETE()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // get a user with specified username by sending GET request
    private static HttpResponse<String> getUser(String username) {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HOST + USERS_PATH + "?username=" + username))
                    .header("Content-type", "application/json; charset=UTF-8")
                    .GET()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // get a user with specified Id by sending GET request
    private static HttpResponse<String> getUser(int id) {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HOST + USERS_PATH + "/" + id))
                    .header("Content-type", "application/json; charset=UTF-8")
                    .GET()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // get all users by sending GET request
    private static HttpResponse<String> getUsers() {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HOST + USERS_PATH))
                    .header("Content-type", "application/json; charset=UTF-8")
                    .GET()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // update user by sending PUT request
    // user with the same id will be updated
    private static HttpResponse<String> putUser(User user) {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HOST + USERS_PATH + "/" + user.id))
                    .header("Content-type", "application/json; charset=UTF-8")
                    .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // create new user by sending POST request
    private static HttpResponse<String> postNewUser(User user) throws IOException {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HOST + USERS_PATH))
                    .header("Content-type", "application/json; charset=UTF-8")
                    .POST(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

