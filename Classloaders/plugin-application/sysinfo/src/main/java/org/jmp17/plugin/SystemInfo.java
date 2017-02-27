package org.jmp17.plugin;

import org.jmp17.plug.api.Result;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by antonsavitsky on 2/26/17.
 */
public class SystemInfo implements Result {

    private Set<String> sysInfoSet;

    public SystemInfo() {
        this.sysInfoSet = new HashSet<>();
    }

    @Override
    public Set<String> getResults() {
        return sysInfoSet;
    }

    @Override
    public void setResults(Set result) {
        System.out.println("To be implemented");
    }

    public Set<String> getInfo() {
        return sysInfoSet;
    }

    public void setInfo(Set<String> sysInfoSet) {
        this.sysInfoSet = sysInfoSet;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "\n" + sysInfoSet.stream().map(e->e).collect(Collectors.joining("\n")) +
                '}';
    }
}
