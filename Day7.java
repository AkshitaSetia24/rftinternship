import java.util.*;

public class Day7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        input = input.toLowerCase();

        String[] words = input.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        
        System.out.println("\nWord Frequencies:");
        for (String word : map.keySet()) {
            System.out.println(word + " : " + map.get(word));
        }

        
        int maxCount = Collections.max(map.values());

        
        System.out.print("\nMost Frequent Word(s): ");
        for (String word : map.keySet()) {
            if (map.get(word) == maxCount) {
                System.out.print(word + " ");
            }
        }

        System.out.println("(" + maxCount + " times)");

        sc.close();
    }
}