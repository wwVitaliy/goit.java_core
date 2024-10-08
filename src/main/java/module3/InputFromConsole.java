package module3;

import java.util.Scanner;

public class InputFromConsole {
    public static void main(String[] args) {
        readStringFromConsole();
    }

    private static void readStringFromConsole (){
        //Create Scanner objects, which can transform InputStream into data type
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a text:");

        //Read next line from console
        String inputLine = scanner.nextLine();

        System.out.println("You typed:");
        System.out.println(inputLine);

        scanner.close();
    }

}
