package module12.textsearch.service.filecollector;

import java.io.File;
import java.util.List;

public interface FileCollector {
    List<File> getFiles(File rootFolder);
}
