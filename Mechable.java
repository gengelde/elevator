import java.util.ArrayList;
public interface Mechable
{
    boolean hasQueues();
    ArrayList<Integer> getElevatorsWithQueues();
    boolean hasQueueAdditions(int addition);
    void setSelectedElevator(String selection);
    boolean addFloorToSelectedElevatorQueue(int level, String dir);
    void addOccupantsToSelectedFloor(int pass);
    void addWeightToSelectedFloor(float weight);
    void addOccupantsToSelectedElevator(int occupants);
    void addWeightToSelectedElevator(float weight);
    void subtractOccupantsFromSelectedElevator(int occupants);
    void subtractWeightFromSelectedElevator(float weight);
    void processQueues(ArrayList<Integer> list, String dir);
    void processElevator(String dir);
    void moveElevator();
}