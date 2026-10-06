import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNo;
    String type;
    int price;
    boolean booked;

    Room(int roomNo, String type, int price) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        this.booked = false;
    }

    void display() {
        System.out.println("Room No: " + roomNo +
                ", Type: " + type +
                ", Price: Rs." + price);
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

class Booking {
    int bookingId;
    Customer customer;
    Room room;
    int days;

    Booking(int bookingId, Customer customer, Room room, int days) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.days = days;
    }

    void bill() {
        int total = room.price * days;

        System.out.println("\n===== Hotel Bill =====");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Room No: " + room.roomNo);
        System.out.println("Days: " + days);
        System.out.println("Total Bill: Rs." + total);
    }
}

class Hotel {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    // Add Room
    void addRoom(Room room) {
        rooms.add(room);
    }

    // Display Available Rooms
    void availableRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            if (room.booked == false) {
                room.display();
            }
        }
    }

    // Book Room
    void bookRoom(int roomNo, Customer customer, int days) {

        for (Room room : rooms) {

            if (room.roomNo == roomNo) {

                if (room.booked == false) {

                    room.booked = true;

                    int bookingId = bookings.size() + 1;

                    Booking booking =
                            new Booking(bookingId, customer, room, days);

                    bookings.add(booking);

                    System.out.println("Room booked successfully!");
                    System.out.println("Booking ID: " + bookingId);

                } else {
                    System.out.println("Room is already booked!");
                }

                return;
            }
        }

        System.out.println("Room not found!");
    }

    // Check-in
    void checkIn(int bookingId) {
        System.out.println("Customer checked-in successfully!");
    }

    // Check-out
    void checkOut(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.bookingId == bookingId) {

                booking.room.booked = false;

                System.out.println("Customer checked-out successfully!");

                booking.bill();
                return;
            }
        }

        System.out.println("Booking not found!");
    }
}

public class Day23{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        // Adding rooms
        hotel.addRoom(new Room(101, "Single", 1000));
        hotel.addRoom(new Room(102, "Double", 1500));
        hotel.addRoom(new Room(103, "Deluxe", 2500));

        while (true) {

            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                hotel.availableRooms();

            } else if (choice == 2) {

                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Room Number: ");
                int roomNo = sc.nextInt();

                System.out.print("Enter Number of Days: ");
                int days = sc.nextInt();

                Customer customer = new Customer(id, name);

                hotel.bookRoom(roomNo, customer, days);

            } else if (choice == 3) {

                System.out.print("Enter Booking ID: ");
                int bookingId = sc.nextInt();

                hotel.checkIn(bookingId);

            } else if (choice == 4) {

                System.out.print("Enter Booking ID: ");
                int bookingId = sc.nextInt();

                hotel.checkOut(bookingId);

            } else if (choice == 5) {

                System.out.println("Thank you!");
                break;

            } else {

                System.out.println("Invalid choice!");

            }
        }

        sc.close();
    }
}