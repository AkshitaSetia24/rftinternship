import java.util.ArrayList;
import java.util.Scanner;

class Member {
    int id;
    String name;
    String plan;
    int price;
    int attendance;

    Member(int id, String name, String plan, int price) {
        this.id = id;
        this.name = name;
        this.plan = plan;
        this.price = price;
        this.attendance = 0;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Plan: " + plan);
        System.out.println("Price: Rs." + price);
        System.out.println("Attendance: " + attendance);
        System.out.println("----------------------");
    }
}

class Gym {

    ArrayList<Member> members = new ArrayList<>();

    // Register Member
    void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully!");
    }

    // Track Attendance
    void markAttendance(int id) {

        for (Member member : members) {

            if (member.id == id) {
                member.attendance++;
                System.out.println("Attendance marked successfully!");
                return;
            }
        }

        System.out.println("Member not found!");
    }

    // Generate Bill
    void generateBill(int id) {

        for (Member member : members) {

            if (member.id == id) {

                System.out.println("\n===== MEMBERSHIP BILL =====");
                System.out.println("Member ID: " + member.id);
                System.out.println("Member Name: " + member.name);
                System.out.println("Membership Plan: " + member.plan);
                System.out.println("Amount: Rs." + member.price);
                System.out.println("===========================");

                return;
            }
        }

        System.out.println("Member not found!");
    }

    // Renew Membership
    void renewMembership(int id) {

        for (Member member : members) {

            if (member.id == id) {

                System.out.println("Membership renewed successfully!");
                System.out.println("Plan: " + member.plan);

                return;
            }
        }

        System.out.println("Member not found!");
    }

    // Display Members
    void displayMembers() {

        if (members.size() == 0) {
            System.out.println("No members registered!");
            return;
        }

        System.out.println("\n===== MEMBER RECORDS =====");

        for (Member member : members) {
            member.display();
        }
    }
}

public class Day28 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Gym gym = new Gym();

        while (true) {

            System.out.println("\n===== GYM MEMBERSHIP SYSTEM =====");
            System.out.println("1. Register Member");
            System.out.println("2. Manage Membership Plan");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Generate Membership Bill");
            System.out.println("5. Renew Membership");
            System.out.println("6. Display Member Records");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Member ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Member Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Membership Plan: ");
                String plan = sc.nextLine();

                System.out.print("Enter Plan Price: ");
                int price = sc.nextInt();

                Member member =
                        new Member(id, name, plan, price);

                gym.registerMember(member);

            } 
            else if (choice == 2) {

                System.out.print("Enter Member ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Plan: ");
                String plan = sc.nextLine();

                System.out.print("Enter New Plan Price: ");
                int price = sc.nextInt();

                boolean found = false;

                for (Member member : gym.members) {

                    if (member.id == id) {
                        member.plan = plan;
                        member.price = price;

                        System.out.println(
                            "Membership plan updated successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Member not found!");
                }

            } 
            else if (choice == 3) {

                System.out.print("Enter Member ID: ");
                int id = sc.nextInt();

                gym.markAttendance(id);

            } 
            else if (choice == 4) {

                System.out.print("Enter Member ID: ");
                int id = sc.nextInt();

                gym.generateBill(id);

            } 
            else if (choice == 5) {

                System.out.print("Enter Member ID: ");
                int id = sc.nextInt();

                gym.renewMembership(id);

            } 
            else if (choice == 6) {

                gym.displayMembers();

            } 
            else if (choice == 7) {

                System.out.println("Thank you!");
                break;

            } 
            else {

                System.out.println("Invalid choice!");

            }
        }

        sc.close();
    }
}