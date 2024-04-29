public class Floor implements Floorable
{
    private int occupants;
    private float weight;
    public Floor()
    {
        this.occupants = 0;
        this.weight = 0f;
    }
    public int getOccupants()
    {
        return occupants;
    }
    public float getWeight()
    {
        return weight;
    }
    public void setOccupants(int newOccupants)
    {
        occupants = newOccupants;
    }
    public void setWeight(float newWeight)
    {
        weight = newWeight;
    }
}
