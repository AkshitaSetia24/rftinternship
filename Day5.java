import java.util.*;

class Expense {
    private double amount;
    private String category;
    private String date; 

    public Expense(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Amount: ₹" + amount + ", Category: " + category + ", Date: " + date;
    }
}


class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();

    
    public void addExpense(double amount, String category, String date) {
        expenses.add(new Expense(amount, category, date));
        System.out.println("Expense added successfully!");
    }

    
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    
    public void calculateTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("Total Spending: ₹" + total);
    }

    
    public void categoryWiseSpending() {
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(e.getCategory(),
                    map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("Category-wise Spending:");
        for (String cat : map.keySet()) {
            System.out.println(cat + " : ₹" + map.get(cat));
        }
    }

    public void highestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }

        Expense max = expenses.get(0);
        for (Expense e : expenses) {
            if (e.getAmount() > max.getAmount()) {
                max = e;
            }
        }

        System.out.println("Highest Expense:");
        System.out.println(max);
    }

    public void monthlySummary() {
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(e.getDate(),
                    map.getOrDefault(e.getDate(), 0.0) + e.getAmount());
        }

        System.out.println("Monthly Summary:");
        for (String month : map.keySet()) {
            System.out.println(month + " : ₹" + map.get(month));
        }
    }
}

public class Day5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Spending");
            System.out.println("4. Category-wise Spending (Bonus)");
            System.out.println("5. Highest Expense (Bonus)");
            System.out.println("6. Monthly Summary (Bonus)");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM): ");
                    String date = sc.nextLine();

                    manager.addExpense(amount, category, date);
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    manager.calculateTotal();
                    break;

                case 4:
                    manager.categoryWiseSpending();
                    break;

                case 5:
                    manager.highestExpense();
                    break;

                case 6:
                    manager.monthlySummary();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}