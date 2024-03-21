public class FreightElevator extends Elevator
{
    private float elevatorLoad;
    private final float maxWeight;
    private final int maxCap;

    public FreightElevator(String elevID, int weight, int cap)
    {
        super(elevID);
        maxWeight = weight;
        maxCap = cap;
        elevatorLoad = 0.0f;
    }

    public String toString()
    {
        return super.toString() + "weight: " + elevatorLoad;
    }
}