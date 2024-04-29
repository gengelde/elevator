import java.util.ArrayList;

/**
 * The Elevator class represents an elevator object that can track weight,
 * occupants, direction, current floor, and elevator button presses.
 */
public class Elevator implements Elevatable {

    private float weight;
    private int occupants;
    private String directionHeaded;
    private int currentFloor;
    private ArrayList<Integer> elevatorQueue;

    /**
     * Constructs a new Elevator object with default values.
     */
    public Elevator() {
        this.weight = 0.0f;
        this.occupants = 0;
        this.directionHeaded = "ST";
        this.currentFloor = 0;
        this.elevatorQueue = new ArrayList<>();
    }

    /**
     * Returns the current weight of the elevator.
     *
     * @return The current weight of the elevator.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the elevator.
     *
     * @param weight The new weight of the elevator.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Returns the number of occupants in the elevator.
     *
     * @return The number of occupants in the elevator.
     */
    public int getOccupants() {
        return occupants;
    }

    /**
     * Sets the number of occupants in the elevator.
     *
     * @param occupants The new number of occupants in the elevator.
     */
    public void setOccupants(int occupants) {
        this.occupants = occupants;
    }

    /**
     * Returns the current floor of the elevator.
     *
     * @return The current floor of the elevator.
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Sets the current floor of the elevator.
     *
     * @param currentFloor The new current floor of the elevator.
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Returns the direction in which the elevator is headed.
     *
     * @return The direction in which the elevator is headed.
     */
    public String getDirectionHeaded() {
        return directionHeaded;
    }

    /**
     * Sets the direction in which the elevator is headed.
     *
     * @param directionHeaded The new direction in which the elevator is headed.
     */
    public void setDirectionHeaded(String directionHeaded) {
        this.directionHeaded = directionHeaded;
    }

    /**
     * Adds a floor to the elevator's queue.
     *
     * @param floor The floor to be added to the elevator's queue.
     */
    public void addToQueue(int floor) {
        elevatorQueue.add(floor);
    }

    /**
     * Returns the elevator's queue of floors to visit.
     *
     * @return The elevator's queue of floors to visit.
     */
    public ArrayList<Integer> getQueue() {
        return elevatorQueue;
    }
}
