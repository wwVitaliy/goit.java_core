package module10.theory.FileCopier;

import java.io.File;
import java.io.IOException;

class SimpleFileCopierTry {
    public static void main(String[] args) throws IOException {
        File copyFrom = new File("src/main/java/module10/theory/FileCopier/copyFrom.txt");
        File copyTo = new File("src/main/java/module10/theory/FileCopier/copyTo.txt");

        if (!copyFrom.exists()){
            System.out.println("Cannot find the file: " + copyFrom.toString());
        }else{
            new SimpleFIleCopier(copyFrom, copyTo).copy();
        }

    }

}
