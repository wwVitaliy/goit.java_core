package module12.textsearch.service.appengine;


import module12.textsearch.service.filecollector.FileCollector;
import module12.textsearch.service.filecollector.RecursiveFileCollector;
import module12.textsearch.service.textsearcher.SimpleTextSearcher;
import module12.textsearch.service.textsearcher.TextSearcher;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadSearchEngine {

    public List<File> findFilesWithText(String text, String root) {
        // convert String to file
        File rootFolder = new File(root);

        // create FileCollector
        FileCollector fileScanner = new RecursiveFileCollector();

        // create TextSearcher
        TextSearcher textSearcher = new SimpleTextSearcher();

        List<File> files = fileScanner.getFiles(rootFolder);
        List<File> filesWithText = new CopyOnWriteArrayList<>();
        List<Future<?>> filesFutures = new CopyOnWriteArrayList<>();

        // create new thread executor
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // submit a task for each file
        for (File file : files) {
            Future<?> submit = executorService.submit(() -> {
                boolean hasText = textSearcher.search(text, file);
                if (hasText) {
                    filesWithText.add(file);
                }
            });
            filesFutures.add(submit);
        }

        // wait till all futures are done
        while (!filesFutures.stream().allMatch(Future::isDone)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // close executor
        executorService.close();

        return filesWithText;
    }

    public void printFilesWithText(String text, String root) {
        List<File> files = findFilesWithText(text, root);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
