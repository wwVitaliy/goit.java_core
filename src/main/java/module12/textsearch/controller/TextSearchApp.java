package module12.textsearch.controller;

import module12.textsearch.service.appengine.MultiThreadSearchEngine;

public class TextSearchApp {
    public static void main(String[] args) {
        MultiThreadSearchEngine thisEngine = new MultiThreadSearchEngine();

        thisEngine.printFilesWithText("specificText", ".");
    }
}
