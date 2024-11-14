package module10.textfinder.service.textsearcher;

public class SimpleTextSearch implements TextSearcher{
    @Override
    public boolean search(String context, String search) {
        return context.toLowerCase().contains(search.toLowerCase());
    }
}
