package org.jmp17.mbus;

import java.util.Queue;

public class Producer implements Runnable
{
  private Queue<String> queue;
  private String name;

  public Producer( Queue<String> queue, String name )
  {
    this.queue = queue;
    this.name = name;
  }

  @Override
  public void run()
  {
    for( int i = 0; i < 100; i++ ) {
      try {
        Thread.sleep( Math.round( Math.random()*1000 ) );
      } catch( InterruptedException e ) {
        e.printStackTrace();
      }
      synchronized( queue ) {
        queue.add( "new element" + i );
        queue.notify();
      }

      System.out.println( name + ": + new elem" );
    }
  }
}
