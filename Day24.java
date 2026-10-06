import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int price;
    int quantity;

    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    void display() {
        System.out.println("ID: " + id +
                ", Name: " + name +
                ", Price: Rs." + price +
                ", Quantity: " + quantity);
    }
}

class Customer {
    int id;
    String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Cart {

    ArrayList<Product> products = new ArrayList<>();

    // Add Product
    void addProduct(Product product, int quantity) {
        product.quantity = quantity;
        products.add(product);

        System.out.println("Product added to cart!");
    }

    // Remove Product
    void removeProduct(int id) {

        for (Product product : products) {

            if (product.id == id) {
                products.remove(product);
                System.out.println("Product removed!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // Update Quantity
    void updateQuantity(int id, int quantity) {

        for (Product product : products) {

            if (product.id == id) {
                product.quantity = quantity;
                System.out.println("Quantity updated!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // Calculate Total
    int calculateTotal() {

        int total = 0;

        for (Product product : products) {
            total = total + (product.price * product.quantity);
        }

        return total;
    }

    // Display Cart
    void displayCart() {

        System.out.println("\n===== Shopping Cart =====");

        if (products.size() == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        for (Product product : products) {
            product.display();
        }

        System.out.println("Total Bill: Rs." + calculateTotal());
    }
}

class Order {

    int orderId;
    Customer customer;
    Cart cart;

    Order(int orderId, Customer customer, Cart cart) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
    }

    // Generate Invoice
    void generateInvoice() {

        System.out.println("\n===== INVOICE =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.name);

        cart.displayCart();

        System.out.println("Final Amount: Rs."
                + cart.calculateTotal());

        System.out.println("Thank you for shopping!");
    }
}

public class Day24{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> productList = new ArrayList<>();

        // Products
        productList.add(new Product(1, "Laptop", 50000));
        productList.add(new Product(2, "Mobile", 20000));
        productList.add(new Product(3, "Headphones", 2000));
        productList.add(new Product(4, "Keyboard", 1500));

        Cart cart = new Cart();

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        Customer customer = new Customer(id, name);

        while (true) {

            System.out.println("\n===== Online Shopping Cart =====");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Display Cart");
            System.out.println("6. Generate Invoice");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("\nAvailable Products:");

                for (Product product : productList) {
                    product.display();
                }

            } else if (choice == 2) {

                System.out.print("Enter Product ID: ");
                int productId = sc.nextInt();

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();

                boolean found = false;

                for (Product product : productList) {

                    if (product.id == productId) {
                        cart.addProduct(product, quantity);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product not found!");
                }

            } else if (choice == 3) {

                System.out.print("Enter Product ID: ");
                int productId = sc.nextInt();

                cart.removeProduct(productId);

            } else if (choice == 4) {

                System.out.print("Enter Product ID: ");
                int productId = sc.nextInt();

                System.out.print("Enter New Quantity: ");
                int quantity = sc.nextInt();

                cart.updateQuantity(productId, quantity);

            } else if (choice == 5) {

                cart.displayCart();

            } else if (choice == 6) {

                Order order = new Order(101, customer, cart);

                order.generateInvoice();

            } else if (choice == 7) {

                System.out.println("Thank you!");
                break;

            } else {

                System.out.println("Invalid choice!");

            }
        }

        sc.close();
    }
}