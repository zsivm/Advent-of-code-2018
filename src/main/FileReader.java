package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private static final String PATH = "." + "/" + "src" + "/" + "resource" + "/";
    private static final String EXTENSION = ".txt";

    private Scanner scanner;
    private String fileName;

    public FileReader() {}

    public FileReader(String fileName) {
        this.fileName = fileName;
        readFile();
    }

    public Scanner readFile() {
        File file = new File(PATH + fileName + EXTENSION);
        try {
            return scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("file not found! " + e);
        }
        return null;
    }

    public void print() {
        if(scanner == null) {
            System.out.println("Scanner needs to read input first");
            return;
        }

        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}
