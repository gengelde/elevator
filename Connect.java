import com.mongodb.client.*;
import org.bson.Document;
public class Connect implements Connectable
{
    private int destination;
    private String accessLevel;
    private final String uri = "mongodb://localhost:27017";
    private final String databaseName = "Elevator_DB";
    private final String collection = "Elevator";
    public Connect()
    {
        this.destination = 0;
        this.accessLevel = "";
    }
    public void setUserData(int userID)
    {
        try (MongoClient mongoClient = MongoClients.create(uri))
        {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> idCollection = database.getCollection(collection);
            Document result = idCollection.find(new Document("ID", userID)).first();
            destination = result.getInteger("Destination");
            accessLevel = result.getString("Access");
        }
    }
    public int getUserDestination()
    {
        return destination;
    }
    public String getAccessLevel()
    {
        return accessLevel;
    }
}
