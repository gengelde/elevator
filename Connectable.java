/**
 * The Connectable interface represents the behavior of the connect object that can provide user destination
 * information and access level.
 */
public interface Connectable
{
    int getUserDestination();
    String getAccessLevel();
    void setUserData(int userID);
}
