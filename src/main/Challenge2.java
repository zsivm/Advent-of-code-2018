package main;


/*
    --- Part One ---

    To make sure you didn't miss any, you scan the likely candidate boxes again,
    counting the number that have an ID containing exactly two of any letter and then
    separately counting those with exactly three of any letter. You can multiply those two counts
    together to get a rudimentary checksum and compare it to what your device predicts.

    For example, if you see the following box IDs:

    abcdef contains no letters that appear exactly two or three times.
    bababc contains two a and three b, so it counts for both.
    abbcde contains two b, but no letter appears exactly three times.
    abcccd contains three c, but no letter appears exactly two times.
    aabcdd contains two a and two d, but it only counts once.
    abcdee contains two e.
    ababab contains three a and three b, but it only counts once.
    Of these box IDs, four of them contain a letter which appears exactly twice,
    and three of them contain a letter which appears exactly three times.
    Multiplying these together produces a checksum of 4 * 3 = 12.

    What is the checksum for your list of box IDs?

    -----------------

    --- Part Two ---

 */


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Challenge2 {

    public void countCharacters(Scanner sc) {
        int number = 1;
        Map<String, Integer> map = new HashMap<>();

        while(sc.hasNextLine()) {

            String line = sc.nextLine();

            for(int i = 0; i < line.length() - 1; i++) {
                for(int j = i + 1; j < line.length(); j++) {
                    if(line.charAt(i) == line.charAt(j)) {
                       number++;
                    }
                }

                if(!map.keySet().contains(String.valueOf(line.charAt(i))) && number > 1) {
                    map.put(String.valueOf(line.charAt(i)), number);
                }

                number = 1;
            }

            System.out.println("--- new word ---");
            System.out.println(map.toString());
            map.clear();
        }

    }



}
