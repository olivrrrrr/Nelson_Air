package airline;

import flight.Flight;

import java.util.Arrays;

public class NelsonAir {
    private Flight[] listOfFlights;

    public NelsonAir() {
        this.listOfFlights = new Flight[10000];
    }

    public Flight[] getListOfFlights() {
        return listOfFlights;
    }

    public void setListOfFlights(Flight[] listOfFlights) {
        this.listOfFlights = listOfFlights;
    }

    @Override
    public String toString() {
        return "NelsonAir{" +
                "listOfFlights=" + Arrays.toString(listOfFlights) +
                '}';
    }
}
