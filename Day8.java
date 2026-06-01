import java.util.*;

public class Day8 {
    public static void main(String[] args) {

        
        int[] userIds = {101, 102, 103, 101, 104, 102};

        
        Set<Integer> uniqueUsers = new HashSet<>();

        
        int duplicateCount = 0;

        
        for (int id : userIds) {
            
            if (!uniqueUsers.add(id)) {
                duplicateCount++;
            }
        }

        
        System.out.println("Unique Users: " + uniqueUsers);
        System.out.println("Total Unique Visitors: " + uniqueUsers.size());

        
        System.out.println("Duplicate Entries Count: " + duplicateCount);
    }
}