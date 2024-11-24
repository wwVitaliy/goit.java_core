package module12.textsearch.service.textsearcher;

import java.io.File;

class SimpleTextSearcherTests {
    public static final String DATA_FOLDER_PATH = "src/main/java/module12/textsearch/data/";
    public static final String FILE_NAME = "someTextHere.txt";

    public static void main(String[] args) {


        SimpleTextSearcher mySimpleTextSearcher = new SimpleTextSearcher();

        System.out.println(DATA_FOLDER_PATH + FILE_NAME + ": "
                + mySimpleTextSearcher.search("text", new File(DATA_FOLDER_PATH + FILE_NAME)));

        System.out.println(DATA_FOLDER_PATH + ": "
                + mySimpleTextSearcher.search("text", new File(DATA_FOLDER_PATH)));

        System.out.println(DATA_FOLDER_PATH + "newfile.txt" + ": "
                + mySimpleTextSearcher.search("text", new File(DATA_FOLDER_PATH + "newfile.txt")));
    }


}
