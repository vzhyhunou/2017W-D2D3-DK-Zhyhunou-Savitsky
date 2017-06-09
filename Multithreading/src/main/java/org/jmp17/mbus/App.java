package org.jmp17.mbus;

import java.util.LinkedList;
import java.util.Queue;

public class App
{
  public static void main( String[] args )
  {
    Queue<String> queue = new LinkedList<>( );

    Thread consumer1 = new Thread( () -> {
      try {
        Thread.sleep( 1500 );
      } catch( InterruptedException e ) {
        e.printStackTrace();
      }

      long timer = System.currentTimeMillis();
      while(true){
        String el = queue.poll();
        if(el == null){
          System.out.println("consumer1: queue is empty");
          try {
            synchronized( queue ) {
              queue.wait(10000);
            }
          } catch( InterruptedException e ) {
            e.printStackTrace();
          }
        } else {
          System.out.println("consumer1: polled element: " + el);
        }
      }
    } );


    Thread consumer2 = new Thread( () -> {
      try {
        Thread.sleep( 1500 );
      } catch( InterruptedException e ) {
        e.printStackTrace();
      }

      long timer = System.currentTimeMillis();
      while(true){
        String el = queue.poll();
        if(el == null){
          System.out.println("consumer2: queue is empty");
          try {
            synchronized( queue ) {
              queue.wait(10000);
            }
          } catch( InterruptedException e ) {
            e.printStackTrace();
          }
        } else {
          System.out.println("consumer2: polled element: " + el);
        }
      }
    } );


    Thread producer = new Thread( new Runnable()
    {
      @Override
      public void run()
      {
        for( int i =0; i<100; i++ ) {
          try {
            Thread.sleep( 500 );
          } catch( InterruptedException e ) {
            e.printStackTrace();
          }
          queue.add( "new element" + i );
          synchronized( queue ){
            queue.notify();
          }

          System.out.println( "+ new elem" );
        }
      }
    });


    producer.start();
    consumer1.setDaemon( true );
    consumer1.start();

    consumer2.setDaemon( true );
    consumer2.start();

  }

}
