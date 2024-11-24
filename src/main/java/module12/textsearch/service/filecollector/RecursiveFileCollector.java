package module12.textsearch.service.filecollector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileCollector implements FileCollector {


    @Override
    public List<File> getFiles(File rootFolder) {
        List<File> files = new ArrayList<>();

        searchFoFile(rootFolder, files);

        return files;
    }

    private void searchFoFile(File rootFolder, List<File> files) {
        File[] innerFiles = rootFolder.listFiles();
        if (rootFolder.isFile()) {
            files.add(rootFolder);
        } else if (innerFiles != null) {
            for (File innerFile : innerFiles) {
                searchFoFile(innerFile, files);
            }
        }
    }
}
