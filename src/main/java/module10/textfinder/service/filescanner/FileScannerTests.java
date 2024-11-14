package module10.textfinder.service.filescanner;

import java.io.File;
import java.util.Collection;

class FileScannerTests {
    public static final String ROOT = "src/main/java/module10/textfinder/rootfdir";

    public static void main(String[] args) {
        FileScanner fileScanner = new RecursiveFileScanner();
        File root = new File(ROOT);

        Collection<File> filesFromRoot = fileScanner.scan(root);

        for (File file : filesFromRoot) {
            System.out.println(file);
        }
    }
}
