/**
 * The Floor class represents a floor object that can track occupants and weight.
 */
public class Floor implements Floorable {

    private int occupants;
    private float weight;

    /**
     * Constructs a new Floor object with default values.
     */
    public Floor() {
        this.occupants = 0;
        this.weight = 0f;
    }

    /**
     * Returns the number of occupants for the floor.
     *
     * @return The number of occupants for the floor.
     */
    public int getOccupants() {
        return occupants;
    }

    /**
     * Returns the total weight for the floor.
     *
     * @return The total weight for the floor.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets the number of occupants for the floor.
     *
     * @param newOccupants The new number of occupants for the floor.
     */
    public void setOccupants(int newOccupants) {
        this.occupants = newOccupants;
    }

    /**
     * Sets the total weight for the floor.
     *
     * @param newWeight The new total weight for the floor.
     */
    public void setWeight(float newWeight) {
        this.weight = newWeight;
    }
}
