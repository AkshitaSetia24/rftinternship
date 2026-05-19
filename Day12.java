import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    String dept;
    int salary;

    Employee(int id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class Day12 {
    public static void main(String[] args) {

        String fileName = "data.csv";
        List<Employee> list = new ArrayList<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            br.readLine(); 

            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String dept = parts[2];
                    int salary = Integer.parseInt(parts[3]);

                    list.add(new Employee(id, name, dept, salary));

                } catch (Exception e) {
                    System.out.println("Invalid row skipped: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }

        
        Map<String, Integer> totalSalary = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (Employee emp : list) {

            
            if (totalSalary.containsKey(emp.dept)) {
                totalSalary.put(emp.dept, totalSalary.get(emp.dept) + emp.salary);
            } else {
                totalSalary.put(emp.dept, emp.salary);
            }

            
            if (count.containsKey(emp.dept)) {
                count.put(emp.dept, count.get(emp.dept) + 1);
            } else {
                count.put(emp.dept, 1);
            }
        }

        System.out.println("Average Salary per Department:");
        for (String dept : totalSalary.keySet()) {
            int avg = totalSalary.get(dept) / count.get(dept);
            System.out.println(dept + " : " + avg);
        }

        
        Employee maxEmp = null;

        for (Employee emp : list) {
            if (maxEmp == null || emp.salary > maxEmp.salary) {
                maxEmp = emp;
            }
        }

        if (maxEmp != null) {
            System.out.println("\nHighest Paid Employee:");
            System.out.println(maxEmp.name + " - " + maxEmp.salary);
        }

        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("report.txt"))) {

            bw.write("Average Salary per Department:\n");
            for (String dept : totalSalary.keySet()) {
                int avg = totalSalary.get(dept) / count.get(dept);
                bw.write(dept + " : " + avg + "\n");
            }

            bw.write("\nHighest Paid Employee:\n");
            if (maxEmp != null) {
                bw.write(maxEmp.name + " - " + maxEmp.salary);
            }

        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }
}