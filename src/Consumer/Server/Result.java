package Consumer.Server;

import java.io.Serializable;

/**
 * Created by ttetu on 12/04/2018.
 */
public class Result implements Serializable{

    private int result;

    public Result(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "tp1.Result{" +
                "result=" + result +
                '}';
    }
}
