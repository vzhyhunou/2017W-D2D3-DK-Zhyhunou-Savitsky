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
        int numberOfElemToInject = Math.toIntExact( Math.round( Math.random() * 100 ) );
        for (int j = 0; j < numberOfElemToInject; j++)
          queue.add( "new element" + j );
        queue.notifyAll();
      }
      System.out.println( name + ": + new elem" );
    }
  }
}
