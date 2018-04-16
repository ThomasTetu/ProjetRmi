package Consumer.Server;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * Created by ttetu on 12/04/2018.
 */
public class Service implements Remote, Serializable{

    private int val;

    Service(int v){ val = v;}

    public void addVal(int val) {
        this.val += val;
    }
}
