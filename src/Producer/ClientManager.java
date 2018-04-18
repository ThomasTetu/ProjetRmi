package Producer;

import common.Hook;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ttetu on 17/04/2018.
 */
public class ClientManager extends UnicastRemoteObject{

    private List<Hook> hooks = new ArrayList<>();
    protected ClientManager() throws RemoteException {
    }

    public void bikrave(String matos){
        Iterator i = hooks.iterator();
        while (i.hasNext()){
            ((Hook) i.next()).tema(matos);
        }
    }

    public void subscribe(Hook iencli) throws RemoteException{
        this.hooks.add(iencli);
        System.out.println("Le iencli est la !");
    }

    public void unSubscribe(Hook iencli) throws RemoteException{
        this.hooks.remove(iencli);
        System.out.println("Le iencli est tipar !");
    }

}