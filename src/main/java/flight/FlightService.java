package flight;

import airline.NelsonAir;

public class FlightService {
    //Add a new flight
    //Option 1: Add a new flight [y/n]
    //If yes, please call function
    // function addFlightToFlightList {
    //origin --> store to a variable
    //destination
    //etc.
    //use variable to make a new flight
    //add flight to flight list}
    //n.b. might need to remove enums
    public void addFlightToNelsonAir(Flight flight, NelsonAir nelsonAir) {
        Flight[] currentFlightList = nelsonAir.getListOfFlights();
        boolean flightListIsFull = true;
        for (int i = 0; i < currentFlightList.length; i++) {
            if (currentFlightList[i] == null) {
                currentFlightList[i] = flight;
                flightListIsFull = false;
                break;
            }
        }
        if (flightListIsFull == true)
        {
            System.out.println("Flight list is full, sorry.");
        }
    }


    //Change status of a flight

}
