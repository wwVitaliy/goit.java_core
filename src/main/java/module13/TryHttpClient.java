package module13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class TryHttpClient {
    public static final String TEST_ULR = "https://jsonplaceholder.typicode.com/users";
    public static final String USER_JSON = "src/main/java/module13/user.json";
    public static final String USER_JSON_2 = "src/main/java/module13/user2.json";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        // HttpClient
//        getRequest();
        postRequest();
    }

    private static void postRequest() throws FileNotFoundException, URISyntaxException {
        // create POST-request
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(TEST_ULR))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(USER_JSON)))
                .build();

        // create httpClient
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            // send postRequest and receive response
            HttpResponse<String> response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getRequest() {
        // create Http GET-getRequest
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(TEST_ULR))
                .GET()
                .build();

        // create httpClient
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            // send getRequest and receive response
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
