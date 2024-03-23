import java.util.HashMap;

public class PassengerElevator extends Elevator
{
    private int occupants;
    private int directionHeaded;
    PassengerElevator passenger1 = new PassengerElevator("1", 0, 0);
    PassengerElevator passenger2 = new PassengerElevator("2", 0, 0);
    HashMap<String, PassengerElevator> passengerElevatorMap = new HashMap<>();
    public PassengerElevator(String elevatorID, int occupants, int directionHeaded)
    {
        super(elevatorID);
        this.occupants = occupants;
        this.directionHeaded = directionHeaded;
        loadElevatorMap();
    }
    public int getElevatorOccupants()
    {
        return occupants;
    }
    public int getDirectionHeaded()
    {
        return directionHeaded;
    }
    public void loadElevatorMap()
    {
        passengerElevatorMap.put("P1", passenger1);
        passengerElevatorMap.put("P2", passenger2);
    }
}