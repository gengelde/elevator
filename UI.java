import java.util.Scanner;

public class UI
{
    String input;
    public UI()
    {

    }
    public String getUserInput()
    {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }
}
