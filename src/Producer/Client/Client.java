package Producer.Client;
/**
 * Created by ttetu on 28/02/2018.
 */
import Consumer.Server.Distante;

import java.rmi.Naming;

public class Client {

    private static final String IP = "localhost";
    private Client() {}

    public static void main(String[] args) {
        System.out.println("Lancement du client");

        Distante stub;
        try {
            stub = (Distante) Naming.lookup("rmi://"+IP+"/Distante");
            System.out.println("AVANT");
            stub.get_service(3);
            System.out.println("APRES");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
