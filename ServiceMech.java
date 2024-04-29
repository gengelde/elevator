import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * The ServiceMech class represents the mechanism for managing service elevators.
 * It implements the Mechable, Elevatable, and Floorable interfaces.
 */
public class ServiceMech extends Elevator implements Mechable, Elevatable, Floorable
{
    private final int numServiceElevators = 2;
    private final int numFloors = 10;
    private final int maxOccupancy = 8;
    private int currentCall;
    private int currentFloor;
    private final float maxWeight = 3500.0f;
    private ArrayList<Integer> list = new ArrayList<>();
    private HashMap<Integer, Elevator> serviceMap = new HashMap<>();
    private HashMap<Integer, Floor> floorMap = new HashMap<>();
    private Elevatable selectedElevator;
    private Elevatable selectedElevator2;
    private Floorable selectedFloor;
    private Factory Factor;
    /**
     * Constructs a new ServiceMech object and initializes the service elevators and floors.
     */
    public ServiceMech()
    {
        Factor = new Factory();
        selectedFloor = Factor.getFloor();
        selectedElevator = Factor.getElevator();
        selectedElevator2 = Factor.getElevator();
        loadMaps();
    }
    /**
     * Initializes the service elevator and floor maps.
     */
    public void loadMaps()
    {
        for (int i = 0; i < numServiceElevators; i++)
        {
            Elevator service = new Elevator();
            serviceMap.put(i, service);
        }
        for (int i = 0; i < numFloors; i++)
        {
            Floor floor = new Floor();
            floorMap.put(i, floor);
        }
    }
    /**
     * Checks if any service elevator has pending floor requests in its queue.
     *
     * @return {@code true} if at least one service elevator has pending floor requests,
     *         {@code false} otherwise.
     */
    public boolean hasQueues()
    {
        for (int i = 0; i < numServiceElevators; i++)
        {
            selectedElevator = serviceMap.get(i);
            if (!selectedElevator.getQueue().isEmpty())
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Retrieves the list of service elevators that have pending floor requests in their queues.
     *
     * @return An ArrayList containing the indices of service elevators with pending floor requests.
     */
    public ArrayList<Integer> getElevatorsWithQueues()
    {
        for (int i = 0; i < numServiceElevators; i++)
        {
            selectedElevator = serviceMap.get(i);
            if (!selectedElevator.getQueue().isEmpty())
            {
                list.add(i);
            }
        }
        return list;
    }
    /**
     * Checks if there are additions to the queue.
     *
     * @param addition The number of additions to the queue.
     * @return {@code true} if there are additions to the queue, {@code false} otherwise.
     */
    public boolean hasQueueAdditions(int addition)
    {
        if (addition == 0)
        {
            return false;
        }
        return true;
    }
    /**
     * Sets the selected elevator based on the specified direction.
     * If there is no elevator currently heading to the destination or standing still (ST),
     * it selects the first available elevator.
     * If there are multiple elevators heading in the same direction, it selects the one with the smaller queue size.
     *
     * @param selection The direction for which the elevator is being selected ('ST' for standing still, 'EL' for an active direction).
     */
    public void setSelectedElevator(String selection)
    {
        for (int i = 0; i < serviceMap.size(); i++)
        {
            selectedElevator = serviceMap.get(i);
            if (selectedElevator.getDirectionHeaded().equals("ST"))
            {
                break;
            }
        }
        if (!selectedElevator.getDirectionHeaded().equals("ST") || !selectedElevator.getDirectionHeaded().equals("EL"))
        {
            for (int i = 0, j = 1; j < serviceMap.size(); i++, j++)
            {
                selectedElevator = serviceMap.get(i);
                selectedElevator2 = serviceMap.get(j);
                if (selectedElevator.getDirectionHeaded().equals(selection) && selectedElevator.getQueue().size() < selectedElevator2.getQueue().size())
                {
                    continue;
                }
                selectedElevator = serviceMap.get(j);
                break;
            }
        }
    }
    /**
     * Adds a floor to the queue of the selected elevator.
     *
     * If the direction is "EL" (elevator direction), it adds the floor to the queue without changing the elevator's direction.
     *
     * @param level The floor level to be added to the elevator's queue.
     * @param dir The direction in which the elevator is moving ("EL" for elevator direction, "UP" or "DN" for floor requests).
     * @return {@code false} if the direction is "EL", indicating that the elevator's direction is unchanged, otherwise {@code true}.
     */
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
    /**
     * Adds occupants to the selected floor's occupancy count.
     *
     * @param pass The number of occupants to be added to the selected floor's occupancy count.
     */
    public void addOccupantsToSelectedFloor(int pass)
    {
        selectedFloor = floorMap.get(selectedElevator.getCurrentFloor());
        selectedFloor.setOccupants(selectedFloor.getOccupants() + pass);
    }
    /**
     * Adds weight to the selected floor's total weight.
     *
     * @param weight The weight to be added to the selected floor's total weight.
     */
    public void addWeightToSelectedFloor(float weight)
    {
        selectedFloor = floorMap.get(selectedElevator.getCurrentFloor());
        selectedFloor.setWeight(selectedFloor.getWeight() + weight);
    }
    /**
     * Adds occupants to the selected elevator's occupancy count if the addition does not exceed the maximum occupancy limit.
     *
     * @param occupants The number of occupants to be added to the selected elevator's occupancy count.
     */
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
    /**
     * Adds weight to the selected elevator's total weight if the addition does not exceed the maximum weight limit.
     *
     * @param weight The weight to be added to the selected elevator's total weight.
     */
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
    /**
     * Subtracts the specified number of occupants from the selected elevator's current occupants count.
     *
     * @param occupants The number of occupants to be subtracted from the selected elevator.
     */
    public void subtractOccupantsFromSelectedElevator(int occupants)
    {
        selectedElevator.setOccupants(selectedElevator.getOccupants() - occupants);
        if (selectedElevator.getOccupants() < 0)
        {
            selectedElevator.setOccupants(0);
        }
    }
    /**
     * Subtracts the specified weight from the selected elevator's current weight.
     *
     * @param weight The weight to be subtracted from the selected elevator.
     */
    public void subtractWeightFromSelectedElevator(float weight)
    {
        selectedElevator.setWeight(selectedElevator.getWeight() - weight);
        if (selectedElevator.getWeight() < 0)
        {
            selectedElevator.setWeight(0);
        }
    }
    /**
     * Processes the elevator queues based on the given direction.
     *
     * @param list The list of elevators with queues.
     * @param dir The direction in which the elevators are moving.
     */
    public void processQueues(ArrayList<Integer> list, String dir)
    {
        for (int i = 0; i < list.size(); i++)
        {
            selectedElevator = serviceMap.get(list.get(i));
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
    /**
     * Processes the selected elevator based on its current state and direction.
     * If the elevator reaches its destination floor and the direction is "EL" (elevator type),
     * it subtracts the occupants and weight from the elevator's current floor and removes the first
     * floor from the elevator's queue. If the elevator reaches its destination floor, it simply
     * removes the first floor from the queue. Then, it checks if there are more floors in the queue
     * and adjusts the direction of the elevator accordingly to move towards the next floor.
     *
     * @param dir The direction in which the elevator is moving.
     */
    public void processElevator(String dir)
    {
        if (selectedElevator.getCurrentFloor() == selectedElevator.getQueue().getFirst() && dir.equals("EL"))
        {
            subtractOccupantsFromSelectedElevator(selectedFloor.getOccupants());
            subtractWeightFromSelectedElevator(selectedFloor.getWeight());
            System.out.println("Service Elevator #" + selectedElevator.hashCode() + "\tStopped at Floor: " + selectedElevator.getQueue().getFirst() + "\tOccupancy: " + selectedElevator.getOccupants() + "\tWeight: " +selectedElevator.getWeight());
            selectedElevator.getQueue().removeFirst();
        }
        else if (selectedElevator.getCurrentFloor() == selectedElevator.getQueue().getFirst())
        {
            System.out.println("Service Elevator #" + selectedElevator.hashCode() + "\tStopped at Floor: " + selectedElevator.getQueue().getFirst() + "\tOccupancy: " + selectedElevator.getOccupants() + "\tWeight: " +selectedElevator.getWeight());
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
    /**
     * Moves the selected elevator based on its direction. If the elevator is moving "UP", it increments
     * the current floor and displays information about the elevator's status. If the elevator is moving "DN" (down),
     * it decrements the current floor. After moving the elevator, it updates the current floor and displays
     * information about the elevator's status, including the current floor, direction, occupancy, weight,
     * and the queue of floors to visit.
     */
    public void moveElevator()
    {
        currentCall = selectedElevator.getQueue().getFirst();
        currentFloor = selectedElevator.getCurrentFloor();

        if (selectedElevator.getDirectionHeaded().equals("UP"))
        {
            currentCall = selectedElevator.getQueue().getFirst();
            currentFloor = selectedElevator.getCurrentFloor();

            System.out.print("\nService Elevator #" + selectedElevator.hashCode() + "\tCurrent Floor: " + selectedElevator.getCurrentFloor() + "\tCurrent Floor Call: " + currentCall);
            System.out.println("\tDirection Moving: " + selectedElevator.getDirectionHeaded() + "\tOccupancy: " + selectedElevator.getOccupants() + "\tWeight: " +selectedElevator.getWeight());
            System.out.println("Queue: " + selectedElevator.getQueue());
            currentFloor++;
        }
        else if(selectedElevator.getDirectionHeaded().equals("DN"))
        {
            Collections.sort(selectedElevator.getQueue());
            Collections.sort(selectedElevator.getQueue().reversed());
            currentCall = selectedElevator.getQueue().getFirst();
            currentFloor = selectedElevator.getCurrentFloor();

            System.out.print("\nService Elevator #" + selectedElevator.hashCode() + "\tCurrent Floor: " + selectedElevator.getCurrentFloor() + "\tCurrent Floor Call: " + currentCall);
            System.out.println("\tDirection Moving: " + selectedElevator.getDirectionHeaded() + "\tOccupancy: " + selectedElevator.getOccupants() + "\tWeight: " +selectedElevator.getWeight());
            System.out.println("Queue: " + selectedElevator.getQueue());
            currentFloor--;
        }
        selectedElevator.setCurrentFloor(currentFloor);
        System.out.print("\nService Elevator #" + selectedElevator.hashCode() + "\tCurrent Floor: " + selectedElevator.getCurrentFloor() + "\tCurrent Floor Call: " + currentCall);
        System.out.println("\tDirection Moving: " + selectedElevator.getDirectionHeaded() + "\tOccupancy: " + selectedElevator.getOccupants() + "\tWeight: " +selectedElevator.getWeight());
    }
}
