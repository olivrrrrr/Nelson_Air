package customer;

import flight.Flight;
import ticket.Ticket;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Customer implements Serializable {

    private String name;
    private String passportNumber;
    private String mobileNumber;
    private String email;
    private Ticket[] ticketList;
    private Flight[] flights;

    public Customer(String name, String passportNumber, String mobileNumber, String email) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.ticketList = new Ticket[50];
        this.flights = new Flight[50];
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public Ticket[] getTicket() {
        return ticketList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setNumber(String number) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTicket(Ticket[] ticket) {
        this.ticketList = ticket;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", ticketList=" + Arrays.toString(ticketList) +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(passportNumber, customer.passportNumber) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(email, customer.email) && Arrays.equals(ticketList, customer.ticketList) && Arrays.equals(flights, customer.flights);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, passportNumber, mobileNumber, email);
        result = 31 * result + Arrays.hashCode(ticketList);
        result = 31 * result + Arrays.hashCode(flights);
        return result;
    }
}
