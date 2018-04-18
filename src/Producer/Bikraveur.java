package Producer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by ttetu on 17/04/2018.
 */
public class Bikraveur {

    private static final String IP = "localhost";

    public static void main(String[] args) throws Exception {
        try{
            ClientManager server = new ClientManager();
            LocateRegistry.createRegistry(1099);
            String url = "rmi://"+IP+"/Bikraveur";
            Naming.rebind(url,server);
            System.out.println("On est la, rdy pour visser tu le c !");

            while(true){
                FileReader input = new FileReader("src/datasource.txt");

                BufferedReader bufRead = new BufferedReader(input);
                String ligneDeC = null;

                while ( (ligneDeC = bufRead.readLine()) != null)
                {
                    server.bikrave(ligneDeC);
                    Thread.sleep(1000);
                }
            }
        }catch (Exception e){

            e.printStackTrace();
            System.err.println("Y'a les hendeks !");
        }
    }



}
