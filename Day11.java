import java.io.*;
import java.util.*;

public class Day11 {

    public static void main(String[] args) {

        int lines = 0, words = 0;
        String longestWord = "";

        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                lines++;

                
                line = line.toLowerCase();
                line = line.replaceAll("[^a-zA-Z ]", "");

                String[] arr = line.split("\\s+");

                for (String w : arr) {
                    if (w.equals("")) continue;

                    words++;

                    
                    if (map.containsKey(w)) {
                        int count = map.get(w);
                        map.put(w, count + 1);
                    } else {
                        map.put(w, 1);
                    }

                    
                    if (w.length() > longestWord.length()) {
                        longestWord = w;
                    }
                }
            }

            br.close();

            
            String maxWord = "";
            int max = 0;

            for (String key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    maxWord = key;
                }
            }

            
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((a, b) -> b.getValue() - a.getValue());

            
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Most Frequent Word: " + maxWord);
            System.out.println("Longest Word: " + longestWord);

            System.out.println("\nTop 5 Words:");
            for (int i = 0; i < list.size() && i < 5; i++) {
                System.out.println(list.get(i).getKey() + " -> " + list.get(i).getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}