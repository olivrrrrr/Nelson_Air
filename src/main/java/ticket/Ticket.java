package ticket;

import flight.Location;

import java.time.LocalDate;

import flight.Location;

import java.time.LocalDate;

    public class Ticket {
        private String name;
        private long passNum;
        private int ticketNumber;
        private LocalDate timeOfFlight;
        private int flightNumber;
        private Location origin;
        private Location destination;

        public Ticket(String name, long passNum, int ticketNumber, LocalDate timeOfFlight, int flightNumber, Location origin, Location destination) {
            this.name = name;
            this.passNum = passNum;
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

        public long getPassNum() {
            return passNum;
        }

        public void setPassNum(long passNum) {
            this.passNum = passNum;
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
    }

