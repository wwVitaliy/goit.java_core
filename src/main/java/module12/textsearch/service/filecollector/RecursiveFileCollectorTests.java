package module12.textsearch.service.filecollector;

import java.io.File;
import java.util.List;

class RecursiveFileCollectorTests {
    private static final String ROOT_FOLDER_PATH = ".";
    private static final File ROOT_FOLDER = new File(ROOT_FOLDER_PATH);


    public static void main(String[] args) {
        // create new FileCollector
        FileCollector myFileSearch = new RecursiveFileCollector();

        // collect all files
        List<File> files = myFileSearch.getFiles(ROOT_FOLDER);

        // print results into console
        System.out.println("ROOT_FOLDER = " + ROOT_FOLDER.getAbsolutePath());
        System.out.println("Found: " + files.size());
    }

}
