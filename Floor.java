public class Floor
{
    String floorID;
    int directionCalled;
    boolean call;
    public Floor(String floorID, int directionCalled, boolean call)
    {
        this.floorID = floorID;
        this.directionCalled = directionCalled;
        this.call = call;
    }
    public String getFloorID()
    {
        return floorID;
    }
    public int getDirectionCalled()
    {
        return directionCalled;
    }
    public boolean getCall()
    {
        return call;
    }
}

