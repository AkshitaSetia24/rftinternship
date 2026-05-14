import java.util.*;

class Student {
    String name;
    int marks;

    Student(String n, int m) {
        name = n;
        marks = m;
    }
}

public class Day9 {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Aditya", 90));
        list.add(new Student("Bhavuk", 85));
        list.add(new Student("Chetan", 90));
        list.add(new Student("Daivik", 80));

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).marks < list.get(j).marks) {
                    Student temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        System.out.println("Ranking:");

        int rank = 1;

        for (int i = 0; i < list.size(); i++) {

            if (i > 0 && list.get(i).marks == list.get(i - 1).marks) {
            } else {
                rank = i + 1;
            }

            System.out.println("Rank " + rank + ": "
                    + list.get(i).name + " (" + list.get(i).marks + ")");
        }

        System.out.println("\nTop 3 Students:");

        int count = Math.min(3, list.size());

        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i).name + " (" + list.get(i).marks + ")");
        }
    }
}