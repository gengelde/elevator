/**
 * The Floorable interface represents the behavior of the floor object that can track occupants and weight.
 */
public interface Floorable
{
    int getOccupants();
    float getWeight();
    void setOccupants(int newOccupants);
    void setWeight(float newWeight);
}
