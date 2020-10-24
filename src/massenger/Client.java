package massenger;

import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        try
        {
            //String cName;
            //cName = in.nextLine();
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            NetworkUtil nc = new NetworkUtil(serverAddress, serverPort);
            new ReadThread(nc);
            new WriteThreadClient(nc);
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
