package module10.textfinder.service.filecontextreader;

import java.io.*;
import java.util.Arrays;

public class CharISFIleReader implements FileContentReader {
    public static final int BYTES_TO_READ = 8;

    @Override
    public String read(File file) {

        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[BYTES_TO_READ];
        int c;

        try (FileReader fileReader = new FileReader(file)) {
            while ((c = fileReader.read(buffer)) != -1) {
                if (c < BYTES_TO_READ) {
                    buffer = Arrays.copyOf(buffer, c);
                }
                sb.append(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
