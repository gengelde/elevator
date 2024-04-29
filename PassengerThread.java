/**
 * The PassengerThread class represents a thread responsible for processing passenger elevator requests.
 */
public class PassengerThread implements Runnable
{
    private Message msg;
    private Mechable passenger;
    /**
     * Constructs a new PassengerThread object with a given message.
     *
     * @param msg The message containing elevator information.
     */
    public PassengerThread(Message msg)
    {
        passenger = new PassengerMech();
        this.msg = msg;
    }
    /**
     * Runs the passenger thread, continuously checking for passenger elevator requests and processing them.
     */
    public void run()
    {
        while(true)
        {
            synchronized (msg)
            {
                if (msg.getElevatorType().equalsIgnoreCase("passenger"))
                {
                    while(true)
                    {
                        if (!msg.getElevatorType().equalsIgnoreCase("passenger"))
                        {
                            break;
                        }
                        if (passenger.hasQueueAdditions(msg.getFloorID()))
                        {
                            if (!msg.getElevatorType().equalsIgnoreCase("passenger"))
                            {
                                break;
                            }
                            passenger.setSelectedElevator(msg.getFloorDirection());
                            if (passenger.addFloorToSelectedElevatorQueue(msg.getFloorID(), msg.getFloorDirection()))
                            {
                                if (!msg.getElevatorType().equalsIgnoreCase("passenger"))
                                {
                                    break;
                                }
                                try
                                {
                                    passenger.addOccupantsToSelectedElevator(msg.getElevatorPassengers());
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                            try
                            {
                                passenger.addOccupantsToSelectedFloor(msg.getElevatorPassengers());
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            msg.setFloorID(0);
                            passenger.hasQueueAdditions(0);
                        }
                        if (passenger.hasQueues())
                        {
                            if (!msg.getElevatorType().equalsIgnoreCase("passenger"))
                            {
                                break;
                            }
                            passenger.processQueues(passenger.getElevatorsWithQueues(), msg.getFloorDirection());
                        }
                    }
                }
            }
        }
    }
}
