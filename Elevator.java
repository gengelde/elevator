public class Elevator
{
    private float weight;
    private int occupants;
    private int directionHeaded;
    private int currentFloor;
    public Elevator(float weight, int occupants, int directionHeaded, int currentFloor)
    {
        this.weight = weight;
        this.occupants = occupants;
        this.directionHeaded = directionHeaded;
        this.currentFloor = currentFloor;
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
    public int getDirectionHeaded()
    {
        return directionHeaded;
    }
    public void setDirectionHeaded(int direction)
    {
        directionHeaded = direction;
    }
}
