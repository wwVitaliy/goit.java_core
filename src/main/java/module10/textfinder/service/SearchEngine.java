package module10.textfinder.service;

import module10.textfinder.service.filecontextreader.CharISFIleReader;
import module10.textfinder.service.filecontextreader.FileContentReader;
import module10.textfinder.service.filescanner.FileScanner;
import module10.textfinder.service.filescanner.RecursiveFileScanner;
import module10.textfinder.service.textsearcher.ByWordTextSearch;
import module10.textfinder.service.textsearcher.TextSearcher;

import java.io.File;
import java.util.Collection;

public class SearchEngine {

   public void findAndPrint(File root, String search){
       FileScanner fileScanner = new RecursiveFileScanner();
       FileContentReader fileContentReader = new CharISFIleReader();
       TextSearcher textSearch = new ByWordTextSearch();

       Collection<File> files = fileScanner.scan(root);

       for (File file : files) {
           if (textSearch.search(fileContentReader.read(file), search)) {
               System.out.println("file = " + file);
           }
       }
   }

}
