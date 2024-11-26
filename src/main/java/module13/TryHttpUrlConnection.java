package module13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.StringJoiner;


public class TryHttpUrlConnection {
    public static final String TEST_ULR = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException {
        sendGET();
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
            StringJoiner sj = new StringJoiner("\n");
            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                while (scanner.hasNextLine()) {
                    sj.add(scanner.nextLine());
                }
            }
            System.out.println(sj);
        } else {
            System.out.println(responseCode
                    + ": "
                    + "GET-request unsuccessful");
        }

    }

}
