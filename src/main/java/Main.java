import airline.NelsonAir;
import customer.*;
import flight.*;
import ticket.Ticket;
import userInterface.EmailValidator;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //START OF MAIN

        //Initialise new variables for the CLI
        CustomerDatabase customerDatabase = new CustomerDatabase();
        NelsonAir nelsonAir = new NelsonAir();
        Scanner scanner = new Scanner(System.in);
        FlightService flightService = new FlightService();

        //Testing CustomerFileDataAccessService implementation of the CustomerDAO interface
//        CustomerListDataAccessService customerListDataAccessService= new CustomerListDataAccessService();
//        CustomerService customerService = new CustomerService(customerListDataAccessService);
        Customer Ollie = new Customer("Oli", "4321", "00000001", "oli@snailmail.com");
//        System.out.println(customerService.addCustomerToDatabase(new Customer("Oli", "4321", "00000001", "oli@snailmail.com")));
//        System.out.println(customerService.addCustomerToDatabase(new Customer("Jason", "4351", "00000001", "oli@snailmail.com")));
//        customerFileDataAccessService.deleteCustomerFromDatabase(Ollie);

        //Testing writing JSON to file
        CustomerListDataAccessService customerListDataAccessService = new CustomerListDataAccessService();
        CustomerService customerService = new CustomerService(customerListDataAccessService);
//        customerService.getCustomerDAO().addCustomerToDatabase(Ollie, customerDatabase);
//        customerService.getCustomerDAO().addCustomerToDatabase(new Customer("Jason", "4351", "00000001", "oli@snailmail.com"), customerDatabase);
//        customerService.writeDataBaseToFile(customerDatabase);
        customerListDataAccessService.readIntoListFromFile(customerDatabase);
        System.out.println(customerDatabase.toString());

        //Flight for testing purposes
        Flight newFlight = new Flight(LocalDate.of(2021, Month.OCTOBER, 25), 123,  Location.LONDON, Location.LISBON, PlaneModelType.CONCORD, 50, 0);
        Flight newFlight1 = new Flight(LocalDate.of(2021, Month.OCTOBER, 25), 124,  Location.LONDON, Location.MAGALUF, PlaneModelType.CONCORD, 50, 0);
        Flight newFlight2 = new Flight(LocalDate.of(2021, Month.OCTOBER, 25), 125, Location.LONDON, Location.BUDAPEST, PlaneModelType.CONCORD, 50, 0);
        flightService.addFlightToNelsonAir(newFlight, nelsonAir);
        flightService.addFlightToNelsonAir(newFlight1, nelsonAir);
        flightService.addFlightToNelsonAir(newFlight2, nelsonAir);

        //Customer for testing purposes
        Customer Oli = new Customer("Oli", "1234", "111", "oliverekwalla@gmail.com");
//        customerListDataAccessService.addCustomerToDatabase(Oli, customerDatabase);

        //Booking a flight for Oli for testing purposes
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
                    EmailValidator emailValidator = new EmailValidator();
                    while (!emailValidator.isEmailValid(email)) {
                        System.out.println("email is invalid, please re-enter:");
                        email = scanner.nextLine();
                    }
                        Customer newCustomer = new Customer(name, passportNumber, mobileNumber, email);
                        //Add the customer to the database
//                        customerFileDataAccessService.addCustomerToDatabase(newCustomer);
                } else if (option.equals("2")) {
                    //Logic to see all available flights
                    customerService.displayAvailableFlights(nelsonAir);

                } else if (option.equals("3")) {
                    //Logic to make a booking
                    //Oli
                    System.out.println("What is your passport number");
                    String inputtedPassportNumber = scanner.nextLine();
                    Customer currentCustomer = customerService.getCustomerDAO().searchForCustomerFromDataBase(inputtedPassportNumber, customerDatabase);
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
                } else if (option.equals("4")) {
                    //Logic to cancel a booking
                    //Oli
                    System.out.println("What is your passport number");
                    String inputtedPassportNumber = scanner.nextLine();
                    Customer currentCustomer = customerService.getCustomerDAO().searchForCustomerFromDataBase(inputtedPassportNumber, customerDatabase);
                    if (currentCustomer.getPassportNumber() == null) {
                        System.out.println("Your account was not found on the system");
                    } else {
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
                } else if (option.equals("5")) {
                    System.out.println("What is your passport number");
                    String inputtedPassportNumber = scanner.nextLine();
                    Customer currentCustomer = customerService.getCustomerDAO().searchForCustomerFromDataBase(inputtedPassportNumber, customerDatabase);
                    if (currentCustomer.getPassportNumber() == null) {
                        System.out.println("You are not on the system !");
                    } else {
//                        System.out.println("Please enter the flight number");
//                        int inputtedFlightNumber = scanner.nextInt();
//                        Flight chosenFlight = customerService.searchFlightList(inputtedFlightNumber, nelsonAir);
//                        System.out.println("Here are your booked flights" + chosenFlight);
                        Flight[] customerFLightList = currentCustomer.getFlights();
                        for (Flight flight : customerFLightList) {
                            if (flight != null) {
                                System.out.println(flight.toString());
                            }
                        }

                    }
                } else if (option.equals("0")) {

                } else {
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
                    System.out.println("What time and date is the flight scheduled for?");
                    String timeOfFlight = scanner.nextLine();
                    //parse string to local date

                    //What is the flight number

                    //What is the origin
                    //try/catch if enum doesn't exist

                    //What is the destination
                    //try/catch if enum doesn't exist

                    //What is the plane model
                    //try/catch if enum doesn't exist

                    //What is the capacity

                    //Set the count to 0 in the constructor
                    //Create flight and add to flight list (providing flight list isn't full)


                } else if (option.equals("2")) {
                    //Logic to modify flight status
                    //Do it based on flight number
                    //use getters and setters
                } else if (option.equals("3")) {
                    //Logic to cancel a flight
                    //Do it based on flight number
                    //use getters and setters
                } else if (option.equals("0")) {

                } else {
                    System.out.println("Please enter a valid number");
                }
            } while (option.equals("0") == false);
        }
        //Logic if an invalid number is inputted
        else {
            System.out.println("Invalid number entered. CLI exited.");
        }

    }
}