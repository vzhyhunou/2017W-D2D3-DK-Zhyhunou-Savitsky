package org.jmp17;

import org.jmp17.client.UserService;
import org.jmp17.client.UserServicePortType;
import org.jmp17.client.UserServiceRequestType;
import org.jmp17.client.UserType;
import org.jmp17.config.UserServiceClientConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.BindingProvider;

/**
 * Created by antonsavitsky on 3/16/17.
 */
// this client is intended to use the userService to fetch user by its name passed to the main method as an argument
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceClientConfig.class);

        UserServiceClient userServiceClient = context.getBean(UserServiceClient.class);
        UserType user = userServiceClient.getUserByName("Anton");
        System.out.println(  user != null ? user.getName() + " " + user.getEmail() : null);
    }
}
