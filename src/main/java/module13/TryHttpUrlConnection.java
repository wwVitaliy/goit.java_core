package module13;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringJoiner;


public class TryHttpUrlConnection {
    public static final String TEST_ULR = "https://jsonplaceholder.typicode.com/users";
    public static final String USER_JSON = "src/main/java/module13/user.json";
    public static final String USER_JSON_2 = "src/main/java/module13/user2.json";

    public static void main(String[] args) throws IOException {
//        sendGET();
        sendPut();
    }

    private static void sendPut() throws IOException {
        // create URL object
        URL url = new URL(TEST_ULR);

        // open URL-connection, cast it to HttpURLConnection to be able to use HTTP features
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // set request method
        System.out.println("connection.getRequestMethod() = " + connection.getRequestMethod());
        connection.setRequestMethod("POST");
        System.out.println("connection.getRequestMethod() = " + connection.getRequestMethod());

        // ?
        connection.setDoOutput(true);

        // add bytes[] to write to output stream
        OutputStream os = connection.getOutputStream();
        os.write(Files.readAllBytes(Path.of(USER_JSON)));
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("responseCode = " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            String responseBody = getResponseBody(connection);
            System.out.println(responseBody);
        } else {
            System.out.println(responseCode
                    + ": "
                    + "GET-request unsuccessful");
        }
    }

    private static void sendGET() throws IOException {
        // create URL object
        URL url = new URL(TEST_ULR);

        // open URL-connection, cast it to HttpURLConnection to be able to use HTTP features
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // set request method.
        // it is "GET" by default ? yes
//        connection.setRequestMethod("GET");

        System.out.println("connection.getURL() = " + connection.getURL());
        System.out.println("connection.getRequestMethod() = " + connection.getRequestMethod());

        // to receive data from respond, the request is sent ?
        System.out.println("connection.getResponseCode() = " + connection.getResponseCode());
        System.out.println("connection.getResponseMessage() = " + connection.getResponseMessage());

        // will the request be sent second time ? no
        int responseCode = connection.getResponseCode();
        System.out.println("responseCode = " + responseCode);

        // read respond body
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String responseBody = getResponseBody(connection);
            System.out.println(responseBody);
        } else {
            System.out.println(responseCode
                    + ": "
                    + "GET-request unsuccessful");
        }
    }

    private static String getResponseBody(HttpURLConnection connection) {
        StringJoiner sj = new StringJoiner("\n");
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            while (scanner.hasNextLine()) {
                sj.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sj.toString();
    }
}
