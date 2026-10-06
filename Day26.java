import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    int id;
    String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Vehicle {
    String number;
    String model;

    Vehicle(String number, String model) {
        this.number = number;
        this.model = model;
    }
}

class Technician {
    int id;
    String name;

    Technician(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Service {
    int serviceId;
    Customer customer;
    Vehicle vehicle;
    Technician technician;
    String serviceType;
    int price;

    Service(int serviceId, Customer customer, Vehicle vehicle,
            Technician technician, String serviceType, int price) {

        this.serviceId = serviceId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.technician = technician;
        this.serviceType = serviceType;
        this.price = price;
    }

    void display() {
        System.out.println("\nService ID: " + serviceId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Vehicle: " + vehicle.model);
        System.out.println("Vehicle Number: " + vehicle.number);
        System.out.println("Technician: " + technician.name);
        System.out.println("Service Type: " + serviceType);
        System.out.println("Price: Rs." + price);
        System.out.println("-------------------------");
    }
}

class Invoice {

    void generate(Service service) {

        System.out.println("\n===== SERVICE INVOICE =====");
        System.out.println("Service ID: " + service.serviceId);
        System.out.println("Customer: " + service.customer.name);
        System.out.println("Vehicle: " + service.vehicle.model);
        System.out.println("Vehicle Number: " + service.vehicle.number);
        System.out.println("Service: " + service.serviceType);
        System.out.println("Technician: " + service.technician.name);
        System.out.println("Total Amount: Rs." + service.price);
        System.out.println("===========================");
    }
}

class ServiceCenter {

    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Service> services = new ArrayList<>();

    Technician technician =
            new Technician(1, "Rahul");

    Invoice invoice =
            new Invoice();

    // Register Customer
    void registerCustomer(Customer customer) {

        customers.add(customer);

        System.out.println(
                "Customer registered successfully!");
    }

    // Add Vehicle
    void addVehicle(Vehicle vehicle) {

        vehicles.add(vehicle);

        System.out.println(
                "Vehicle added successfully!");
    }

    // Schedule Service
    void scheduleService(int customerId,
                         String vehicleNumber,
                         String serviceType,
                         int price) {

        Customer customerFound = null;
        Vehicle vehicleFound = null;

        // Find Customer
        for (Customer customer : customers) {

            if (customer.id == customerId) {
                customerFound = customer;
                break;
            }
        }

        // Find Vehicle
        for (Vehicle vehicle : vehicles) {

            if (vehicle.number.equals(vehicleNumber)) {
                vehicleFound = vehicle;
                break;
            }
        }

        if (customerFound == null) {
            System.out.println("Customer not found!");
            return;
        }

        if (vehicleFound == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        int serviceId = services.size() + 1;

        Service service =
                new Service(serviceId,
                        customerFound,
                        vehicleFound,
                        technician,
                        serviceType,
                        price);

        services.add(service);

        System.out.println(
                "Service scheduled successfully!");
        System.out.println("Service ID: " + serviceId);
    }

    // Generate Invoice
    void generateInvoice(int serviceId) {

        for (Service service : services) {

            if (service.serviceId == serviceId) {

                invoice.generate(service);
                return;
            }
        }

        System.out.println("Service not found!");
    }

    // View Service History
    void serviceHistory() {

        if (services.size() == 0) {

            System.out.println(
                    "No service records found!");

            return;
        }

        System.out.println(
                "\n===== SERVICE HISTORY =====");

        for (Service service : services) {
            service.display();
        }
    }
}

public class Day26{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ServiceCenter center =
                new ServiceCenter();

        while (true) {

            System.out.println(
                    "\n===== VEHICLE SERVICE CENTER =====");

            System.out.println("1. Register Customer");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Schedule Service");
            System.out.println("4. Generate Invoice");
            System.out.println("5. View Service History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                Customer customer =
                        new Customer(id, name);

                center.registerCustomer(customer);

            }

            else if (choice == 2) {

                sc.nextLine();

                System.out.print("Enter Vehicle Number: ");
                String number = sc.nextLine();

                System.out.print("Enter Vehicle Model: ");
                String model = sc.nextLine();

                Vehicle vehicle =
                        new Vehicle(number, model);

                center.addVehicle(vehicle);

            }

            else if (choice == 3) {

                System.out.print("Enter Customer ID: ");
                int customerId = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Vehicle Number: ");
                String vehicleNumber = sc.nextLine();

                System.out.print("Enter Service Type: ");
                String serviceType = sc.nextLine();

                System.out.print("Enter Service Price: ");
                int price = sc.nextInt();

                center.scheduleService(
                        customerId,
                        vehicleNumber,
                        serviceType,
                        price);
            }

            else if (choice == 4) {

                System.out.print("Enter Service ID: ");
                int serviceId = sc.nextInt();

                center.generateInvoice(serviceId);
            }

            else if (choice == 5) {

                center.serviceHistory();
            }

            else if (choice == 6) {

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