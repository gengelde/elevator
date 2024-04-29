import java.util.ArrayList;
/**
 * The Elevatable interface represents the behavior of the elevator object that can track weight,
 * occupants, current floor, direction headed, elevator queue, and elevator operations.
 */
public interface Elevatable
{
    float getWeight();
    void setWeight(float weigh);
    int getOccupants();
    void setOccupants(int pants);
    int getCurrentFloor();
    void setCurrentFloor(int current);
    String getDirectionHeaded();
    void setDirectionHeaded(String direction);
    void addToQueue(int q);
    ArrayList<Integer> getQueue();
}
