package airline;

import java.util.Arrays;

public class NelsonAir {
    private Flight[] listOfFlights;

    public NelsonAir(Flight[] listOfFlights) {
        this.listOfFlights = listOfFlights;
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
