package module10.textfinder.service.filescanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class RecursiveFileScanner implements FileScanner {

    @Override
    public Collection<File> scan(File root) {

        Collection<File> filesFromRoot = new ArrayList<>();
        recursiveScan(root, filesFromRoot);

        return filesFromRoot;
    }

    private void recursiveScan(File root, Collection<File> files) {
        File[] filesInRoot = root.listFiles();
        for (File file : filesInRoot) {
            if (file.isDirectory()) {
                recursiveScan(file, files);
            } else {
                files.add(file);
            }
        }
    }
}
