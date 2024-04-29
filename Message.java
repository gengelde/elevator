public class Message
{
    private int floor = 0;
    private String type = "";
    private int passengers = 0;
    private float weight = 0.0f;
    private String dir = "ST";
    public Message()
    {

    }
    public String getFloorDirection()
    {
        return dir;
    }
    public int getFloorID()
    {
        return floor;
    }
    public String getElevatorType()
    {
        return type;
    }
    public float getElevatorWeight()
    {
        return weight;
    }
    public int getElevatorPassengers()
    {
        return passengers;
    }
    public void setFloorDirection(String temp)
    {
        dir = temp;
    }
    public void setFloorID(int temp)
    {
        floor = temp;
    }
    public void setElevatorType(String temp)
    {
        type = temp;
    }
    public void setElevatorWeight(float temp)
    {
        weight = temp;
    }
    public void setPassengerAmount(int temp)
    {
        passengers = temp;
    }
}
