public class ServiceElevator extends Elevator
{
    private int numPassengers;
    private float elevatorLoad;
    private final float maxWeight;
    private final int maxCap;

    public ServiceElevator(String elevID, int weight, int cap)
    {
        super(elevID);
        maxWeight = weight;
        maxCap = cap;
        elevatorLoad = 0.0f;
        numPassengers = 0;
    }

    public String toString()
    {
        return super.toString() + "passengers: " + numPassengers + " weight: " + elevatorLoad;
    }
}