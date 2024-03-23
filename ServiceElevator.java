import java.util.HashMap;

public class ServiceElevator extends Elevator
{
    private float weight;
    private int occupants;
    private int directionHeaded;
    ServiceElevator service1 = new ServiceElevator("1", 0f, 0, 0);
    ServiceElevator service2 = new ServiceElevator("2", 0f, 0, 0);
    HashMap<String, ServiceElevator> serviceElevatorMap = new HashMap<>();
    public ServiceElevator(String elevatorID, float weight, int occupants, int directionHeaded)
    {
        super(elevatorID);
        this.weight = weight;
        this.occupants = occupants;
        this.directionHeaded = directionHeaded;
        loadElevatorMap();
    }
    public float getElevatorWeight()
    {
        return weight;
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
        serviceElevatorMap.put("P1", service1);
        serviceElevatorMap.put("P2", service2);
    }
}