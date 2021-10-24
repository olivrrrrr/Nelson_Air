import airline.NelsonAir;
import customer.Customer;
import customer.CustomerDatabase;
import customer.CustomerService;
import flight.Flight;
import ticket.Ticket;

import java.util.Scanner;

import static java.lang.Float.NaN;

public class Main {
    public static void main(String[] args) {


        //System says: Hello, welcome which option would you like to chose today:

        //Option 0: Create new account (i.e. create new person)


        //Option 1: Add a new flight [y/n] (with flightservice class)


        //Option 2: Display all flights
        //Within customerService logic

        //Option 3: Display flights that you can book

        //Option 4: Display flights for a specific user
        //Enter user ID
        //Search for customer within a customer array (might want to create a new customerList class) using their ID
        //Add a new property in customers which is an array of flights
        //new method to add and remove flights from list for that customer


        //Option 5: Book a flight for a user using his id
        //Search for customer within customer array using their I.D
        //call add booking method from customer service class

        //Option 6: Cancel a flight for a user using his id
        //Search for customer within customer array using their I.D
        //call add booking method from customer service class

        // while loop
        // Create new account/person:
        // System in: We need your name ?
        // System in: We need email ?
        // System in: We need your id?
        // function that adds customer to an array in the customer list class
        // System out: are you done for today ? [y/n]
        CustomerDatabase customerDatabase = new CustomerDatabase();
        CustomerService customerService = new CustomerService();
        NelsonAir nelsonAir = new NelsonAir();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want make an account ?");
        String reply = scanner.nextLine();
        if (reply.equals("yes")) {
            System.out.println("What is your name ?");
            String name = scanner.nextLine();
            System.out.println("What is your passport number ?");
            String passportNumber = scanner.nextLine();
            System.out.println("What is your mobile number ?");
            String mobileNumber = scanner.nextLine();
            System.out.println("What is your email ?");
            String email = scanner.nextLine();
            Customer newCustomer = new Customer(name, passportNumber, mobileNumber,email);
            System.out.println(customerService.addCustomerToDatabase(newCustomer, customerDatabase));
        }

        System.out.println("Would you like to buy a ticket ?");
        if(reply.equals("yes")){
            System.out.println("What is your passport number");
            String inputtedPassportNumber = scanner.nextLine();
            Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
            if(currentCustomer.getPassportNumber().equals(null)){
                System.out.println("You are not on the system !");
            } else {
                System.out.println("Please enter the flight number");
                int inputtedFlightNumber = scanner.nextInt();
                Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
                if(chosenFlight.getFlightNum() == 0){
                    System.out.println("Flight was not found");
                } else {
                    System.out.println(chosenFlight);
                    customerService.makeBooking(currentCustomer, chosenFlight);
                    customerService.makeTicket(currentCustomer, chosenFlight);
                }
            }
        }

        System.out.println("Would you like to cancel a booking ?");
        if(reply.equals("yes")){
            System.out.println("What is your passport number");
            String inputtedPassportNumber = scanner.nextLine();
            Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
            if(currentCustomer.getPassportNumber().equals(null)){
                System.out.println("You are not on the system !");
            } else {
                System.out.println("Please enter the flight number");
                int inputtedFlightNumber = scanner.nextInt();
                Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
                if(chosenFlight.getFlightNum() == 0){
                    System.out.println("Flight was not found");
                } else {
                    System.out.println(chosenFlight);
                    Ticket ticket = customerService.findTicket(currentCustomer, chosenFlight);
                    if (ticket.getFlightNumber() == 0) {
                        System.out.println("Booking not found");
                    }
                    else {
                        customerService.cancelBooking(currentCustomer, chosenFlight, ticket);
                        System.out.println("Booking has been cancelled");
                    }
                }
            }
        }
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Welcome to Nelson Air. Would you like to create an account ?");
//            String accountCreation = scanner.nextLine();

                // Book your ticket
               ;
                // do we need two ids, change number to mobileNumber and needs to be an int ?
                // can you initialise a person without a ticket and then push later ? (later)



        // if y:
        // System out: Would like all flight ?
        // Option 1 - display all flights
        // Option 2 - display all flights you can book

        // Display flights for a specific user
        // System in: What is your id ?
        // Search through customer list find customer obj
        // Get flight array from customer class - n.b. need to add
        //



    }
}
