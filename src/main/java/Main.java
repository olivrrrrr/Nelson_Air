import airline.NelsonAir;
import customer.Customer;
import customer.CustomerDatabase;
import customer.CustomerService;
import flight.*;
import ticket.Ticket;

import java.time.LocalDate;
import java.time.Month;
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

        //START OF MAIN

        //Initialise new variables for the CLI
        CustomerDatabase customerDatabase = new CustomerDatabase();
        CustomerService customerService = new CustomerService();
        NelsonAir nelsonAir = new NelsonAir();
        Scanner scanner = new Scanner(System.in);
        FlightService flightService = new FlightService();

        //Flight for testing purposes
        Flight newFlight = new Flight(LocalDate.of(2021, Month.OCTOBER, 25), 123, FlightStatus.ONTIME, Location.LONDON, Location.LISBON, PlaneModelType.CONCORD, 50,  0);
        flightService.addFlightToNelsonAir(newFlight, nelsonAir);
        Customer Oli = new Customer("Oli", "1234", "111", "oliverekwalla@gmail.com");
        customerService.addCustomerToDatabase(Oli, customerDatabase);
// Adding a flight to Oli
        customerService.makeBooking(Oli, newFlight);
        customerService.makeTicket(Oli, newFlight);
        //Entry point to Command Line Interface
        System.out.println("If you are a customer, press 1. If you are a staff member, press 2");
        //Variable to store response
        String response = scanner.nextLine();
        //Logic for customer
        if (response.equals("1")) {
            String option = "";
            do {
                System.out.println("If you wish to exit, press 0 " +
                        ". If you wish to create an account press 1" +
                        ". If you wish to see all available flights, press 2" +
                        ". If you wish to make a booking, press 3" +
                        ". If you wish to cancel a booking, press 4" +
                        ". If you would like to see your flights, press 5");
                option = scanner.nextLine();
                if (option.equals("1")) {
                    //Logic to create an account
                    //Oli
                    System.out.println("What is your name ?");
                    String name = scanner.nextLine();
                    System.out.println("What is your passport number ?");
                    String passportNumber = scanner.nextLine();
                    System.out.println("What is your mobile number ?");
                    String mobileNumber = scanner.nextLine();
                    System.out.println("What is your email ?");
                    String email = scanner.nextLine();
                    Customer newCustomer = new Customer(name, passportNumber, mobileNumber, email);
                    //Add the customer to the database
                    System.out.println(customerService.addCustomerToDatabase(newCustomer, customerDatabase));
                }
                else if (option.equals("2")) {
                    //Logic to see all available flights
                    customerService.displayAvailableFlights(nelsonAir);

                }
                else if (option.equals("3")) {
                    //Logic to make a booking
                    //Oli
                    System.out.println("What is your passport number");
                    String inputtedPassportNumber = scanner.nextLine();
                    Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
                    if (currentCustomer.getPassportNumber() == null) {
                        System.out.println("You are not on the system !");
                    } else {
                        System.out.println("Please enter the flight number");
                        int inputtedFlightNumber = scanner.nextInt();
                        Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
                        if (chosenFlight.getFlightNum() == 0) {
                            System.out.println("Flight was not found");
                        } else {
                            System.out.println(chosenFlight + "You have successfully booked");
                            customerService.makeBooking(currentCustomer, chosenFlight);
                            customerService.makeTicket(currentCustomer, chosenFlight);
                        }
                    }
                }
                else if (option.equals("4")) {
                    //Logic to cancel a booking
                    //Oli
                    System.out.println("What is your passport number");
                    String inputtedPassportNumber = scanner.nextLine();
                    Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
                    if (currentCustomer.getPassportNumber() == null) {
                        System.out.println("Your account was not found on the system");
                    }
                    else {
                        System.out.println("Please enter the flight number");
                        int inputtedFlightNumber = scanner.nextInt();
                        Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
                        if (chosenFlight.getFlightNum() == 0) {
                            System.out.println("Flight was not found");
                        } else {
                            System.out.println(chosenFlight);
                            Ticket ticket = customerService.findTicket(currentCustomer, chosenFlight);
                            if (ticket.getFlightNumber() == 0) {
                                System.out.println("Booking not found");
                            } else {
                                customerService.cancelBooking(currentCustomer, chosenFlight, ticket);
                                System.out.println("Booking has been cancelled");
                            }
                        }
                    }
                }
                else if (option.equals("5")) {
                    System.out.println("What is your passport number");
                    String inputtedPassportNumber = scanner.nextLine();
                    Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
                    if (currentCustomer.getPassportNumber() == null) {
                        System.out.println("You are not on the system !");
                    } else {
//                        System.out.println("Please enter the flight number");
//                        int inputtedFlightNumber = scanner.nextInt();
//                        Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
//                        System.out.println("Here are your booked flights" + chosenFlight);
                        Flight[] customerFLightList = currentCustomer.getFlights();
                        for(Flight flight : customerFLightList){
                           if(flight != null) {
                               System.out.println(flight.toString());
                           }
                        }

                    }
                }
                else if (option.equals("0")) {

                }
                else {
                    System.out.println("Please enter a valid number");
                }
            } while (option.equals("0") == false);
        }
        //Logic for staff
        else if (response.equals("2")) {
            String option = "";
            do {
                System.out.println("If you wish to exit, press 0" +
                        ". If you wish to add a flight to NelsonAir, press 1" +
                        ". If you wish to modify a flight status, press 2" +
                        ". If you wish to cancel a flight, press 3");
                option = scanner.nextLine();
                if (option.equals("1")) {
                    //Logic to add a flight
                }
                else if (option.equals("2")) {
                    //Logic to modify flight status
                }
                else if (option.equals("3")) {
                    //Logic to cancel a flight
                }
                else if (option.equals("0")) {

                }
                else {
                    System.out.println("Please enter a valid number");
                }
            } while (option.equals("0") == false);
        }
        //Logic if an invalid number is inputted
        else {
            System.out.println("Invalid number entered. CLI exited.");
        }

        //END OF MAIN



//        System.out.println("Do you want make an account ?");
//        String reply = scanner.nextLine();
//        if (reply.equals("yes")) {
//            System.out.println("What is your name ?");
//            String name = scanner.nextLine();
//            System.out.println("What is your passport number ?");
//            String passportNumber = scanner.nextLine();
//            System.out.println("What is your mobile number ?");
//            String mobileNumber = scanner.nextLine();
//            System.out.println("What is your email ?");
//            String email = scanner.nextLine();
//            Customer newCustomer = new Customer(name, passportNumber, mobileNumber, email);
//            //Add the customer to the database
//            System.out.println(customerService.addCustomerToDatabase(newCustomer, customerDatabase));
//        }
//
//        System.out.println("Would you like to buy a ticket ?");
//        reply = scanner.nextLine();
//        if (reply.equals("yes")) {
//            System.out.println("What is your passport number");
//            String inputtedPassportNumber = scanner.nextLine();
//            Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
//            if (currentCustomer.getPassportNumber() == null) {
//                System.out.println("You are not on the system !");
//            } else {
//                System.out.println("Please enter the flight number");
//                int inputtedFlightNumber = scanner.nextInt();
//                Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
//                if (chosenFlight.getFlightNum() == 0) {
//                    System.out.println("Flight was not found");
//                } else {
//                    System.out.println(chosenFlight);
//                    customerService.makeBooking(currentCustomer, chosenFlight);
//                    customerService.makeTicket(currentCustomer, chosenFlight);
//                }
//            }
//        }
//
//        System.out.println("Would you like to cancel a booking ?");
//        if (reply.equals("yes")) {
//            System.out.println("What is your passport number");
//            String inputtedPassportNumber = scanner.nextLine();
//            Customer currentCustomer = customerService.searchForCustomer(inputtedPassportNumber, customerDatabase);
//            if (currentCustomer.getPassportNumber() == null) {
//                System.out.println("You are not on the system !");
//            } else {
//                System.out.println("Please enter the flight number");
//                int inputtedFlightNumber = scanner.nextInt();
//                Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
//                if (chosenFlight.getFlightNum() == 0) {
//                    System.out.println("Flight was not found");
//                } else {
//                    System.out.println(chosenFlight);
//                    Ticket ticket = customerService.findTicket(currentCustomer, chosenFlight);
//                    if (ticket.getFlightNumber() == 0) {
//                        System.out.println("Booking not found");
//                    } else {
//                        customerService.cancelBooking(currentCustomer, chosenFlight, ticket);
//                        System.out.println("Booking has been cancelled");
//                    }
//                }
//            }
//        }
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
//    System.out.println("Hello, welcome to Nelson Air's CLI. Are you a customer or staff member");
//
//    if(staffmember){
//        option = 5;
//        While(option!=0){
//            System.out.println(" If you would like to exit, press 0"+
//                    "If you would like to add a flight, press 1. If you would like to cancel a flight, press 2."+
//                    "you want to change a flight status, press 3")
//            if(1){
//                addFlight();
//            }
//            else if(2){
//                cancelFlight();
//            }
//            else if(3){
//                modifyFlight();
//            }
//        }
//    }
//}
//    else {
//        do {
//            System.out.println("If you would like to exit, press 0. " +
//            "If you would like to create an account, press 1" +
//            "If you would like to see all flights, press 2" +
//            "If you would like to make a booking, press 3." +
//            "If you would like to cancel a booking, press 4"
//            "If you would like to view your flights, press 5"
//            )
//            if(1)
//            {
//
//            }
//            }while(option != 0)
//            }
//
//            }
