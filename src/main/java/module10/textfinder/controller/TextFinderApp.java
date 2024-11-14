package module10.textfinder.controller;

import module10.textfinder.service.SearchEngine;

import java.io.File;

class TextFinderApp {

    public static final String ROOT = "src/main/java/module10/textfinder/rootfdir";

    public static void main(String[] args) {
        new SearchEngine().findAndPrint(new File(ROOT), "this is");
    }

}
