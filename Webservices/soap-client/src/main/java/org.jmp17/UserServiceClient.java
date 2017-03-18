package org.jmp17;

import org.jmp17.client.UserServicePortType;
import org.jmp17.client.UserServiceRequestType;
import org.jmp17.client.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by antonsavitsky on 3/18/17.
 */
@Component
public class UserServiceClient {

    @Autowired
    private UserServicePortType userServicePort;

    public UserType getUserByName(String name){
        UserServiceRequestType request = new UserServiceRequestType();
        request.setUserName(name);
        UserType user = userServicePort.getUser(request).getUser();
        return user;
    }

}
