package Producer;

import Consumer.Hook;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ttetu on 17/04/2018.
 */
public class ClientManager extends UnicastRemoteObject implements Manager{

    private List<Hook> hooks = new ArrayList<>();
    ClientManager() throws RemoteException {
    }

    public void sayToAll(String s) throws RemoteException {
        Iterator i = hooks.iterator();
        while (i.hasNext()){
            ((Hook) i.next()).push(s);
        }
    }

    public void subscribe(Hook iencli) throws RemoteException{
        this.hooks.add(iencli);
        System.out.println("A client joined");
    }

    public void unSubscribe(Hook iencli) throws RemoteException{
        this.hooks.remove(iencli);
        System.out.println("A client left");
    }

}