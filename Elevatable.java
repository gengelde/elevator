import java.util.ArrayList;

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
    int getPresses();
    void setPresses(int count);
    void addToQueue(int q);
    ArrayList<Integer> getQueue();
}
