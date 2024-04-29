public class FreightThread implements Runnable
{
    private Message msg;
    private Mechable freight;
    public FreightThread(Message msg)
    {
        freight = new FreightMech();
        this.msg = msg;
    }
    public void run()
    {
        while(true)
        {
            synchronized (msg)
            {
                if (msg.getElevatorType().equalsIgnoreCase("freight"))
                {
                    while(true)
                    {
                        if (!msg.getElevatorType().equalsIgnoreCase("freight"))
                        {
                            break;
                        }
                        if (freight.hasQueueAdditions(msg.getFloorID()))
                        {
                            if (!msg.getElevatorType().equalsIgnoreCase("freight"))
                            {
                                break;
                            }
                            freight.setSelectedElevator(msg.getFloorDirection());
                            if (freight.addFloorToSelectedElevatorQueue(msg.getFloorID(), msg.getFloorDirection()))
                            {
                                if (!msg.getElevatorType().equalsIgnoreCase("freight"))
                                {
                                    break;
                                }
                                try
                                {
                                    freight.addWeightToSelectedElevator(msg.getElevatorWeight());
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                            try
                            {
                                freight.addWeightToSelectedFloor(msg.getElevatorWeight());
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            msg.setFloorID(0);
                            freight.hasQueueAdditions(0);
                        }
                        if (freight.hasQueues())
                        {
                            if (!msg.getElevatorType().equalsIgnoreCase("freight"))
                            {
                                break;
                            }
                            freight.processQueues(freight.getElevatorsWithQueues(), msg.getFloorDirection());
                        }
                    }
                }
            }
        }
    }
}
