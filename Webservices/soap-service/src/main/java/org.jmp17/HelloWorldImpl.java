package org.jmp17;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;
/**
 * Created by antonsavitsky on 3/16/17.
 */

@WebService(endpointInterface = "org.jmp17.HelloWorld",
        serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    //Map<Integer, User> users = new LinkedHashMap<Integer, User>();


    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    /*public String sayHiToUser(User user) {
        System.out.println("sayHiToUser called");
        users.put(users.size() + 1, user);
        return "Hello "  + user.getName();
    }

    public Map<Integer, User> getUsers() {
        System.out.println("getUsers called");
        return users;
    }*/

}