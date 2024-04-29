import java.util.ArrayList;
public class Elevator implements Elevatable
{
    private float weight;
    private int occupants;
    private String directionHeaded;
    private int currentFloor;
    private int presses;
    private ArrayList<Integer> elevatorQueue;
    public Elevator()
    {
        this.weight = 0.0f;
        this.occupants = 0;
        this.directionHeaded = "ST";
        this.currentFloor = 0;
        this.presses = 0;
        this.elevatorQueue = new ArrayList<>();
    }
    public float getWeight()
    {
        return weight;
    }
    public void setWeight(float weigh)
    {
        weight = weigh;
    }
    public int getOccupants()
    {
        return occupants;
    }
    public void setOccupants(int pants)
    {
        occupants = pants;
    }
    public int getCurrentFloor()
    {
        return currentFloor;
    }
    public void setCurrentFloor(int current)
    {
        currentFloor = current;
    }
    public String getDirectionHeaded()
    {
        return directionHeaded;
    }
    public void setDirectionHeaded(String direction)
    {
        directionHeaded = direction;
    }
    public int getPresses()
    {
        return presses;
    }
    public void setPresses(int count)
    {
        presses = count;
    }
    public void addToQueue(int q)
    {
        elevatorQueue.add(q);
    }
    public ArrayList<Integer> getQueue()
    {
        return elevatorQueue;
    }
}
