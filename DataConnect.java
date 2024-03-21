import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataConnect implements Connectable
{
    String info;
    String url = "";
    String user = "";
    String pass = "";
    public Boolean connect()
    {
        try
        {
            // Connection statement to database
            Connection connection = DriverManager.getConnection(url, user, pass);
            // set info for getLastEvent to return when called
            info = "Connection to database was Successful";
            // SQL statement sent to database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");

            while (resultSet.next())
            {
                System.out.println(resultSet.getString(""));
            }
            return true;
        }
        catch (SQLException e)
        {
            // set info for getLastEvent to return when called
            info = "Connection to database was Unsuccessful";
            return false;
        }
    }
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}
