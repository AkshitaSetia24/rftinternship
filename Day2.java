import java.util.Scanner;

class Calculator {
    int add(int x, int y) {
        return x + y;
    }

    int sub(int x, int y) {
        return x - y;
    }

    int mul(int x, int y) {
        return x * y;
    }

    int mod(int x, int y) {
        return x % y;
    }

    int pow(int x, int y) {
        return (int) Math.pow(x, y); 
    }
}

class CommandProcessor {
    Calculator cr = new Calculator();

    void process(String str) {
        String parts[] = str.split(" ");

        String command = parts[0];
        int a = Integer.parseInt(parts[1]);
        int b = Integer.parseInt(parts[2]);

        switch (command.toUpperCase()) {

            case "ADD":
                System.out.println("Result: " + cr.add(a, b));
                break;

            case "SUB":
                System.out.println("Result: " + cr.sub(a, b));
                break;

            case "MUL":
                System.out.println("Result: " + cr.mul(a, b));
                break;

            case "MOD":
                System.out.println("Result: " + cr.mod(a, b));
                break;

            case "POW":
                System.out.println("Result: " + cr.pow(a, b));
                break;

            default:
                System.out.println("Invalid Command ");
        }
    }
}

class Day2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CommandProcessor cp = new CommandProcessor();

        System.out.println("Enter command (type EXIT to stop):");

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("EXIT")) {
                break;
            }

            cp.process(input);
        }
    }
}