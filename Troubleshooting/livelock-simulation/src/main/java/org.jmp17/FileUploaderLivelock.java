package org.jmp17;

import java.util.List;

/**
 * Created by antonsavitsky on 2/20/17.
 */
public class FileUploaderLivelock {

        static class FileStorage {
            private FileUploader activeFileUploader;

            public FileUploader getActiveFileUploader() {
                return activeFileUploader;
            }

            public synchronized void setActiveFileUploader(FileUploader activeFileUploader) {
                this.activeFileUploader = activeFileUploader;
            }

            public synchronized void upload(String fileName) {
                System.out.printf("%s has uploaded %s!", activeFileUploader.getName(), fileName);
            }
        }

        static class FileUploader {
            private String name;
            private boolean isWorking;

            public String getName() {
                return name;
            }

            public FileUploader(String name) {
                this.name = name;
                isWorking = true;
            }

            public synchronized void upload(String fileName, FileUploader otherFileUploader, FileStorage fileStorage) {
                while (isWorking) {
                    // wait for acquiring fileStorage
                    if (fileStorage.getActiveFileUploader() != this) {
                        try { wait(100); }
                        catch(InterruptedException e) { continue; }
                        continue;
                    }

                    // if other fileUploader needs to upload then give it a chance
                    if (otherFileUploader.isWorking) {
                        System.out.printf(
                                "%s: Please upload first %s!%n",
                                name, otherFileUploader.getName());
                        fileStorage.setActiveFileUploader(otherFileUploader);
                        continue;
                    }
                    // finally if nobody uploads then proceed
                    fileStorage.upload(fileName);
                    //mark itself done
                    isWorking = false;
                    fileStorage.setActiveFileUploader(otherFileUploader);
                }

            }
        }

        public static void main(String[] args) {
            final FileUploader fileUploader1 = new FileUploader("1 Uploader");
            final FileUploader fileUploader2 = new FileUploader("2 Uploader");

            final FileStorage fileStorage = new FileStorage();
            fileStorage.setActiveFileUploader(fileUploader1);

            new Thread(new Runnable() {
                public void run() { fileUploader1.upload("file1", fileUploader2, fileStorage); }
            }, "thread-1").start();

            new Thread(new Runnable() {
                public void run() { fileUploader2.upload("file2", fileUploader1, fileStorage); }
            }, "thread-2").start();
        }
}
