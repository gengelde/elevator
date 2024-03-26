import java.util.HashMap;

public class FreightElevator
{
    private final int numServiceElevators = 3;
    private final int numFloors = 10;
    private int selectedElevator;
    HashMap<Integer, Elevator> freightMap = new HashMap<>();
    HashMap<Integer, Floor> floorMap = new HashMap<>();

    public FreightElevator()
    {
        loadMaps();
    }

    public void loadMaps() {
        for (int i = 0; i < numServiceElevators; i++)
        {
            Elevator freight = new Elevator(0f, 0, 0, 1);
            freightMap.put(i, freight);
        }
        for (int j = 0; j < numFloors; j++)
        {
            Floor floor = new Floor(0, false);
            floorMap.put(j, floor);
        }
    }

    public void printMap()
    {
        for (int i = 0; i < numFloors; i++)
        {
            Floor floor = floorMap.get(i);
            System.out.println("Floor: " + i + ", Was Called: " + floor.getWasCalled());
        }
        for (int j = 0; j < numServiceElevators; j++)
        {
            Elevator elevator = freightMap.get(j);
            System.out.println("Freight Elevator: " + j + ", Weight: " + elevator.getWeight() + ", Occupants: " + elevator.getOccupants() + ", Dirrection Headed: " + elevator.getDirectionHeaded() + ",  Current Floor: " + elevator.getCurrentFloor());
        }
    }

    public boolean checkStationary()
    {
        for (int j = 0; j < numServiceElevators; j++)
        {
            Elevator elevator = freightMap.get(j);
            if (elevator.getDirectionHeaded() == 0)
            {
                selectedElevator = j;
                return true;
            }
        }
        return false;
    }

    public int getSelectedElevator()
    {
        return selectedElevator;
    }
}
