package org.jmp17;

import org.jmp17.client.UserService;
import org.jmp17.client.UserServiceRequestType;
import org.jmp17.client.UserType;

/**
 * Created by antonsavitsky on 3/16/17.
 */
// this client is intended to use the userService to fetch user by its name passed to the main method as an argument
public class Client {

    public static void main(String[] args) {
        if(args.length!=1)
            System.out.println("Please enter just single name string");
        else {
            String userName = args[0];
            UserService userServiceClient = new UserService();
            UserServiceRequestType request = new UserServiceRequestType();
            request.setUserName(userName);
            UserType user = userServiceClient.getUserServicePort().getUser(request).getUser();
            System.out.println(  user != null ? user.getName() + " " + user.getEmail() : null);
        }
    }
}
