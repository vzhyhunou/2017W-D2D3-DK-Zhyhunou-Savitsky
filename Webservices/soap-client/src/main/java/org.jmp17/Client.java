package org.jmp17;

/**
 * Created by antonsavitsky on 3/16/17.
 */
public class Client {

    public static void main(String[] args) {
        HelloWorld_Service helloWorld_service = new HelloWorld_Service();
        HelloWorld helloWorld = helloWorld_service.getHelloWorldImplPort();
        System.out.println( helloWorld.sayHi("Hello my friend") );
    }
}
