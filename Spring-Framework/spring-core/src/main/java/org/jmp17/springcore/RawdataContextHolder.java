package org.jmp17.springcore;

import org.springframework.stereotype.Component;

/**
 * Created by asavitsky on 3/28/17.
 */
@Component
public class RawdataContextHolder {

    private String rawData;

    public void put(String rawData){
        this.rawData = rawData;
    }

    public String getRawData(){
        return rawData;
    }
}
