import java.util.*;


class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}


class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    
    public void addContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully!");
    }

    
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    
    public void searchContact(String name) {
        boolean found = false;

        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found: " + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    
    public void deleteContact(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully!");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }
}


public class Day6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact (Bonus)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    manager.addContact(name, phone);
                    break;

                case 2:
                    manager.displayContacts();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    manager.searchContact(searchName);
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    manager.deleteContact(deleteName);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}