package module10.filecopier;

import java.io.*;

class SimpleFIleCopier implements FileCopier {
    private final File copyFrom;
    private final File copyTo;

    public SimpleFIleCopier(File copyFrom, File copyTo) {
        this.copyFrom = copyFrom;
        this.copyTo = copyTo;
    }

    @Override
    public void copy() throws IOException {

        try (
                FileInputStream fis = new FileInputStream(this.copyFrom);
                FileOutputStream fos = new FileOutputStream(this.copyTo);
        ) {
            fos.write(fis.readAllBytes());
        }catch (FileNotFoundException e){
            System.out.println("Cannot find the file: " + e.getMessage());
        }
    }
}
