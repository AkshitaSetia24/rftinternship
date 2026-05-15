import java.util.*;
class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("Name: " + name + ", Price: " + price + ", Quantity: " + quantity);
    }
}


public class Day10 {

    static HashMap<String, Product> inventory = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- INVENTORY MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. Search Product");
            System.out.println("4. Total Inventory Value");
            System.out.println("5. Remove Product");
            System.out.println("6. Low Stock Alert");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateQuantity(); break;
                case 3: searchProduct(); break;
                case 4: totalValue(); break;
                case 5: removeProduct(); break;
                case 6: lowStock(); break;
                case 7: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // 🔸 Add Product
    static void addProduct() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Product p = new Product(name, price, qty);
        inventory.put(name, p);

        System.out.println("Product added!");
    }

    // 🔸 Update Quantity
    static void updateQuantity() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        if (inventory.containsKey(name)) {
            System.out.print("Enter new quantity: ");
            int qty = sc.nextInt();

            inventory.get(name).quantity = qty;
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // 🔸 Search Product
    static void searchProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        if (inventory.containsKey(name)) {
            inventory.get(name).display();
        } else {
            System.out.println("Product not found!");
        }
    }

    // 🔸 Total Inventory Value
    static void totalValue() {
        double total = 0;

        for (Product p : inventory.values()) {
            total += p.price * p.quantity;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    // 🔸 Remove Product
    static void removeProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        if (inventory.remove(name) != null) {
            System.out.println("Product removed!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // 🔸 Low Stock Alert
    static void lowStock() {
        System.out.println("Low Stock Products (quantity < 5):");

        for (Product p : inventory.values()) {
            if (p.quantity < 5) {
                p.display();
            }
        }
    }
}