import java.util.HashMap;

public class FreightElevator extends Elevator
{
    private float weight;
    private int occupants;
    private int directionHeaded;
    FreightElevator freight1 = new FreightElevator("1", 0f, 0);
    FreightElevator freight2 = new FreightElevator("2", 0f, 0);
    HashMap<String, FreightElevator> freightElevatorMap = new HashMap<>();
    public FreightElevator(String elevatorID, float weight, int directionHeaded)
    {
        super(elevatorID);
        this.weight = weight;
        this.directionHeaded = directionHeaded;
    }
    public int getElevatorWeight()
    {
        return occupants;
    }
    public int getDirectionHeaded()
    {
        return directionHeaded;
    }
    public void loadElevatorMap()
    {
        freightElevatorMap.put("P1", freight1);
        freightElevatorMap.put("P2", freight2);
    }
}