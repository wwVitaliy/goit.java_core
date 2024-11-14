package module10.textfinder.service.filecontextreader;

import java.io.File;

class FileContentReaderTests {
    public static final String FILE_PATH = "src/main/java/module10/textfinder/rootfdir/lvl11/lvl21/secondFile.txt";

    public static void main(String[] args) {
        FileContentReader fileContentReader = new CharISFIleReader();

        File file = new File(FILE_PATH);

        System.out.println("fileContentReader.read(file) = " + fileContentReader.read(file));

    }
}
