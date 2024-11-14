package module10.textfinder.service.filescanner;

import java.io.File;
import java.util.Collection;

interface FileScanner {
    Collection<File> scan(File root);
}
