package org.jmp17;

import org.jmp17.service.UserServicePortType;
import org.jmp17.service.UserServiceRequestType;
import org.jmp17.service.UserServiceResponseType;
import org.jmp17.service.UserType;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by antonsavitsky on 3/17/17.
 */
@WebService(endpointInterface="org.jmp17.service.UserServicePortType")
public class UserServicePortImpl implements UserServicePortType {
    private List<UserType> users;

    public UserServicePortImpl(){
        UserType user1 = new UserType();
        user1.setName("Anton");
        user1.setEmail("antony.sawicki@gmail.com");
        UserType user2= new UserType();
        user2.setName("Andrei");
        user2.setEmail("andrei.ivanov@tut.by");
        users = new ArrayList<>(Arrays.asList(user1, user2));
    }

    @Override
    public UserServiceResponseType getUser(UserServiceRequestType userServiceRequest) {
        String userName = userServiceRequest.getUserName();
        UserServiceResponseType response = new UserServiceResponseType();
        Optional<UserType> user = users.stream()
                .filter(u -> u.getName().equals(userName))
                .findFirst();
        response.setUser( user.isPresent() ? user.get() : null);
        return response;
    }
}
