import java.util.HashMap;
public class Elevator
{
    private int directionMoving;
    private int currentFloor;
    private int floor;
    private HashMap<Integer, Boolean> floorDestinations;
    private String elevatorID;

    public Elevator(String elevID)
    {
        this.elevatorID = elevID;
        directionMoving = 0;
        currentFloor = 1;
        floorDestinations = new HashMap<>();
        // Initialize all floor destinations to false
        for (int i = 1; i <= 10; i++) {
            floorDestinations.put(i, false);
        }
    }

    public void setDestinationFloor(int floor)
    {
        this.floor = floor;
        floorDestinations.put(floor, true);
    }

    public int getDirection()
    {
        return directionMoving;
    }

    public void setDirection(int dir)
    {
        directionMoving = dir;
    }

    public int getFloor()
    {
        return currentFloor;
    }

    public void move()
    {
        if (directionMoving == 1)
        {
            currentFloor++;
        floorDestinations.replace(floor, true);
        }
        else if (directionMoving == -1)
        {
            currentFloor--;
            floorDestinations.replace(floor, true);
        }
    }

    public void reverseDirection()
    {
        directionMoving = -directionMoving;
    }

    public HashMap<Integer, Boolean> getFloorList()
    {
        return floorDestinations;
    }

    public String toString()
    {
        return "Elevator:" + elevatorID + ", direction: " + directionMoving +
                ", floor:" + currentFloor;
    }
}