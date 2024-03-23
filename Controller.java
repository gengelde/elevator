import java.util.HashMap;
public class Controller implements Runnable
{
    Floor floor1 = new Floor("1", 0, false);
    Floor floor2 = new Floor("2", 0, false);
    HashMap<String, Floor> floorMap = new HashMap<>();
    public Controller()
    {
        loadFloorMap();
    }
    public void run()
    {

    }
    public void loadFloorMap()
    {
        floorMap.put("F1", floor1);
        floorMap.put("F2", floor2);
    }
}
