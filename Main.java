public class Main
{
    public static void main(String[] args)
    {
        UI ui = new UI();
        ServiceElevator service = new ServiceElevator();
        Elevator serviceElevator = service.serviceMap.get(1);
        service.printMap();
        serviceElevator.setCurrentFloor(Integer.parseInt(ui.getUserInput()));
        service.printMap();

        if (service.checkStationary())
        {
            System.out.println("Service elevator: " + service.getSelectedElevator() + " is stationary");
        }
    }
}