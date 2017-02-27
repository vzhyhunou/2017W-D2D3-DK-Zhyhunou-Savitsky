package org.jmp17.plugin;

import org.jmp17.plug.api.Param;
import org.jmp17.plug.api.PluginApi;
import org.jmp17.plug.api.Result;

/**
 * Created by antonsavitsky on 2/21/17.
 */
public class SystemInfoPlugin implements PluginApi{

    @Override
    public Result run(Param param) {
        SystemInfo systemInfo = new SystemInfo();
        System.getProperties().forEach((key, value) -> {
            systemInfo.getResults().add(key + "=" + value);
        });
        return systemInfo;
    }

    @Override
    public String manual() {
        return "-----Manual------\nSysInfo plugin is responsible for the retrieval of system specific info" +
                ", e.g. system variables.";
    }
}
