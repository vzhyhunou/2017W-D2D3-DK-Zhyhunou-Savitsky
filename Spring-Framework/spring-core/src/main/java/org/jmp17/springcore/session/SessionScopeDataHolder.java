package org.jmp17.springcore.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asavitsky on 3/30/17.
 */
@Component
public class SessionScopeDataHolder {

    @Autowired
    private SessionScopeData sessionScopeData;

    public SessionScopeData getSessionScopeData(){
        return sessionScopeData;
    }
}
