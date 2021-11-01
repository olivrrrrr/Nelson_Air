package ticket;

import flight.Location;

import java.io.Serializable;
import java.time.LocalDate;

import flight.Location;

import java.time.LocalDate;
import java.util.Objects;

public class Ticket implements Serializable {
        private String name;
        private String passportNumber;

    private int ticketNumber;
        private LocalDate timeOfFlight;
        private int flightNumber;
        private Location origin;
        private Location destination;

        public Ticket(String name, String passportNumber, int ticketNumber, LocalDate timeOfFlight, int flightNumber, Location origin, Location destination) {
            this.name = name;
            this.passportNumber = passportNumber;
            this.ticketNumber = ticketNumber;
            this.timeOfFlight = timeOfFlight;
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassNum() {
            return passportNumber;
        }

        public void setPassNum(String passNum) {
            this.passportNumber = passNum;
        }

        public int getTicketNumber() {
            return ticketNumber;
        }

        public void setTicketNumber(int ticketNumber) {
            this.ticketNumber = ticketNumber;
        }

        public LocalDate getTimeOfFlight() {
            return timeOfFlight;
        }

        public void setTimeOfFlight(LocalDate timeOfFlight) {
            this.timeOfFlight = timeOfFlight;
        }

        public int getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(int flightNumber) {
            this.flightNumber = flightNumber;
        }

        public Location getOrigin() {
            return origin;
        }

        public void setOrigin(Location origin) {
            this.origin = origin;
        }

        public Location getDestination() {
            return destination;
        }

        public void setDestination(Location destination) {
            this.destination = destination;
        }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", ticketNumber=" + ticketNumber +
                ", timeOfFlight=" + timeOfFlight +
                ", flightNumber=" + flightNumber +
                ", origin=" + origin +
                ", destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketNumber == ticket.ticketNumber && flightNumber == ticket.flightNumber && Objects.equals(name, ticket.name) && Objects.equals(passportNumber, ticket.passportNumber) && Objects.equals(timeOfFlight, ticket.timeOfFlight) && origin == ticket.origin && destination == ticket.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportNumber, ticketNumber, timeOfFlight, flightNumber, origin, destination);
    }
}

