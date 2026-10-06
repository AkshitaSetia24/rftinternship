import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Course {
    int courseId;
    String courseName;
    int capacity;

    Course(int courseId, String courseName, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
    }

    void display() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("-------------------------");
    }
}

class Enrollment {
    Student student;
    Course course;

    Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    void display() {
        System.out.println("Student: " + student.name);
        System.out.println("Student ID: " + student.id);
        System.out.println("Course: " + course.courseName);
        System.out.println("-------------------------");
    }
}

class CourseRegistration {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Enrollment> enrollments = new ArrayList<>();

    // Student Registration
    void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    // Course Creation
    void createCourse(Course course) {
        courses.add(course);
        System.out.println("Course created successfully!");
    }

    // Enroll Student
    void enrollStudent(int studentId, int courseId) {

        Student student = null;
        Course course = null;

        for (Student s : students) {
            if (s.id == studentId) {
                student = s;
                break;
            }
        }

        for (Course c : courses) {
            if (c.courseId == courseId) {
                course = c;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        int count = 0;

        for (Enrollment e : enrollments) {
            if (e.course.courseId == courseId) {
                count++;
            }

            if (e.student.id == studentId &&
                e.course.courseId == courseId) {
                System.out.println("Student already enrolled!");
                return;
            }
        }

        if (count >= course.capacity) {
            System.out.println("Course is full!");
            return;
        }

        Enrollment enrollment =
                new Enrollment(student, course);

        enrollments.add(enrollment);

        System.out.println("Student enrolled successfully!");
    }

    // Drop Course
    void dropCourse(int studentId, int courseId) {

        for (Enrollment e : enrollments) {

            if (e.student.id == studentId &&
                e.course.courseId == courseId) {

                enrollments.remove(e);

                System.out.println("Course dropped successfully!");
                return;
            }
        }

        System.out.println("Enrollment not found!");
    }

    // Display Enrolled Courses
    void displayEnrolledCourses(int studentId) {

        boolean found = false;

        System.out.println("\n===== ENROLLED COURSES =====");

        for (Enrollment e : enrollments) {

            if (e.student.id == studentId) {

                System.out.println("Course ID: "
                        + e.course.courseId);

                System.out.println("Course Name: "
                        + e.course.courseName);

                System.out.println("-------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No courses enrolled!");
        }
    }

    // Enrollment Summary
    void enrollmentSummary() {

        if (enrollments.size() == 0) {
            System.out.println("No enrollments found!");
            return;
        }

        System.out.println("\n===== ENROLLMENT SUMMARY =====");

        for (Enrollment e : enrollments) {
            e.display();
        }
    }

    // Display All Courses
    void displayCourses() {

        System.out.println("\n===== AVAILABLE COURSES =====");

        if (courses.size() == 0) {
            System.out.println("No courses available!");
            return;
        }

        for (Course c : courses) {
            c.display();
        }
    }
}

public class Day30{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CourseRegistration system =
                new CourseRegistration();

        while (true) {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Drop Course");
            System.out.println("5. Display Enrolled Courses");
            System.out.println("6. Generate Enrollment Summary");
            System.out.println("7. Display All Courses");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                Student student =
                        new Student(id, name);

                system.registerStudent(student);

            } else if (choice == 2) {

                System.out.print("Enter Course ID: ");
                int courseId = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Course Name: ");
                String courseName = sc.nextLine();

                System.out.print("Enter Course Capacity: ");
                int capacity = sc.nextInt();

                Course course =
                        new Course(courseId, courseName, capacity);

                system.createCourse(course);

            } else if (choice == 3) {

                System.out.print("Enter Student ID: ");
                int studentId = sc.nextInt();

                System.out.print("Enter Course ID: ");
                int courseId = sc.nextInt();

                system.enrollStudent(studentId, courseId);

            } else if (choice == 4) {

                System.out.print("Enter Student ID: ");
                int studentId = sc.nextInt();

                System.out.print("Enter Course ID: ");
                int courseId = sc.nextInt();

                system.dropCourse(studentId, courseId);

            } else if (choice == 5) {

                System.out.print("Enter Student ID: ");
                int studentId = sc.nextInt();

                system.displayEnrolledCourses(studentId);

            } else if (choice == 6) {

                system.enrollmentSummary();

            } else if (choice == 7) {

                system.displayCourses();

            } else if (choice == 8) {

                System.out.println("Thank you!");
                System.out.println("Internship Journey Completed! 🎉");
                break;

            } else {

                System.out.println("Invalid choice!");

            }
        }

        sc.close();
    }
}