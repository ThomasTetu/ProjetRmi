package Consumer;

import Producer.Manager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client {

    private static final String IP = "localhost";

    private Client() {}

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Manager server;

        try{
            server = (Manager) Naming.lookup("rmi://"+IP+"/ClientManager");
            System.out.println("Subscribing to server...");
            Hook hook = new ClientHook();
            server.subscribe(hook);
            System.out.println("Ready to receive data");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
