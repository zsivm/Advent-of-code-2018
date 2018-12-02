package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static final String CHALLENGE_1 = "challenge_1";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        Scanner sc = fileReader.readFile(CHALLENGE_1);

        // ----- Challenge #1 -----

        // part1
        Challenge1 ch1 = new Challenge1();
        System.out.println(ch1.sumFrequencies(sc));

        // part 2
        sc = fileReader.readFile(CHALLENGE_1);
        System.out.println(ch1.reachesFrequencyTwiceFirst(sc, CHALLENGE_1));
    }
}