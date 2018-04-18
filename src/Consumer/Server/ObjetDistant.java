package Consumer.Server;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ttetu on 28/02/2018.
 */
public class ObjetDistant extends UnicastRemoteObject implements Distante{

    private static final String IP = "localhost";
    private static  Service serviceReference;

    public ObjetDistant() throws RemoteException {
        super();
    }



    public static void main(String args[]) throws RemoteException, UnknownHostException, MalformedURLException, AlreadyBoundException {
        ObjetDistant obj = new ObjetDistant();
        LocateRegistry.createRegistry(1099);
        Registry r = LocateRegistry.getRegistry();
        r.bind("tp1.Distante",obj);
        String url = "rmi://"+IP+"/Distante";
        Naming.rebind(url,obj);

    }

    @Override
    public Service get_service(int value) throws RemoteException {
        if (serviceReference == null){
            serviceReference= new Service(value);
        }
        System.out.println("Service retrieved\n");
        return serviceReference;
    }
}
