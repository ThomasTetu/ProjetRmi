package Producer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ttetu on 17/04/2018.
 */
public class Server {

    private static final String IP = "localhost";

    public static void main(String[] args) throws Exception {
        try{
            ClientManager server = new ClientManager();
            LocateRegistry.createRegistry(1099);
            Registry r = LocateRegistry.getRegistry();
            r.bind("ClientManager",server);
            String url = "rmi://"+IP+"/ClientManager";
            Naming.rebind(url,server);
            System.out.println("Ready to stream... Waiting for clients to join");

            while(true){
                FileReader input = new FileReader("src/datasource.txt");

                BufferedReader bufRead = new BufferedReader(input);
                String line = null;

                while ( (line = bufRead.readLine()) != null)
                {
                    server.sayToAll(line);
                    Thread.sleep(2000);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
