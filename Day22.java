import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title);
    }
}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Library {

    ArrayList<Book> books = new ArrayList<>();

    // Add Book
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Search Book
    void searchBook(int id) {

        boolean found = false;

        for (Book book : books) {
            if (book.id == id) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Issue Book
    void issueBook(int id) {

        for (Book book : books) {

            if (book.id == id) {

                if (book.issued == false) {
                    book.issued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Return Book
    void returnBook(int id) {

        for (Book book : books) {

            if (book.id == id) {

                if (book.issued == true) {
                    book.issued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Display Available Books
    void displayAvailableBooks() {

        System.out.println("\nAvailable Books:");

        for (Book book : books) {

            if (book.issued == false) {
                book.display();
            }
        }
    }

    // Display Issued Books
    void displayIssuedBooks() {

        System.out.println("\nIssued Books:");

        for (Book book : books) {

            if (book.issued == true) {
                book.display();
            }
        }
    }
}

public class Day22{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add New Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Issued Books");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                Book book = new Book(id, title);

                library.addBook(book);

            } 
            else if (choice == 2) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                library.issueBook(id);

            } 
            else if (choice == 3) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                library.returnBook(id);

            } 
            else if (choice == 4) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                library.searchBook(id);

            } 
            else if (choice == 5) {

                library.displayAvailableBooks();

            } 
            else if (choice == 6) {

                library.displayIssuedBooks();

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