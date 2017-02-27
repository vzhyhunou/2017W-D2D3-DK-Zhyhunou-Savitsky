package org.jmp17.plug.api;

/**
 * Created by antonsavitsky on 2/26/17.
 */
public interface PluginApi {
    Result run(Param param);
    String manual();
}
