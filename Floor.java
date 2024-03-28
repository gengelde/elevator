public class Floor
{
    private int directionCalled;
    private boolean wasCalled;
    public Floor(int directionCalled, boolean wasCalled)
    {
        this.directionCalled = directionCalled;
        this.wasCalled = wasCalled;
    }
    public int getDirectionCalled()
    {
        return directionCalled;
    }
    public void setDirectionCalled(int dirr)
    {
        this.directionCalled = dirr;
    }
    public boolean getWasCalled()
    {
        return wasCalled;
    }
    public void setWasCalled(boolean call)
    {
        this.wasCalled = call;
    }
}
