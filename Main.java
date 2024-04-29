import javax.swing.*;
/**
 * The Main class contains the main method to start the elevator control system.
 */
public class Main
{
    /**
     * The main method to start the elevator control system.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args)
    {
        Message msg = new Message();
        SwingUtilities.invokeLater(() -> {GUI gui = new GUI(msg);});
        Runnable service = new ServiceThread(msg);
        Runnable passenger = new PassengerThread(msg);
        Runnable freight = new FreightThread(msg);
        Thread t1 = new Thread(service);
        Thread t2 = new Thread(passenger);
        Thread t3 = new Thread(freight);

        try
        {
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e)
        {
            // Print exception message e to console
            System.out.println(e.getMessage());
        }
    }
}