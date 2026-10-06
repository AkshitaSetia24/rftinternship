import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    int totalLeave;
    int usedLeave;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalLeave = 20;
        this.usedLeave = 0;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Leave: " + totalLeave);
        System.out.println("Used Leave: " + usedLeave);
        System.out.println("Remaining Leave: " +
                (totalLeave - usedLeave));
        System.out.println("-------------------------");
    }
}

class LeaveRequest {
    int leaveId;
    Employee employee;
    int days;
    String status;

    LeaveRequest(int leaveId, Employee employee, int days) {
        this.leaveId = leaveId;
        this.employee = employee;
        this.days = days;
        this.status = "Pending";
    }

    void display() {
        System.out.println("Leave ID: " + leaveId);
        System.out.println("Employee: " + employee.name);
        System.out.println("Leave Days: " + days);
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }
}

class LeaveManagement {

    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<LeaveRequest> leaves = new ArrayList<>();

    // Employee Registration
    void registerEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee registered successfully!");
    }

    // Apply for Leave
    void applyLeave(int employeeId, int days) {

        for (Employee employee : employees) {

            if (employee.id == employeeId) {

                int remaining =
                        employee.totalLeave - employee.usedLeave;

                if (days <= remaining) {

                    int leaveId = leaves.size() + 1;

                    LeaveRequest leave =
                            new LeaveRequest(leaveId, employee, days);

                    leaves.add(leave);

                    System.out.println(
                            "Leave request submitted successfully!");
                    System.out.println("Leave ID: " + leaveId);

                } else {
                    System.out.println("Not enough leave balance!");
                }

                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Approve Leave
    void approveLeave(int leaveId) {

        for (LeaveRequest leave : leaves) {

            if (leave.leaveId == leaveId) {

                if (leave.status.equals("Pending")) {

                    leave.status = "Approved";
                    leave.employee.usedLeave =
                            leave.employee.usedLeave + leave.days;

                    System.out.println("Leave approved successfully!");

                } else {
                    System.out.println("Leave already processed!");
                }

                return;
            }
        }

        System.out.println("Leave request not found!");
    }

    // Reject Leave
    void rejectLeave(int leaveId) {

        for (LeaveRequest leave : leaves) {

            if (leave.leaveId == leaveId) {

                if (leave.status.equals("Pending")) {

                    leave.status = "Rejected";

                    System.out.println("Leave rejected!");

                } else {
                    System.out.println("Leave already processed!");
                }

                return;
            }
        }

        System.out.println("Leave request not found!");
    }

    // View Leave History
    void leaveHistory() {

        if (leaves.size() == 0) {
            System.out.println("No leave requests found!");
            return;
        }

        System.out.println("\n===== LEAVE HISTORY =====");

        for (LeaveRequest leave : leaves) {
            leave.display();
        }
    }

    // Leave Balance
    void leaveBalance(int employeeId) {

        for (Employee employee : employees) {

            if (employee.id == employeeId) {

                int remaining =
                        employee.totalLeave - employee.usedLeave;

                System.out.println("\n===== LEAVE BALANCE =====");
                System.out.println("Employee: " + employee.name);
                System.out.println("Total Leave: "
                        + employee.totalLeave);
                System.out.println("Used Leave: "
                        + employee.usedLeave);
                System.out.println("Remaining Leave: "
                        + remaining);

                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Leave Report
    void leaveReport() {

        System.out.println("\n===== LEAVE REPORT =====");

        for (Employee employee : employees) {
            employee.display();
        }
    }
}

public class Day29{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LeaveManagement system =
                new LeaveManagement();

        while (true) {

            System.out.println("\n===== EMPLOYEE LEAVE MANAGEMENT =====");
            System.out.println("1. Register Employee");
            System.out.println("2. Apply for Leave");
            System.out.println("3. Approve Leave");
            System.out.println("4. Reject Leave");
            System.out.println("5. View Leave History");
            System.out.println("6. View Leave Balance");
            System.out.println("7. Generate Leave Report");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                Employee employee =
                        new Employee(id, name);

                system.registerEmployee(employee);

            } 
            else if (choice == 2) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Leave Days: ");
                int days = sc.nextInt();

                system.applyLeave(id, days);

            } 
            else if (choice == 3) {

                System.out.print("Enter Leave ID: ");
                int leaveId = sc.nextInt();

                system.approveLeave(leaveId);

            } 
            else if (choice == 4) {

                System.out.print("Enter Leave ID: ");
                int leaveId = sc.nextInt();

                system.rejectLeave(leaveId);

            } 
            else if (choice == 5) {

                system.leaveHistory();

            } 
            else if (choice == 6) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                system.leaveBalance(id);

            } 
            else if (choice == 7) {

                system.leaveReport();

            } 
            else if (choice == 8) {

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