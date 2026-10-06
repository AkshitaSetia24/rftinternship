import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks;

    // Constructor
    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getMarks() {
        return marks;
    }

    // Setters
    void setName(String name) {
        this.name = name;
    }

    void setMarks(int marks) {
        this.marks = marks;
    }

    // Display student
    void display() {
        System.out.println("ID: " + id +
                ", Name: " + name +
                ", Marks: " + marks);
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            // Add Student
            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();

                Student s = new Student(id, name, marks);
                students.add(s);

                System.out.println("Student added successfully!");

            }

            // Search Student
            else if (choice == 2) {

                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student s : students) {
                    if (s.getId() == id) {
                        s.display();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // Update Student
            else if (choice == 3) {

                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student s : students) {

                    if (s.getId() == id) {

                        sc.nextLine();

                        System.out.print("Enter new name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter new marks: ");
                        int marks = sc.nextInt();

                        s.setName(name);
                        s.setMarks(marks);

                        System.out.println("Student updated successfully!");
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // Delete Student
            else if (choice == 4) {

                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).getId() == id) {
                        students.remove(i);
                        System.out.println("Student deleted successfully!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // Display All Students
            else if (choice == 5) {

                if (students.size() == 0) {
                    System.out.println("No students available!");
                } else {

                    System.out.println("\nAll Students:");

                    for (Student s : students) {
                        s.display();
                    }
                }
            }

            // Exit
            else if (choice == 6) {

                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}