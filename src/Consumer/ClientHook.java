package Consumer;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ttetu on 17/04/2018.
 */
public class ClientHook extends UnicastRemoteObject implements Hook, Serializable {
    protected ClientHook() throws RemoteException {
    }

    @Override
    public void push(String s) throws RemoteException {
        System.out.println(s);
    }
}
