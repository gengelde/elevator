import com.mongodb.client.*;
import org.bson.Document;

/**
 * The Connect class implements the Connectable interface and represents a connection
 * to a MongoDB database for retrieving user data such as destination and access level.
 */
public class Connect implements Connectable {

    private int destination;
    private String accessLevel;
    private final String uri = "mongodb://localhost:27017";
    private final String databaseName = "Elevator_DB";
    private final String collection = "Elevator";

    /**
     * Constructs a new Connect object with default values.
     */
    public Connect() {
        this.destination = 0;
        this.accessLevel = "";
    }

    /**
     * Sets the user data for the Connect object by querying the MongoDB database
     * using the provided userID.
     *
     * @param userID The ID of the user whose data is being set.
     */
    public void setUserData(int userID) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> idCollection = database.getCollection(collection);
            Document result = idCollection.find(new Document("ID", userID)).first();
            destination = result.getInteger("Destination");
            accessLevel = result.getString("Access");
        }
    }

    /**
     * Retrieves the user's destination.
     *
     * @return The user's destination.
     */
    public int getUserDestination() {
        return destination;
    }

    /**
     * Retrieves the access level of the user.
     *
     * @return The access level of the user.
     */
    public String getAccessLevel() {
        return accessLevel;
    }
}
