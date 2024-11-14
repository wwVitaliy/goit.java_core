package module10;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class IOTry {
    public static void main(String[] args) throws IOException {

//        tryByteArrayInputStream();
//        tryByteArrayOutputStream();
//        tryCharArrayReader();
//        tryCharArrayWriter();

        tyrScannerAndSystemIn();
    }

    private static void tyrScannerAndSystemIn() {
        InputStream in = System.in; //  InputStream that reads bytes from keyboard
        Scanner scanner = new Scanner(in);  //  transforms bytes from InputStream to some type

        while(scanner.hasNext()){
            System.out.println("scanner.nextInt() = " + scanner.nextInt());
        }
    }

    private static void tryByteArrayInputStream() throws IOException {
        byte[] bytes = new byte[]{1,2,3,4,5,6};   //  data to input from

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);    //  create stream

        //  print all bytes from stream
        while(byteArrayInputStream.available() > 0){
            System.out.println("byteArrayInputStream.read() = " + byteArrayInputStream.read());
        }

        byteArrayInputStream.close();   // close stream

    }

    private static void tryCharArrayWriter() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();    //  create stream of chars

        charArrayWriter.append("Java"); //  add string to charArrayWriter

        System.out.println("charArrayWriter = " + charArrayWriter);
    }

    private static void tryCharArrayReader() throws IOException {
        char[] chars = new char[]{'J', 'a', 'v', 'a'}; // data to create a stream of
        CharArrayReader charArrayReader = new CharArrayReader(chars); // create a stream of char from char[]

        char[] buffer = new char[1024]; // char[] to read chars to

        int readCharCount   //  qty of read chars
                = charArrayReader.read(buffer, 0, buffer.length);   // read chars from charArrayReader and add them to buffer

        // print chars from buffer
        for (int i = 0; i < readCharCount; i++) {
            System.out.println("buffer[" + i + "] = " + buffer[i]);
        }

        // close charArrayReader/release captured data (chars)
        charArrayReader.close();
    }

    private static void tryByteArrayOutputStream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 100; i < 1000; i++) {
            baos.write(i); //write() приймає байти як int (-128..127)
        }
        baos.flush();
        System.out.println(Arrays.toString(baos.toByteArray()));
    }
}
