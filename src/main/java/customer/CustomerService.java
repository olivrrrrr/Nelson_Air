package customer;

import airline.NelsonAir;
import flight.Flight;
import flight.Location;
import ticket.Ticket;

import java.time.LocalDate;

public class CustomerService {

    //Add new customer to customerDatabase
    //Need to make customer database in main class
    public String addCustomerToDatabase (Customer customer, CustomerDatabase customerDatabase) {
        Customer[] customerList = customerDatabase.getCustomerList();
        boolean isFull = true;
        int listLength = customerList.length;
        for(int i = 0; i < listLength; i++)
        {
            if(customerList[i].equals(null)) {
                customerList[i] = customer;
                isFull = false;
                break;
            }
        }
        if (isFull == true)
        {
            return "System overloaded, unable to add customer at this time";
        }
        return "Customer added to system.";
    }


    //Customer make a booking
    public String makeBooking (Customer customer, Flight flight) {
        //Check the flight has space
        if(flight.getCapacity()  - 1 >= flight.getCount()) {
            //Add them to customer list
            Customer[] customerList = flight.getCustomers();
            int length = customerList.length;
           for (int i = 0; i < length; i++){
               if (customerList[i].equals(null)) {
                   customerList[i] = customer;
                   break;
               }
           }
            //Add flight to flight list
            int count = flight.getCount();
            flight.setCount(++count);
//            return "Booking Confirmed!";
            Flight[] flightList = customer.getFlights();
            int customerFlightListLength = flightList.length;
            boolean flightListIsFull = true;
            for (int i = 0; i < customerFlightListLength; i++){
                if (flightList[i].equals(null)) {
                    flightList[i] = flight;
                    flightListIsFull = false;
                    break;
                }
            }
            if (flightListIsFull = true) {
                return "You have booked to many tickets";
                //call cancel booking function
            }

            return "Success! Booking made";

        }
        //If plane is full return statement
        return "Plane is full, sorry";
    }


    //Make a ticket for the customer
    public String makeTicket (Customer customer, Flight flight) {
        //Check that the customer is on the flight passenger list
        Customer[] customerList = flight.getCustomers();
        int customerLength = customerList.length;
        boolean customerHasBooked = false;
        for (int i = 0; i < customerLength; i++) {
            if (customerList[i].equals(customer)) {
                customerHasBooked = true;
                break;
            }
        }

        //If yes, retrieve information from customer object and flight information from
        //flight object
        if (customerHasBooked) {
            String name = customer.getName();
            String passportNumber = customer.getPassportNumber();
            int ticketNumber = 20;
            LocalDate timeOfFlight = flight.getTimeOfFlight();
            int flightNumber = flight.getFlightNum();
            Location origin = flight.getOrigin();
            Location destination = flight.getDestination();
            //Create the new ticket
            Ticket ticket = new Ticket(name, passportNumber, ticketNumber, timeOfFlight, flightNumber, origin, destination);
            //Now add new ticket to ticketList of customer
            Ticket[] ticketList = customer.getTicket();
            int length = ticketList.length;
            boolean spaceforTicket = false;
            for (int i = 0 ; i < length; i++)
            {
                if (ticketList[i].equals(null))
                {
                    ticketList[i] = ticket;
                    spaceforTicket = true;
                    break;
                }
            }
            //If no space for ticket, return statement
            if (spaceforTicket = false) {
                return "You have exceeded your maximum number of tickets";
                //would then call function to cancel booking
            }
            return "Ticket Confirmation";
        }
        //Return statement if passenger not found
        else {
            return "Booking Error: Passenger not found";
            //would then call function to cancel booking
        }
    }

    //Customer view flight list
    public void viewFlightList(NelsonAir nelsonAir) {
        String stringListOfFlights =  nelsonAir.getListOfFlights().toString();
        System.out.println("Welcome to NelsonAir, please select your flight from below: ");
        System.out.println(stringListOfFlights);
    }

    //Display flights that you can book:
    //Sabi

    //Customer cancel a booking
    public String cancelBooking (Customer customer, Flight flight, Ticket ticket) {
        //Delete customer from customer list
        Customer[] customerList = flight.getCustomers();
        int customerLength = customerList.length;
        for (int i = 0; i < customerLength; i++) {
            if (customerList[i].equals(customer)) {
                customerList[i] = null;
                int count = flight.getCount();
                flight.setCount(--count);
                //return "Booking is cancelled.";
            }
        }
        //Delete flight from customer flight list
        Flight[] flightList = customer.getFlights();
        int customerFlightListLength = flightList.length;
//        boolean flightListIsFull = true;
        for (int i = 0; i < customerFlightListLength; i++){
            if (flightList[i].equals(flight)) {
                flightList[i] = null;
                //flightListIsFull = false;
                break;
            }
        }
        //Delete ticket from ticket list
        Ticket[] ticketList = customer.getTicket();
        int length = ticketList.length;
//        boolean spaceforTicket = false;
        for (int i = 0 ; i < length; i++)
        {
            if (ticketList[i].equals(ticket))
            {
                ticketList[i] = null;
//                spaceforTicket = true;
                break;
            }
        }
        return "Booking was cancelled";
    }



}
