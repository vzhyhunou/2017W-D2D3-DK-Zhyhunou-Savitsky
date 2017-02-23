package org.jmp17;

class FileUploader
{
  private String name;
  private boolean isWorking;

  public FileUploader( String name )
  {
    this.name = name;
    isWorking = true;
  }

  public String getName()
  {
    return name;
  }

  public synchronized void upload( String fileName, FileUploader otherFileUploader,
    FileStorage fileStorage )
  {
    while ( isWorking ) {
      // wait for acquiring fileStorage
      if ( fileStorage.getActiveFileUploader() != this ) {
        try {
          wait( 10 );
        } catch( InterruptedException e ) {
          continue;
        }
        continue;
      }

      // if other fileUploader needs to upload then give it a chance
      if ( otherFileUploader.isWorking ) {
        System.out.printf(
          "%s: Please upload first %s!%n", name, otherFileUploader.getName() );
        fileStorage.log(
          new String(
            name + " yields an access to fileStorage"
              + otherFileUploader.getName() ) );
        fileStorage.setActiveFileUploader( otherFileUploader );
        continue;
      }
      // finally if nobody uploads then proceed
      fileStorage.upload( fileName );
      // mark itself done
      isWorking = false;
      fileStorage.setActiveFileUploader( otherFileUploader );
    }

  }
}