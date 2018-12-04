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

    Confident that your list of box IDs is complete, you're ready to find the boxes full of prototype fabric.

    The boxes will have IDs which differ by exactly one character at the same position in both strings. For example, given the following box IDs:

    abcde
    fghij
    klmno
    pqrst
    fguij
    axcye
    wvxyz

    The IDs abcde and axcye are close, but they differ by two characters (the second and fourth).
    However, the IDs fghij and fguij differ by exactly one character, the third (h and u).
    Those must be the correct boxes.

    What letters are common between the two correct box IDs? (In the example above,
    this is found by removing the differing character from either ID, producing fgij.)

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Challenge2 {

    public int countCharacters(Scanner sc) {
        int number = 1;
        int duplicates = 0;
        int triplicates = 0;
        boolean hadDuplicate = false;
        boolean hadTriplicate = false;
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

            hadDuplicate = false;
            hadTriplicate = false;

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() == 2 && !hadDuplicate) {
                    duplicates++;
                    hadDuplicate = true;
                }

                if(entry.getValue() == 3 && !hadTriplicate) {
                    triplicates++;
                    hadTriplicate = true;
                }
            }

            map.clear();

        }

        return duplicates * triplicates;
    }

    public void getCommonCharacters(Scanner sc) {

        List<String> words = new ArrayList<>();
        String actual = "";
        String other = "";
        int countSameChars = 0;


        while(sc.hasNextLine()) {
            words.add(sc.nextLine());
        }

        for(int i = 0; i < words.size() - 1; i++) {
            actual = words.get(i);
            for(int j = i + 1; j < words.size(); j++) {
                other = words.get(j);
                for(int k = 0; k < actual.length(); k++) {
                    if(actual.charAt(k) == other.charAt(k)) {
                        countSameChars++;
                    }
                }

                if(countSameChars == actual.length() - 1) {
                    System.out.println("actual: " + actual + " , other: " + other);
                    printCommonChars(actual, other);
                }
                countSameChars = 0;
            }
        }
    }

    private void printCommonChars(String actual, String other) {
        System.out.print("Soulution: " );
        for(int i = 0; i < actual.length(); i++) {
            if(actual.charAt(i) == other.charAt(i)) {
                System.out.print(actual.charAt(i));
            }
        }
    }
}
