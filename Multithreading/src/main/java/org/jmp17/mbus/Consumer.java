package org.jmp17.mbus;

import java.util.Queue;

public class Consumer implements Runnable
{
  private Queue<String> queue;
  private String name;

  public Consumer( Queue<String> queue, String name )
  {
    this.queue = queue;
    this.name = name;
  }

  @Override
  public void run()
  {
    while(true){
      synchronized( queue ) {
        String el = queue.poll();
        if ( el == null ) {
          System.out.println( Thread.currentThread().getName() + " - " + name + ": queue is empty" );
          try {
            System.out.println( Thread.currentThread().getName() + " - waiting");
            queue.wait( 10000 );
            System.out.println( Thread.currentThread().getName() + " - stopped waiting");
          } catch( InterruptedException e ) {
            System.out.println( Thread.currentThread().getName() + " - interrupted");
            e.printStackTrace();
          }
        } else {
          System.out.println( Thread.currentThread().getName() + " - " + name + ": polled element: " + el );
        }
      }
    }
  }
}
