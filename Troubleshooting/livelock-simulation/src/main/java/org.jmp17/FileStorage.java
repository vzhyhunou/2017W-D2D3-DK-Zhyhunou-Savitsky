package org.jmp17;

import java.util.ArrayList;
import java.util.List;

class FileStorage {
  List<String> logs = new ArrayList<>();

  FileUploader activeFileUploader;

  public FileUploader getActiveFileUploader()
  {
    return activeFileUploader;
  }

  public synchronized void setActiveFileUploader( FileUploader activeFileUploader )
  {
    this.activeFileUploader = activeFileUploader;
  }

  public synchronized void log( String logMessage )
  {
    logs.add( logMessage );
  }

  public synchronized void upload( String fileName )
  {
    System.out
      .printf( "%s has uploaded %s!", activeFileUploader.getName(), fileName );
  }
}