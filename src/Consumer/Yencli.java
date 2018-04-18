package Consumer;

import Producer.Bikraveur;
import Producer.ClientManager;
import common.Hook;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by ttetu on 17/04/2018.
 */
public class Yencli {

    private static final String IP = "localhost";

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        ClientManager server = null;

        try{
            server = (ClientManager) Naming.lookup("rmi://"+IP+"/Bikraveur");
            System.out.println("T'es en bas des blocs !");
            Hook hook = new ClientHook();
            server.subscribe(hook);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Y'a les hendeks !");
        }
    }
}
