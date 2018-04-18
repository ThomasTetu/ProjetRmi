package Producer;

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
            LocateRegistry.createRegistry(1091);
            String url = "rmi://"+IP+"/Bikraveur";
            Naming.rebind(url,server);
            System.out.println("On est la, rdy pour visser tu le c !");
            //envoyer du contenu de qualité, server.publish huet
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Y'a les hendeks !");
        }
    }

}
