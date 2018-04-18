package Producer;

import Consumer.Hook;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ttetu on 18/04/2018.
 */
public interface Manager extends Remote {

    public void subscribe(Hook iencli) throws RemoteException;
    public void unSubscribe(Hook iencli) throws RemoteException;
}
