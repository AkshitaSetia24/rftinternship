import java.util.*;


class Question {
String question;
String[] options;
int correctAnswer;

Question(String question, String[] options, int correctAnswer) {  
    this.question = question;  
    this.options = options;  
    this.correctAnswer = correctAnswer;  
}

}


class Quiz {
List<Question> questions = new ArrayList<>();
List<Integer> userAnswers = new ArrayList<>();
int score = 0;

void addQuestion(Question q) {  
    questions.add(q);  
}  

void startQuiz() {  
    Scanner sc = new Scanner(System.in);  

      
    Collections.shuffle(questions);  

    int i = 1;  
    for (Question q : questions) {  
        System.out.println("\nQ" + i + ": " + q.question);  

        for (int j = 0; j < q.options.length; j++) {  
            System.out.println((j + 1) + ". " + q.options[j]);  
        }  

        System.out.print("Enter your answer (1-4): ");  
        int userAns = sc.nextInt();  

        userAnswers.add(userAns);  

          
        if (userAns == q.correctAnswer) {  
            System.out.println(" Correct!");  
            score++;  
        } else {  
            System.out.println(" Wrong! Correct answer: " + q.options[q.correctAnswer - 1]);  
        }  

        i++;  
    }  

      
    System.out.println("\n Your Score: " + score + "/" + questions.size());  

      
    double percentage = (score * 100.0) / questions.size();  
    System.out.println(" Percentage: " + percentage + "%");  

      
    System.out.println("\n Review:");  
    for (int j = 0; j < questions.size(); j++) {  
        Question q = questions.get(j);  
        int userAns = userAnswers.get(j);  

        System.out.println("\nQ: " + q.question);  
        System.out.println("Your Answer: " + q.options[userAns - 1]);  
        System.out.println("Correct Answer: " + q.options[q.correctAnswer - 1]);  
    }  

    sc.close();  
}

}


public class Day3 {
public static void main(String[] args) {

Quiz quiz = new Quiz();  

      
    quiz.addQuestion(new Question(  
            "What is Java?",  
            new String[]{"Programming Language", "Animal", "Car", "City"},  
            1));  

    quiz.addQuestion(new Question(  
            "Which keyword is used to inherit a class?",  
            new String[]{"this", "super", "extends", "implements"},  
            3));  

    quiz.addQuestion(new Question(  
            "Which method is entry point in Java?",  
            new String[]{"start()", "main()", "run()", "init()"},  
            2));  

    quiz.addQuestion(new Question(  
            "Which collection allows duplicates?",  
            new String[]{"Set", "Map", "List", "TreeSet"},  
            3));  

      
    quiz.startQuiz();  
}

}