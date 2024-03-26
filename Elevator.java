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
    public void setWeight()
    {

    }
    public int getOccupants()
    {
        return occupants;
    }
    public void setOccupants(int newOccupants)
    {

    }
    public int getCurrentFloor()
    {
        return currentFloor;
    }
    public void setCurrentFloor(int flr)
    {
        currentFloor = flr;
    }
    public int getDirectionHeaded()
    {
        return directionHeaded;
    }
    public void setDirectionHeaded()
    {

    }
}
