package flight;
import java.time.LocalDate;

public class Flight {
    private LocalDate timeOfFlight;
    private int FlightNum;
    private FlightStatus flightStatus;
    private Location location;
    private PlaneModelType planeModelType;
    private int Capacity;
    private Customer[] customers;

    public Flight(LocalDate timeOfFlight, int flightNum, FlightStatus flightStatus, Location location, PlaneModelType planeModelType, int capacity, Customer[] customers) {
        this.timeOfFlight = timeOfFlight;
        FlightNum = flightNum;
        this.flightStatus = flightStatus;
        this.location = location;
        this.planeModelType = planeModelType;
        Capacity = capacity;
        this.customers = customers;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

