import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerElevator extends Elevator
{
    private int numPassengers;
    private final int maxCap;
    private Map<Integer, Integer> floorDestinations;

    public PassengerElevator(String elevID, int cap )
    {
        super(elevID);
        maxCap = cap;
        numPassengers = 0;
        floorDestinations = new HashMap<>();
    }

    public String toString()
    {
        return super.toString() + "passengers: " + numPassengers;
    }
}