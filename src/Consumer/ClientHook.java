package Consumer;

import common.Hook;

import java.io.Serializable;

/**
 * Created by ttetu on 17/04/2018.
 */
public class ClientHook implements Hook, Serializable {
    @Override
    public void tema(String matos) {
        System.out.println(matos);
    }
}
