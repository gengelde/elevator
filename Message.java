/**
 * The Message class represents a message object used for communication between elevator components.
 */
public class Message {

    private int floor = 0;
    private String type = "";
    private int passengers = 0;
    private float weight = 0.0f;
    private String dir = "ST";

    /**
     * Constructs a new Message object with default values.
     */
    public Message() {

    }

    /**
     * Returns the direction of the floor.
     *
     * @return The direction of the floor.
     */
    public String getFloorDirection() {
        return dir;
    }

    /**
     * Returns the ID of the floor.
     *
     * @return The ID of the floor.
     */
    public int getFloorID() {
        return floor;
    }

    /**
     * Returns the type of the elevator.
     *
     * @return The type of the elevator.
     */
    public String getElevatorType() {
        return type;
    }

    /**
     * Returns the weight of the elevator.
     *
     * @return The weight of the elevator.
     */
    public float getElevatorWeight() {
        return weight;
    }

    /**
     * Returns the number of passengers in the elevator.
     *
     * @return The number of passengers in the elevator.
     */
    public int getElevatorPassengers() {
        return passengers;
    }

    /**
     * Sets the direction of the floor.
     *
     * @param temp The new direction of the floor.
     */
    public void setFloorDirection(String temp) {
        dir = temp;
    }

    /**
     * Sets the ID of the floor.
     *
     * @param temp The new ID of the floor.
     */
    public void setFloorID(int temp) {
        floor = temp;
    }

    /**
     * Sets the type of the elevator.
     *
     * @param temp The new type of the elevator.
     */
    public void setElevatorType(String temp) {
        type = temp;
    }

    /**
     * Sets the weight of the elevator.
     *
     * @param temp The new weight of the elevator.
     */
    public void setElevatorWeight(float temp) {
        weight = temp;
    }

    /**
     * Sets the number of passengers in the elevator.
     *
     * @param temp The new number of passengers in the elevator.
     */
    public void setPassengerAmount(int temp) {
        passengers = temp;
    }
}
