package Producer;

import Consumer.Hook;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class ClientManager extends UnicastRemoteObject implements Manager{

    private Map<Integer,Hook> hooks;
    ClientManager() throws RemoteException {
        hooks = new HashMap<>();
    }

    public void sayToAll(String s) throws RemoteException {

        for (Map.Entry<Integer, Hook> pair : hooks.entrySet()) {
            pair.getValue().push(s);
        }
    }

    public void subscribe(Hook iencli) throws RemoteException{
        Random r = new Random();
        int id = r.nextInt(1000000)+1;
        while(hooks.containsKey(id)) id = r.nextInt();

        this.hooks.put(id,iencli);
        System.out.println("A client joined (id : "+id+")");
    }

    public void unSubscribe(Hook iencli) throws RemoteException{
        this.hooks.remove(iencli);
        System.out.println("A client left");
    }

}