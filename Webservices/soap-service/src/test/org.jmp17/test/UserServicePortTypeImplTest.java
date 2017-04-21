package org.jmp17.test;

import org.jmp17.UserServicePortTypeImpl;
import org.jmp17.service.UserServicePortType;
import org.jmp17.service.UserServiceRequestType;
import org.junit.Test;

/**
 * Created by asavitsky on 21.4.17.
 */
public class UserServicePortTypeImplTest {

    private UserServicePortTypeImpl userServicePortType = new UserServicePortTypeImpl();

    @Test
    public void test1(){
        UserServiceRequestType userServiceRequestType =  new UserServiceRequestType();
        userServiceRequestType.setUserName("Anton");
        userServicePortType.getUser(userServiceRequestType);
    }
}
