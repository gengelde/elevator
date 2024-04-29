public class Factory
{
    private Floorable Floor;
    private Elevatable Elevator;
    public Factory()
    {
        Floor = new Floor();
        Elevator = new Elevator();
    }
    public Floorable getFloor()
    {
        return Floor;
    }
    public Elevatable getElevator()
    {
        return Elevator;
    }
}
