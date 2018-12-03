package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private static final String PATH = "." + "/" + "src" + "/" + "resource" + "/";
    private static final String EXTENSION = ".txt";

    private Scanner scanner;

    public Scanner readFile(String fileName) throws FileNotFoundException {
        File file = new File(PATH + fileName + EXTENSION);
        scanner = new Scanner(file);
        return scanner;
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
}
