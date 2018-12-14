package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private static final String PATH = "." + "/" + "src" + "/" + "resource" + "/";
    private static final String EXTENSION = ".txt";

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
        readFile();
    }

    public Scanner readFile() {
        File file = new File(PATH + fileName + EXTENSION);
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("file not found! " + e);
        }
        return null;
    }
}
