package org.jmp17;

/**
 * Created by antonsavitsky on 2/20/17.
 */
public class FileUploaderLivelock
{
  public static void main( String[] args )
  {
    final FileUploader fileUploader1 = new FileUploader( "1 Uploader" );
    final FileUploader fileUploader2 = new FileUploader( "2 Uploader" );

    final FileStorage fileStorage = new FileStorage();
    fileStorage.setActiveFileUploader( fileUploader1 );

    new Thread( new Runnable() {
      public void run()
      {
        fileUploader1.upload( "file1", fileUploader2, fileStorage );
      }
    }, "thread-1" ).start();

    new Thread( new Runnable() {
      public void run()
      {
        fileUploader2.upload( "file2", fileUploader1, fileStorage );
      }
    }, "thread-2" ).start();
  }
}
