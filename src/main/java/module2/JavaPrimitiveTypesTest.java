package module2;

import java.text.DecimalFormat;

public class JavaPrimitiveTypesTest {
    public static void main(String[] args) {
        System.out.println(fahrenheitToCelsius(212));
        System.out.println(fahrenheitToCelsius(0F));
        System.out.println(fahrenheitToCelsius(100D));
        System.out.println(fahrenheitToCelsius(15.0));

        System.out.println(inchesToMeters(10));
        System.out.println(inchesToMeters(0.5));
        System.out.println(inchesToMeters(115D));
        System.out.println(inchesToMeters(10.001));

        System.out.println(getSumOfDigits(100));
        System.out.println(getSumOfDigits(565));
        System.out.println(getSumOfDigits(999));
        System.out.println(getSumOfDigits(321));

        System.out.println(getCharFromString("string", 4));
        System.out.println(getCharFromString("my text", 0));
        System.out.println(getCharFromString("very smart example", 40));

        System.out.println(compareTwoStrings("111", "2222"));
        System.out.println(compareTwoStrings("111", "111"));
        System.out.println(compareTwoStrings("111", "000"));


    }

    /*
    1. Write a Java program to convert temperature from Fahrenheit to Celsius degrees.
    Test Data
    Input a degree in Fahrenheit: 212
    Expected Output:
    212.0 degree Fahrenheit is equal to 100.0 in Celsius
     */
    public static String fahrenheitToCelsius(double tFahrenheit) {
        double tCelsius = (tFahrenheit - 32.0) / (9.0 / 5.0);
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        return tFahrenheit + " degree Fahrenheit is equal to " + decimalFormat.format(tCelsius) + " in Celsius";
    }

    /*
    2. Write a Java program that reads a number in inches and converts it to meters.
    Note: One inch is 0.0254 meter.
    Test Data
    Input a value for inch: 1000
    Expected Output :
    1000.0 inch is 25.4 meters
     */
    public static String inchesToMeters(double inches) {
        double meters = inches * 0.0254;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return inches + " inch is " + decimalFormat.format(meters) + " meters";
    }

    /*
    3. Write a Java program that reads an integer between 0 and 1000 and adds all the digits in the integer.

    Test Data
    Input an integer between 0 and 1000: 565
    Expected Output :
    The sum of all digits in 565 is 16
     */
    public static String getSumOfDigits(int number) {
        int firstDigit = number % 10;

        number /= 10;
        int secondDigit = number % 10;

        number /= 10;
        int thirdDigit = number % 10;

        return firstDigit + " + " + secondDigit + " + " + thirdDigit + " = " + (firstDigit + secondDigit + thirdDigit);
    }

    /*
    1. Write a Java program to get the character at the given index within the string.

    Sample Output:

    Original String = Java Exercises!
    The character at position 0 is J
    The character at position 10 is i
     */
    public static char getCharFromString(String string, int index) {
        int stringLen = string.length();

        if (stringLen >= index + 1) {
            return string.charAt(index);
        } else return '\0';

    }

    /*
    Write a Java program to compare two strings lexicographically.
Two strings are lexicographically equal if they are the same length and contain the same characters in the same positions.

Sample Output:

String 1: This is Exercise 1
String 2: This is Exercise 2
"This is Exercise 1" is less than "This is Exercise 2"
     */

    public static String compareTwoStrings(
            String firstString,
            String secondString) {
        int comparisonRes = firstString.compareTo(secondString);
        return "" + firstString.compareTo(secondString);
    }
}
