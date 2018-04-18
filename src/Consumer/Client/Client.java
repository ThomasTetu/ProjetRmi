package Consumer.Client;

import Consumer.Server.Distante;

import java.rmi.Naming;

/**
 * Created by ttetu on 17/04/2018.
 */
public class Client {

    private static final String IP = "localhost";

    private Client() {}

    public static void main(String[] args) {
        System.out.println("Lancement du client");

        Distante stub;
        try {
            stub = (Distante) Naming.lookup("rmi://"+IP+"/Distante");
        } catch (Exception e) {
            System.err.println("Prod exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
