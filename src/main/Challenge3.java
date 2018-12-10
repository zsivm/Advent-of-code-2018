package main;

/*
    --- Day 3: No Matter How You Slice It ---
    --- Part One ---

    The Elves managed to locate the chimney-squeeze prototype fabric for Santa's suit
    (thanks to someone who helpfully wrote its box IDs on the wall of the warehouse in the middle of the night).
    Unfortunately, anomalies are still affecting them - nobody can even agree on how to cut the fabric.

    The whole piece of fabric they're working on is a very large square - at least 1000 inches on each side.

    Each Elf has made a claim about which area of fabric would be ideal for Santa's suit.
    All claims have an ID and consist of a single rectangle with edges parallel to the edges of the fabric.
    Each claim's rectangle is defined as follows:

    The number of inches between the left edge of the fabric and the left edge of the rectangle.
    The number of inches between the top edge of the fabric and the top edge of the rectangle.
    The width of the rectangle in inches.
    The height of the rectangle in inches.

    A claim like #123 @ 3,2: 5x4 means that claim ID 123 specifies a rectangle 3 inches from the left edge,
    2 inches from the top edge, 5 inches wide, and 4 inches tall. Visually,
    it claims the square inches of fabric represented by # (and ignores the square inches of fabric represented by .)
    in the diagram below:

    ...........
    ...........
    ...#####...
    ...#####...
    ...#####...
    ...#####...
    ...........
    ...........
    ...........

    The problem is that many of the claims overlap, causing two or more claims to
    cover part of the same areas. For example, consider the following claims:

    #1 @ 1,3: 4x4
    #2 @ 3,1: 4x4
    #3 @ 5,5: 2x2
    Visually, these claim the following areas:

    ........
    ...2222.
    ...2222.
    .11XX22.
    .11XX22.
    .111133.
    .111133.
    ........

    The four square inches marked with X are claimed by both 1 and 2.
    (Claim 3, while adjacent to the others, does not overlap either of them.)

    If the Elves all proceed with their own plans, none of them will have enough fabric.
    How many square inches of fabric are within two or more claims?

    --- Part Two ---
    Amidst the chaos, you notice that exactly one claim doesn't overlap by even a single square inch of fabric with any other claim.
    If you can somehow draw attention to it, maybe the Elves will be able to make Santa's suit after all!

    For example, in the claims above, only claim 3 is intact after all claims are made.

    What is the ID of the only claim that doesn't overlap?
 */


import java.util.Scanner;

public class Challenge3 extends FileReader {

    int id, left, top, width, height;
    int dimension = 1000;
    String[][] matrix = new String[dimension][dimension];

    public Challenge3(String fileName) {
        super(fileName);
    }

    public int countArea() {
        Scanner sc = readFile();

        initializeMatrix();

        while(sc.hasNextLine()) {
            processRow(sc.nextLine());

            for(int i = top; i < top + height; i++) {
                for(int j = left; j < left + width; j++) {
                    if(matrix[i][j].equals(".")) {
                        matrix[i][j] = "O";
                    } else if (matrix[i][j].equals("O")){
                        matrix[i][j] = "#";
                    }
                }
            }
        }

        //printMatrix();

        return usedArea();

    }

    public int smartId() {
        Scanner sc = readFile();

        boolean isFlawless;

        while(sc.hasNextLine()) {

            processRow(sc.nextLine());
            isFlawless = true;

            for(int i = top; i < top + height; i++) {
                for(int j = left; j < left + width; j++) {
                    if(matrix[i][j].equals("#")) {
                        isFlawless = false;
                    }
                }
            }

            if(isFlawless) {
                return id;
            }
        }

        return -1;
    }

    private int usedArea() {

        int area = 0;

        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                if(matrix[i][j].equals("#")) {
                    area++;
                }
            }
        }

        return area;
    }

    private void processRow(String line) {
        Scanner sc = new Scanner(line);

        id = sc.useDelimiter("[^\\d]+").nextInt();
        left = sc.useDelimiter("[^\\d]+").nextInt();
        top = sc.useDelimiter("[^\\d]+").nextInt();
        width = sc.useDelimiter("[^\\d]+").nextInt();
        height = sc.useDelimiter("[^\\d]+").nextInt();
    }

    private void initializeMatrix() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                matrix[i][j] = ".";
            }
        }

        // printMatrix();
    }

    private void printMatrix() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}
