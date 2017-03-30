package org.jmp17.springcore.session;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by asavitsky on 3/30/17.
 */
@Component
public class SessionScopeData {
    private final Date date;

    public SessionScopeData(Date date) {
        this.date = date;
    }

    public String getDate(){
        return date.toString();
    }
}
