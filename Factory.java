public class Factory
{
    // Load Classes
    private Interactable Ui;
    private Logable Log;
    private Connectable Conn;
//    private Transportable Elev;
    public Factory()
    {
        // Load Classes
        Ui = new UI();
        Log = new Logger();
        Conn = new DataConnect();
//        Elev = new Elevator();
    }
    public Interactable getUI()
    {
        // return class 'Ui'
        return Ui;
    }
    public Logable getLog()
    {
        // return class 'Log'
        return Log;
    }
    public Connectable getConn()
    {
        // return class 'Conn'
        return Conn;
    }
//    public Transportable getElev()
//    {
//        // return class 'Elev'
//        return Elev;
//    }
}
