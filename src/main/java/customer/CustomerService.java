package customer;

import airline.NelsonAir;
import flight.Flight;
import flight.Location;
import ticket.Ticket;

import java.time.LocalDate;

public class CustomerService {


    //Customer make a booking
    public String makeBooking (Customer customer, Flight flight) {
        //Check the flight has space
        if(flight.getCapacity()  - 1 >= flight.getCount()) {

            Customer[] customerList = flight.getCustomers();
            int length = customerList.length;
           for (int i = 0; i < length; i++){
               if (customerList[i].equals(null)) {
                   customerList[i] = customer;
                   break;
               }
           }

            int count = flight.getCount();
            flight.setCount(++count);
            return "Booking Confirmed!";
        }
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
            long passportNumber = customer.getPassportNumber();
            int ticketNumber = 20;
            LocalDate timeOfFlight = flight.getTimeOfFlight();
            int flightNumber = flight.getFlightNum();
            Location origin = flight.getOrigin();
            Location destination = flight.getDestination();
            Ticket ticket = new Ticket(name, passportNumber, ticketNumber, timeOfFlight, flightNumber, origin, destination);
            return "Ticket Confirmation";
        }else {
            return "Booking Error: Passenger not found.";
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
    public String cancelBooking (Customer customer, Flight flight) {
        //Check that the customer is on the flight passenger list
        Customer[] customerList = flight.getCustomers();
        int customerLength = customerList.length;
        for (int i = 0; i < customerLength; i++) {
            if (customerList[i].equals(customer)) {
                customerList[i] = null;
                int count = flight.getCount();
                flight.setCount(--count);
                return "Booking is cancelled.";
            }
        }
        return "Booking was not found.";
    }



}
