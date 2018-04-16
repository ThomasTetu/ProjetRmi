package Consumer.Server;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ttetu on 28/02/2018.
 */
public interface Distante extends Remote {

   public Service get_service(int value)throws RemoteException;
}
