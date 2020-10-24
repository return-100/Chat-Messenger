package massenger;

import java.util.Scanner;

public class WriteThreadClient implements Runnable
{

    private Thread thr;
    private NetworkUtil nc;
    String name;

    public WriteThreadClient(NetworkUtil nc)
    {
        this.nc = nc;
        this.name = "Client"+cnt.i;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run()
    {
        try
        {
            Scanner input = new Scanner(System.in);

            while (true)
            {
                String s = input.nextLine();
                this.nc.write(this.name + ": " + s);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
        nc.closeConnection();
    }
}
