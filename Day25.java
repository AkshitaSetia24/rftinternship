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

class Question {
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;

    Question(String question, String optionA, String optionB,
             String optionC, String optionD, String answer) {

        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }

    void display() {
        System.out.println("\n" + question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
    }
}

class Quiz {

    ArrayList<Question> questions = new ArrayList<>();

    void addQuestion(Question question) {
        questions.add(question);
    }

    int startQuiz(Scanner sc) {

        int score = 0;

        System.out.println("\n===== QUIZ STARTED =====");

        for (Question question : questions) {

            question.display();

            System.out.print("Enter your answer: ");
            String userAnswer = sc.next();

            if (userAnswer.equalsIgnoreCase(question.answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        return score;
    }
}

class Result {

    Student student;
    int score;
    int total;

    Result(Student student, int score, int total) {
        this.student = student;
        this.score = score;
        this.total = total;
    }

    void displayResult() {

        System.out.println("\n===== RESULT SUMMARY =====");
        System.out.println("Student ID: " + student.id);
        System.out.println("Student Name: " + student.name);
        System.out.println("Score: " + score + "/" + total);

        if (score >= total / 2) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

public class Day25 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        Quiz quiz = new Quiz();

        // Adding Questions

        quiz.addQuestion(new Question(
                "Which language is used for Android development?",
                "Java",
                "HTML",
                "CSS",
                "SQL",
                "A"
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used to create a class in Java?",
                "function",
                "class",
                "object",
                "new",
                "B"
        ));

        quiz.addQuestion(new Question(
                "Which collection is used to store multiple objects?",
                "ArrayList",
                "Scanner",
                "String",
                "System",
                "A"
        ));

        quiz.addQuestion(new Question(
                "Which method is the starting point of a Java program?",
                "start()",
                "run()",
                "main()",
                "begin()",
                "C"
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used to create an object?",
                "class",
                "new",
                "this",
                "void",
                "B"
        ));

        System.out.println("\n===== ONLINE QUIZ SYSTEM =====");
        System.out.println("1. Start Quiz");
        System.out.println("2. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            int score = quiz.startQuiz(sc);

            Result result =
                    new Result(student, score, quiz.questions.size());

            result.displayResult();

        } else {

            System.out.println("Thank you!");

        }

        sc.close();
    }
}