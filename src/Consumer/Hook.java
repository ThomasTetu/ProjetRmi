package Consumer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ttetu on 17/04/2018.
 */
public interface Hook extends Remote {
    void tema(String matos) throws RemoteException;
}
