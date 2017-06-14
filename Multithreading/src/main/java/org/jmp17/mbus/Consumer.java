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
        while( queue.isEmpty() ){
          System.out.println( Thread.currentThread().getName() + " - " + name + ": queue is empty" );
          try {
            System.out.println( Thread.currentThread().getName() + " - " + name + " - waiting");
            queue.wait( 10000 );
            System.out.println( Thread.currentThread().getName() + " - " + name + " - stopped waiting");
          } catch( InterruptedException e ) {
            System.out.println( Thread.currentThread().getName() + " - " + name + " - interrupted");
            e.printStackTrace();
          }
        }
        String el = queue.poll();
        System.out.println( Thread.currentThread().getName() + " - " + name + ": polled element: " + el );
      }
      System.out.println( Thread.currentThread().getName() + " - " + name +  ": left synchronized" );
      someTimeConsumingLogic();
    }
  }

  public void someTimeConsumingLogic(){
    int c = 0;
    for(int i=0; i<100000; i++)
      c++;
  }
}
