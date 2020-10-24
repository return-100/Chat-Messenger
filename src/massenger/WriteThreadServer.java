package massenger;

import java.util.*;

public class WriteThreadServer implements Runnable
{

    private Thread thr;
    public String name;
    public Hashtable<String, NetworkUtil> table;

    public WriteThreadServer(Hashtable<String, NetworkUtil> table, String name)
    {
        this.table = table;
        this.name = name;
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
                String s1 = input.nextLine();
                String s2 = input.nextLine();
                //System.out.println(s);
                StringTokenizer st = new StringTokenizer(s1);
                String cName = st.nextToken();
                NetworkUtil nc = table.get(cName);
                if (nc != null)
                {
                    nc.write(name + ": " + s2);
                }
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
