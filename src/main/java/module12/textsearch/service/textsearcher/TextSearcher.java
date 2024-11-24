package module12.textsearch.service.textsearcher;

import java.io.File;

public interface TextSearcher {
    boolean search(String text, File file);
}
