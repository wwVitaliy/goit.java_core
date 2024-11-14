package module10.textfinder.service.textsearcher;

public class TextSearcherTests {
    public static void main(String[] args) {
        TextSearcher textSearcher = new ByWordTextSearch();

        System.out.println("textSearcher.search(\"this is text\", \"text\") = " + textSearcher.search("this is text", "text"));
        System.out.println("textSearcher.search(\"this is text\", \"random\") = " + textSearcher.search("this is text", "random"));
        System.out.println("textSearcher.search(\"this is text\", \"is this\") = " + textSearcher.search("this is text", "is this"));
    }
}
