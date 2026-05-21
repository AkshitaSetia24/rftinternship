import java.io.*;
import java.util.*;

public class Day14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();

        System.out.print("Enter word to search: ");
        String searchWord = input.nextLine().toLowerCase();

        int count = 0;
        int lineNumber = 0;

        List<Integer> linesFound = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineNumber++;

                String lowerLine = line.toLowerCase();

                if (lowerLine.contains(searchWord)) {

                    linesFound.add(lineNumber);

                    int index = 0;
                    while ((index = lowerLine.indexOf(searchWord, index)) != -1) {
                        count++;
                        index += searchWord.length();
                    }
                }
            }

            sc.close();

            System.out.println("\n===== RESULT =====");

            if (count > 0) {
                System.out.println("Word found " + count + " times");
                System.out.println("Found in lines: " + linesFound);
            } else {
                System.out.println("Word not found!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        input.close();
    }
}