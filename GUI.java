import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI implements ActionListener
{
    final int FLOORS = 10;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private String floorID;
    private String elevatorType;
    private String passengerAmount;
    private String weightAmount;
    private String floorDirection;
    private JLabel codeLabel;
    private JButton[] callButtons;
    private JButton[] elevButtons;
    private JButton idButton;
    private int convertedFloorID;
    private int convertedPassengerAmount;
    private float convertedElevatorWeight;
    private int userID;
    private int count;
    private JPanel floor;
    private JLabel passLabel;
    private JLabel weightLabel;
    private JLabel idLabel;
    private JPanel upper;
    private JPanel middle;
    private JPanel lower;
    private JPanel bottom;
    private JFrame frame;
    private JPanel FloorButtPane;
    private JPanel CallButtPane;
    private JPanel TextInputPane;
    private Message msg;
    private Connectable connect = new Connect();
    public GUI(Message msg)
    {
        this.msg = msg;
        //storage for call buttons (up/down per floor)
        callButtons = new JButton[2*FLOORS];

        //storage for elevator buttons
        elevButtons = new JButton[FLOORS];

        //set up the main frame
        frame = new JFrame("Elevator Control Panel");
        frame.setLayout(new GridLayout(1, 3));
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //create new panel for Floor Buttons
        FloorButtPane = new JPanel();
        FloorButtPane.setLayout(new GridLayout(5, 2));
        FloorButtPane.setSize(300,600);

        //create new panel for Elevator Buttons
        CallButtPane = new JPanel();
        CallButtPane.setLayout(new GridLayout(5, 2));
        CallButtPane.setSize(300,600);

        //create new panel for input and updates
        TextInputPane = new JPanel();
        TextInputPane.setLayout(new FlowLayout());
        TextInputPane.setSize(300,600);

        //create the up/down buttons and store them in the
        //callButtons array.  Up are even indexes and down
        //are odd indexes
        populateCallButtonArray(callButtons);

        //add created buttons to a panel
        //add panel to FloorButtPane
        for( int i = 0; i < FLOORS*2; i++)
        {
            floor = new JPanel();
            floor.setLayout(new FlowLayout());
            floor.add(callButtons[i]);
            callButtons[i].addActionListener(this);
            i++;
            floor.add(callButtons[i]);
            callButtons[i].addActionListener(this);
            CallButtPane.add(floor);
        }

        //create and add buttons to FloorButtPane
        populateElevatorButtonArray(elevButtons);

        //add elevator buttons to the FloorButtPane
        for( int i = 0; i < FLOORS; i++)
        {
            elevButtons[i].addActionListener(this);
            FloorButtPane.add(elevButtons[i]);
        }

        //Text Pane components
        codeLabel = new JLabel("Enter Elevator Code");
        textField1 = new JTextField(20);
        passLabel = new JLabel("Enter Passenger Amount");
        textField2 = new JTextField(20);
        weightLabel = new JLabel("Enter Weight Amount");
        textField3 = new JTextField(20);
        idLabel = new JLabel("Enter ID");
        textField4 = new JTextField(20);
        idButton = new JButton("Submit ID");
        idButton.addActionListener(this);
        upper = new JPanel();
        upper.setLayout(new GridLayout(3, 1));
        middle = new JPanel();
        middle.setLayout(new GridLayout(3,1));
        lower = new JPanel();
        lower.setLayout(new GridLayout(3, 1));
        bottom = new JPanel();
        bottom.setLayout(new GridLayout(3, 1));
        upper.add(codeLabel);
        upper.add(textField1);
        middle.add(passLabel);
        middle.add(textField2);
        lower.add(weightLabel);
        lower.add(textField3);
        bottom.add(idLabel);
        bottom.add(textField4);
        bottom.add(idButton);
        TextInputPane.add(upper);
        TextInputPane.add(middle);
        TextInputPane.add(lower);
        TextInputPane.add(bottom);

        //add pane to frame grid
        frame.add(CallButtPane);
        frame.add(FloorButtPane);
        frame.add(TextInputPane);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        elevatorType = textField1.getText();
        if (!elevatorType.equalsIgnoreCase("passenger") && !textField4.getText().isEmpty())
        {
            userID = Integer.parseInt(textField4.getText());
            connect.setUserData(userID);
        }
        if (e.getActionCommand().equals("Submit ID") && elevatorType.equalsIgnoreCase("passenger"))
        {
            msg.setElevatorType(elevatorType);
            userID = Integer.parseInt(textField4.getText());
            connect.setUserData(userID);
            msg.setFloorID(connect.getUserDestination());
            msg.setFloorDirection("EL");
        }
        else
        {
            floorDirection = e.getActionCommand().substring(0, 2);
            floorID = e.getActionCommand().substring(2, 4);
            if (!floorID.equalsIgnoreCase("bm"))
            {
                convertedFloorID = Integer.parseInt(floorID);
                msg.setFloorDirection(floorDirection);
                msg.setFloorID(convertedFloorID);
            }
        }
        if ((elevatorType.equalsIgnoreCase("service") && !connect.getAccessLevel().equalsIgnoreCase("Employee")) || (elevatorType.equalsIgnoreCase("freight") && !connect.getAccessLevel().equalsIgnoreCase("Employee")))
        {
            System.out.println("Access Denied");
            elevatorType = "";
        }
        if (elevatorType.equalsIgnoreCase("service") && connect.getAccessLevel().equalsIgnoreCase("Employee"))
        {
            msg.setElevatorType(elevatorType);
            passengerAmount = textField2.getText();
            if (!passengerAmount.isEmpty())
            {
                convertedPassengerAmount = Integer.parseInt(passengerAmount);
                msg.setPassengerAmount(convertedPassengerAmount);
            }
            weightAmount = textField3.getText();
            if (!weightAmount.isEmpty())
            {
                convertedElevatorWeight = Float.parseFloat(weightAmount);
                msg.setElevatorWeight(convertedElevatorWeight);
            }
        }
        else if (elevatorType.equalsIgnoreCase("passenger")) {
            msg.setElevatorType(elevatorType);
            passengerAmount = textField2.getText();
            if (!passengerAmount.isEmpty()) {
                convertedPassengerAmount = Integer.parseInt(passengerAmount);
                msg.setPassengerAmount(convertedPassengerAmount);
            }
        }
        else if (elevatorType.equalsIgnoreCase("freight") && connect.getAccessLevel().equalsIgnoreCase("Employee")) {
            msg.setElevatorType(elevatorType);
            weightAmount = textField3.getText();
            if (!weightAmount.isEmpty()) {
                convertedElevatorWeight = Float.parseFloat(weightAmount);
                msg.setElevatorWeight(convertedElevatorWeight);
            }
        }
    }

    public void populateCallButtonArray(JButton[] arr)
    {
        count = 1;
        for( int i = 0; i < 2*FLOORS; i++)
        {
            JButton up1 = new JButton(count<10?"UP0" + (count):"UP" + count);
            JButton down1 = new JButton(count<10?"DN0" + (count):"DN" + count);
            arr[i] = up1;
            i++;
            arr[i] = down1;
            count++;
        }
    }

    public void populateElevatorButtonArray(JButton[] arr)
    {
        for( int i = 0; i < FLOORS; i++ )
        {
            arr[i] = new JButton(i<9?"EL0" + (i+1) + "  " :"EL" + (i+1) + "  ");
        }
    }
}