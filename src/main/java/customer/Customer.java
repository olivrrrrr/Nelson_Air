package customer;

import ticket.Ticket;

import java.util.Arrays;
import java.util.Objects;

public class Customer {

    private String name;
    private int passportNumber;
    private Long number;
    private String email;
    private Ticket[] ticket;
    private double customerId;

    public Customer(String name, int passportNumber, Long number, String email, Ticket[] ticket) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.number = number;
        this.email = email;
        this.ticket = ticket;
        this.customerId = Math.random() * 1000000000;
    }

    public String getName() {
        return name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public Long getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public Ticket[] getTicket() {
        return ticket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTicket(Ticket[] ticket) {
        this.ticket = ticket;
    }

    public double getCustomerId() {
        return customerId;
    }

    public void setCustomerId(double customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return passportNumber == customer.passportNumber && Double.compare(customer.customerId, customerId) == 0 && Objects.equals(name, customer.name) && Objects.equals(number, customer.number) && Objects.equals(email, customer.email) && Arrays.equals(ticket, customer.ticket);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, passportNumber, number, email, customerId);
        result = 31 * result + Arrays.hashCode(ticket);
        return result;
    }
}
