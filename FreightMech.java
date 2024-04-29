import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class FreightMech extends Elevator implements Mechable, Elevatable, Floorable
{
    private final int numFreightElevators = 2;
    private final int numFloors = 10;
    private final int maxOccupancy = 8;
    private int currentCall;
    private int currentFloor;
    private final float maxWeight = 3500.0f;
    private ArrayList<Integer> list = new ArrayList<>();
    private HashMap<Integer, Elevator> freightMap = new HashMap<>();
    private HashMap<Integer, Floor> floorMap = new HashMap<>();
    private Elevatable selectedElevator;
    private Elevatable selectedElevator2;
    private Floorable selectedFloor;
    private Factory Factor;
    public FreightMech()
    {
        Factor = new Factory();
        selectedFloor = Factor.getFloor();
        selectedElevator = Factor.getElevator();
        selectedElevator2 = Factor.getElevator();
        loadMaps();
    }
    public void loadMaps()
    {
        for (int i = 0; i < numFreightElevators; i++)
        {
            Elevator freight = new Elevator();
            freightMap.put(i, freight);
        }
        for (int i = 0; i < numFloors; i++)
        {
            Floor floor = new Floor();
            floorMap.put(i, floor);
        }
    }

    public boolean hasQueues()
    {
        for (int i = 0; i < numFreightElevators; i++)
        {
            selectedElevator = freightMap.get(i);
            if (!selectedElevator.getQueue().isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getElevatorsWithQueues()
    {
        for (int i = 0; i < numFreightElevators; i++)
        {
            selectedElevator = freightMap.get(i);
            if (!selectedElevator.getQueue().isEmpty())
            {
                list.add(i);
            }
        }
        return list;
    }

    public boolean hasQueueAdditions(int addition)
    {
        if (addition == 0)
        {
            return false;
        }
        return true;
    }

    public void setSelectedElevator(String selection)
    {
        for (int i = 0; i < freightMap.size(); i++)
        {
            selectedElevator = freightMap.get(i);
            if (selectedElevator.getDirectionHeaded().equals("ST"))
            {
                break;
            }
        }
        if (!selectedElevator.getDirectionHeaded().equals("ST") || !selectedElevator.getDirectionHeaded().equals("EL"))
        {
            for (int i = 0, j = 1; j < freightMap.size(); i++, j++)
            {
                selectedElevator = freightMap.get(i);
                selectedElevator2 = freightMap.get(j);
                if (selectedElevator.getDirectionHeaded().equals(selection) && selectedElevator.getQueue().size() < selectedElevator2.getQueue().size())
                {
                    continue;
                }
                selectedElevator = freightMap.get(j);
                break;
            }
        }
    }

    public boolean addFloorToSelectedElevatorQueue(int level, String dir)
    {
        if (dir.equals("EL"))
        {
            selectedElevator.addToQueue(level);
            return false;
        }
        selectedElevator.addToQueue(level);
        return true;
    }

    public void addOccupantsToSelectedFloor(int pass)
    {
        selectedFloor = floorMap.get(selectedElevator.getCurrentFloor());
        selectedFloor.setOccupants(selectedFloor.getOccupants() + pass);
    }
    public void addWeightToSelectedFloor(float weight)
    {
        selectedFloor = floorMap.get(selectedElevator.getCurrentFloor());
        selectedFloor.setWeight(selectedFloor.getWeight() + weight);
    }

    public void addOccupantsToSelectedElevator(int occupants)
    {
        if ((selectedElevator.getOccupants() + occupants) > maxOccupancy)
        {
            System.out.println("Exceeds Occupancy Limit. Pick again in a minute.");
        }
        else
        {
            selectedElevator.setOccupants(selectedElevator.getOccupants() + occupants);
        }
    }

    public void addWeightToSelectedElevator(float weight)
    {
        if ((selectedElevator.getWeight() + weight) > maxWeight)
        {
            System.out.println("Exceeds Weight Limit. Pick again in a minute.");
        }
        else
        {
            selectedElevator.setWeight(selectedElevator.getWeight() + weight);
        }
    }

    public void subtractOccupantsFromSelectedElevator(int occupants)
    {
        selectedElevator.setOccupants(selectedElevator.getOccupants() - occupants);
        if (selectedElevator.getOccupants() < 0)
        {
            selectedElevator.setOccupants(0);
        }
    }

    public void subtractWeightFromSelectedElevator(float weight)
    {
        selectedElevator.setWeight(selectedElevator.getWeight() - weight);
        if (selectedElevator.getWeight() < 0)
        {
            selectedElevator.setWeight(0);
        }
    }

    public void processQueues(ArrayList<Integer> list, String dir)
    {
        for (int i = 0; i < list.size(); i++)
        {
            selectedElevator = freightMap.get(list.get(i));
            processElevator(dir);
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        list.clear();
    }

    public void processElevator(String dir)
    {
        if (selectedElevator.getCurrentFloor() == selectedElevator.getQueue().getFirst() && dir.equals("EL"))
        {
            subtractOccupantsFromSelectedElevator(selectedFloor.getOccupants());
            subtractWeightFromSelectedElevator(selectedFloor.getWeight());
            System.out.println("Freight Elevator #" + selectedElevator.hashCode() + "\tStopped at Floor: " + selectedElevator.getQueue().getFirst() + "\tWeight: " +selectedElevator.getWeight());
            selectedElevator.getQueue().removeFirst();
        }
        else if (selectedElevator.getCurrentFloor() == selectedElevator.getQueue().getFirst())
        {
            System.out.println("Freight Elevator #" + selectedElevator.hashCode() + "\tStopped at Floor: " + selectedElevator.getQueue().getFirst() + "\tWeight: " +selectedElevator.getWeight());
            selectedElevator.getQueue().removeFirst();
        }
        if (!selectedElevator.getQueue().isEmpty())
        {
            if (selectedElevator.getCurrentFloor() < selectedElevator.getQueue().getFirst())
            {
                selectedElevator.setDirectionHeaded("UP");
                moveElevator();
            }
            if (selectedElevator.getCurrentFloor() > selectedElevator.getQueue().getFirst())
            {
                Collections.sort(selectedElevator.getQueue().reversed());
                selectedElevator.setDirectionHeaded("DN");
                moveElevator();
            }
        }
    }
    public void moveElevator()
    {
        currentCall = selectedElevator.getQueue().getFirst();
        currentFloor = selectedElevator.getCurrentFloor();

        if (selectedElevator.getDirectionHeaded().equals("UP"))
        {
            currentCall = selectedElevator.getQueue().getFirst();
            currentFloor = selectedElevator.getCurrentFloor();

            System.out.print("\nFreight Elevator #" + selectedElevator.hashCode() + "\tCurrent Floor: " + selectedElevator.getCurrentFloor() + "\tCurrent Floor Call: " + currentCall);
            System.out.println("\tDirection Moving: " + selectedElevator.getDirectionHeaded() + "\tWeight: " +selectedElevator.getWeight());
            System.out.println("Queue: " + selectedElevator.getQueue());
            currentFloor++;
        }
        else if(selectedElevator.getDirectionHeaded().equals("DN"))
        {
            Collections.sort(selectedElevator.getQueue());
            Collections.sort(selectedElevator.getQueue().reversed());
            currentCall = selectedElevator.getQueue().getFirst();
            currentFloor = selectedElevator.getCurrentFloor();

            System.out.print("\nFreight Elevator #" + selectedElevator.hashCode() + "\tCurrent Floor: " + selectedElevator.getCurrentFloor() + "\tCurrent Floor Call: " + currentCall);
            System.out.println("\tDirection Moving: " + selectedElevator.getDirectionHeaded() + "\tWeight: " +selectedElevator.getWeight());
            System.out.println("Queue: " + selectedElevator.getQueue());
            currentFloor--;
        }
        selectedElevator.setCurrentFloor(currentFloor);
        System.out.print("\nFreight Elevator #" + selectedElevator.hashCode() + "\tCurrent Floor: " + selectedElevator.getCurrentFloor() + "\tCurrent Floor Call: " + currentCall);
        System.out.println("\tDirection Moving: " + selectedElevator.getDirectionHeaded() + "\tWeight: " +selectedElevator.getWeight());
    }
}