package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsfy on 05-Mar-17.
 */
public class Boat {

    private RiverSide riverSide;

    public Boat(RiverSide riverSide) {
        this.riverSide = riverSide;
    }

    private List<Passenger> passengers = new ArrayList<Passenger>();

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public boolean canCrossRiver() {
        if (passengers.size() > 2)
            return false;

        int numberOfBoys = 0;
        int numberOfSoldiers = 0;


        for (Passenger passenger : passengers) {
            if (passenger.getType() == PassengerType.BOY)
                numberOfBoys++;
            else if (passenger.getType() == PassengerType.SOLDIER)
                numberOfSoldiers++;
        }

        if (numberOfBoys > 2 || numberOfSoldiers > 1 || (numberOfBoys >= 1 && numberOfSoldiers >= 1))
            return false;

        return true;
    }

    public RiverSide getRiverSide() {
        return riverSide;
    }

    public void setRiverSide(RiverSide riverSide) {
        this.riverSide = riverSide;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "riverSide=" + riverSide +
                ", passengers=" + passengers +
                '}';
    }
}
