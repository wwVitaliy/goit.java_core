package module12.textsearch.service.textsearcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleTextSearcher implements TextSearcher {

    @Override
    public boolean search(String text, File file) {
        if (file.isDirectory() || !file.exists()){
            return false;
        }

        try {
            String fileContent = Files.readString(Path.of(file.getPath()));
            if (fileContent.toLowerCase().contains(text.toLowerCase())) {
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
