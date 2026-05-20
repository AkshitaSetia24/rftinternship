import java.io.*;
import java.util.*;

public class Day13 {

    public static void main(String[] args) {

        int errorCount = 0;
        int infoCount = 0;
        int warningCount = 0;

        List<String> errorLines = new ArrayList<>();

        try {
            File file = new File("log.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.startsWith("ERROR")) {
                    errorCount++;
                    errorLines.add(line);
                } 
                else if (line.startsWith("INFO")) {
                    infoCount++;
                } 
                else if (line.startsWith("WARNING")) {
                    warningCount++;
                }
            }

            sc.close();

            
            System.out.println("ERROR: " + errorCount);
            System.out.println("INFO: " + infoCount);
            System.out.println("WARNING: " + warningCount);

            
            String maxType = "ERROR";
            int max = errorCount;

            if (infoCount > max) {
                max = infoCount;
                maxType = "INFO";
            }

            if (warningCount > max) {
                max = warningCount;
                maxType = "WARNING";
            }

            System.out.println("\nMost Frequent Log: " + maxType);

            
            System.out.println("\nERROR Lines:");
            for (String s : errorLines) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}