package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static final String CHALLENGE_1 = "challenge_1";
    private static final String CHALLENGE_2 = "challenge_2";
    private static final String CHALLENGE_3 = "challenge_3";
    private static final String TEST = "test";

    public static void main(String[] args) throws FileNotFoundException {
        // ----- Challenge #1 -----
        Challenge1 ch1 = new Challenge1(CHALLENGE_1);
        System.out.println("Day 1/1: " + ch1.sumFrequencies());
        System.out.println("Day 1/2: " + ch1.reachesFrequencyTwiceFirst());

        // ----- Challenge #2 -----
        Challenge2 ch2 = new Challenge2(CHALLENGE_2);
        System.out.println("Day 2/1: " + ch2.countCharacters());
        System.out.println("Day 2/2: " + ch2.getCommonCharacters());

        // ----- Challenge #3 -----
        Challenge3 ch3 = new Challenge3(CHALLENGE_3);

    }
}