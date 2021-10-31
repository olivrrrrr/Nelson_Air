package flight;
import customer.Customer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

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

    public Flight(LocalDate timeOfFlight, int flightNum, Location origin, Location destination, PlaneModelType planeModelType, int capacity, int count) {
        this.timeOfFlight = timeOfFlight;
        this.FlightNum = flightNum;
        this.flightStatus = FlightStatus.ONTIME;
        this.origin = origin;
        this.destination = destination;
        this.planeModelType = planeModelType;
        this.Capacity = capacity;
        this.customers = new Customer[capacity];
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return FlightNum == flight.FlightNum && Capacity == flight.Capacity && count == flight.count && Objects.equals(timeOfFlight, flight.timeOfFlight) && flightStatus == flight.flightStatus && origin == flight.origin && destination == flight.destination && planeModelType == flight.planeModelType && Arrays.equals(customers, flight.customers) && Objects.equals(isFullyBooked, flight.isFullyBooked);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(timeOfFlight, FlightNum, flightStatus, origin, destination, planeModelType, Capacity, count, isFullyBooked);
        result = 31 * result + Arrays.hashCode(customers);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "timeOfFlight: " + timeOfFlight +
                ", FlightNum: " + FlightNum +
                ", flightStatus: " + flightStatus +
                ", origin: " + origin +
                ", destination: " + destination +
                ", planeModelType: " + planeModelType +
                ", Capacity: " + Capacity +
                '}';
    }
}

