package massenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

class cnt
{
    static int i = 1;
}

public class Server
{

    private ServerSocket ServSock;
    public Hashtable<String, NetworkUtil> table;

    Server()
    {
        table = new Hashtable<>();
        try
        {
            ServSock = new ServerSocket(33333);
            new WriteThreadServer(table, "Server");
            while (true)
            {
                Socket clientSock = ServSock.accept();
                System.out.println("Client[" + cnt.i +"] : Has Entered");
                NetworkUtil nc = new NetworkUtil(clientSock);
                table.put("Client" + cnt.i++, nc);
                new ReadThread(nc);
            }
        } catch (IOException e)
        {
            System.out.println("Server starts:" + e);
        }
    }

    public static void main(String args[])
    {
        Server objServer = new Server();
    }
}
