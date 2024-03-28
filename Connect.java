import com.mongodb.client.*;
import org.bson.Document;
public class Connect
{
    public Connect()
    {

    }
    public void makeConnection()
    {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"))
        {
            MongoDatabase database = mongoClient.getDatabase("Elevator_DB");
            MongoCollection<Document> nameCollection = database.getCollection("Elevator");

            Document elevator1 = nameCollection.find(new Document("name", "Jerod")).first();
            System.out.println("Person 1: " + elevator1.toJson());
            System.out.println(elevator1.get("name"));
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
