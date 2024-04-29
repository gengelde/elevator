/**
 * The Factory class represents a factory for creating instances of floor and elevator objects.
 */
public class Factory {

    private Floorable floor;
    private Elevatable elevator;

    /**
     * Constructs a new Factory object and initializes the floor and elevator instances.
     */
    public Factory() {
        floor = new Floor();
        elevator = new Elevator();
    }

    /**
     * Retrieves the floor instance created by the factory.
     *
     * @return The floor instance.
     */
    public Floorable getFloor() {
        return floor;
    }

    /**
     * Retrieves the elevator instance created by the factory.
     *
     * @return The elevator instance.
     */
    public Elevatable getElevator() {
        return elevator;
    }
}
