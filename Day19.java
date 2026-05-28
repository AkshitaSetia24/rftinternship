import java.util.*;


class ChatSystem {
    List<String> history = new ArrayList<>();

    
    synchronized void send(String user, String msg) {
        String message = user + ": " + msg;
        history.add(message);
        System.out.println(message);
    }

    
    void showHistory() {
        System.out.println("\nChat History:");
        for (String m : history) {
            System.out.println(m);
        }
    }

    
    void filter(String user) {
        System.out.println("\nMessages by " + user + ":");
        for (String m : history) {
            if (m.startsWith(user)) {
                System.out.println(m);
            }
        }
    }
}


class User extends Thread {
    ChatSystem chat;
    String name;

    User(ChatSystem chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public void run() {
        try {
            chat.send(name, "Hello");
            Thread.sleep(1000);

            chat.send(name, "How are you?");
            Thread.sleep(1000);

            chat.send(name, "Bye");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


public class Day19 {
    public static void main(String[] args) throws Exception {

        ChatSystem chat = new ChatSystem();

        User u1 = new User(chat, "Akshita");
        User u2 = new User(chat, "Rahul");

        u1.start();
        u2.start();

        u1.join();
        u2.join();

        
        chat.showHistory();
        chat.filter("Akshita");
    }
}