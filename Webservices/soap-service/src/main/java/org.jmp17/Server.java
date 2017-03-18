package org.jmp17;

import javax.xml.ws.Endpoint;

public class Server {

    private static final String serverUrl = "http://localhost:9000/userService";

    protected Server() throws Exception {
        UserServicePortTypeImpl implementor = new UserServicePortTypeImpl();
        Endpoint.publish(serverUrl, implementor);
        System.out.println("Server started on " + serverUrl);
    }

    public static void main(String args[]) throws Exception {
        new Server();
    }
}