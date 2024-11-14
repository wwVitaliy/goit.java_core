package module10.textfinder.service.textsearcher;

public class ByWordTextSearch implements TextSearcher {


    @Override
    public boolean search(String context, String search) {
        String[] words = search.split(" ");
        for (String word : words) {
            if (!context.contains(word)) return false;
        }
        return true;
    }
}
