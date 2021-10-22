package flight;
import customer.Customer;

import java.time.LocalDate;

public class Flight {
    private LocalDate timeOfFlight;
    private int FlightNum;
    private FlightStatus flightStatus;
    private Location origin;
    private Location destination;
    private PlaneModelType planeModelType;
    private int Capacity;
    private Customer[] customers;
    private int count;
    private Boolean isFullyBooked;

    public Flight(LocalDate timeOfFlight, int flightNum, FlightStatus flightStatus, Location origin, Location destination, PlaneModelType planeModelType, int capacity, Customer[] customers, int count) {
        this.timeOfFlight = timeOfFlight;
        FlightNum = flightNum;
        this.flightStatus = flightStatus;
        this.origin = origin;
        this.destination = destination;
        this.planeModelType = planeModelType;
        Capacity = capacity;
        this.customers = customers;
        this.count = count;
        this.isFullyBooked = false;
    }

    public Boolean getFullyBooked() {
        return isFullyBooked;
    }

    public void setFullyBooked(Boolean fullyBooked) {
        isFullyBooked = fullyBooked;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getTimeOfFlight() {
        return timeOfFlight;
    }

    public void setTimeOfFlight(LocalDate timeOfFlight) {
        this.timeOfFlight = timeOfFlight;
    }

    public int getFlightNum() {
        return FlightNum;
    }

    public void setFlightNum(int flightNum) {
        FlightNum = flightNum;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public PlaneModelType getPlaneModelType() {
        return planeModelType;
    }

    public void setPlaneModelType(PlaneModelType planeModelType) {
        this.planeModelType = planeModelType;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
}

