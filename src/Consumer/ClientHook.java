package Consumer;

import common.Hook;

/**
 * Created by ttetu on 17/04/2018.
 */
public class ClientHook implements Hook {
    @Override
    public void tema(String matos) {
        System.out.println(matos);
    }
}
