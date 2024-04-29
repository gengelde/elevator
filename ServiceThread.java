/**
 * The ServiceThread class represents a thread responsible for processing service elevator requests.
 */
public class ServiceThread implements Runnable
{
    private Message msg;
    private Mechable service;
    /**
     * Constructs a new ServiceThread object with a given message.
     *
     * @param msg The message containing elevator information.
     */
    public ServiceThread(Message msg)
    {
        service = new ServiceMech();
        this.msg = msg;
    }
    /**
     * Runs the service thread, continuously checking for service elevator requests and processing them.
     */
    public void run()
    {
        while(true)
        {
            synchronized (msg)
            {
                if (msg.getElevatorType().equalsIgnoreCase("service"))
                {
                    while(true)
                    {
                        if (!msg.getElevatorType().equalsIgnoreCase("service"))
                        {
                            break;
                        }
                        if (service.hasQueueAdditions(msg.getFloorID()))
                        {
                            if (!msg.getElevatorType().equalsIgnoreCase("service"))
                            {
                                break;
                            }
                            service.setSelectedElevator(msg.getFloorDirection());
                            if (service.addFloorToSelectedElevatorQueue(msg.getFloorID(), msg.getFloorDirection()))
                            {
                                if (!msg.getElevatorType().equalsIgnoreCase("service"))
                                {
                                    break;
                                }
                                try
                                {
                                    service.addOccupantsToSelectedElevator(msg.getElevatorPassengers());
                                    Thread.sleep(100);
                                    service.addWeightToSelectedElevator(msg.getElevatorWeight());
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                            try
                            {
                                service.addOccupantsToSelectedFloor(msg.getElevatorPassengers());
                                Thread.sleep(100);
                                service.addWeightToSelectedFloor(msg.getElevatorWeight());
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            msg.setFloorID(0);
                            service.hasQueueAdditions(0);
                        }
                        if (service.hasQueues())
                        {
                            if (!msg.getElevatorType().equalsIgnoreCase("service"))
                            {
                                break;
                            }
                            service.processQueues(service.getElevatorsWithQueues(), msg.getFloorDirection());
                        }
                    }
                }
            }
        }
    }
}
