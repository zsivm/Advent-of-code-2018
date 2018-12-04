package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static final String CHALLENGE_1 = "challenge_1";
    private static final String CHALLENGE_2 = "challenge_2";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        Scanner sc = fileReader.readFile(CHALLENGE_2);

        // ----- Challenge #1 -----

        // part1
        //Challenge1 ch1 = new Challenge1();
        //System.out.println(ch1.sumFrequencies(sc));

        // part 2
        //sc = fileReader.readFile(CHALLENGE_1);
        //System.out.println(ch1.reachesFrequencyTwiceFirst(sc, CHALLENGE_1));

        // ----- Challenge #2 -----
        Challenge2 ch2 = new Challenge2();

        // part 1
        //System.out.println(ch2.countCharacters(sc));

        // part 2
        ch2.getCommonCharacters(sc);
    }
}