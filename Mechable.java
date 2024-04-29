import java.util.ArrayList;
/**
 * The Mechable interface represents the behavior of all three mechanical systems responsible for managing each type of elevator.
 */
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
