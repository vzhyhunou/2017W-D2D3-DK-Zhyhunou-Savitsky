package org.jmp17.mbus;

import java.util.LinkedList;
import java.util.Queue;

public class App
{
  public static void main( String[] args )
  {
    Queue<String> queue = new LinkedList<>( );

    Thread producer1 = new Thread( new Producer( queue, "producer1" ) );
    Thread producer2 = new Thread( new Producer( queue, "producer2" ) );
    Thread consumer1 = new Thread( new Consumer( queue, "consumer1" ) );
    Thread consumer2 = new Thread( new Consumer( queue, "consumer2" ) );

    producer1.start();
    producer2.start();
    consumer1.start();
    consumer2.start();
  }

}
