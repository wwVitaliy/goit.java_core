package module12.textsearch.service.appengine;

public class MultiThreadSearchEngineTests {
    public static void main(String[] args) {

        MultiThreadSearchEngine thisSearchEngine = new MultiThreadSearchEngine();

        System.out.println("\nTest 1:");
        thisSearchEngine.printFilesWithText(".", "text");
        System.out.println("\nTest 2:");
        thisSearchEngine.printFilesWithText("specificText", ".");
        System.out.println("\nTest 3:");
        thisSearchEngine.printFilesWithText("text", ".");
    }
}
