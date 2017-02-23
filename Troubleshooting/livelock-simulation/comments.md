Execute the following command to get a runnable jar
```
mvn clean install
```

Run that jar
```
java -jar target/livelock-simulation-1.0-SNAPSHOT.jar
```

This is going to result into console output like the following
```
1 Uploader: Please upload first 2 Uploader!
2 Uploader: Please upload first 1 Uploader!
1 Uploader: Please upload first 2 Uploader!
2 Uploader: Please upload first 1 Uploader!
1 Uploader: Please upload first 2 Uploader!
2 Uploader: Please upload first 1 Uploader!
1 Uploader: Please upload first 2 Uploader!
2 Uploader: Please upload first 1 Uploader!
1 Uploader: Please upload first 2 Uploader!
2 Uploader: Please upload first 1 Uploader!
1 Uploader: Please upload first 2 Uploader!
2 Uploader: Please upload first 1 Uploader!
```

We can see from the output that Uploaders threads are just handing on the right to upload to each other. 
So there is no actual progress, just useless "politeness".

Next I collected thread dump using jvisualvm.

```
"thread-2" #10 prio=5 os_prio=0 tid=0x00007f4f901c1800 nid=0x41e9 in Object.wait() [0x00007f4f6db0a000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.jmp17.FileUploaderLivelock$FileUploader.upload(FileUploaderLivelock.java:43)
	- locked <0x00000000d6e6e2a8> (a org.jmp17.FileUploaderLivelock$FileUploader)
	at org.jmp17.FileUploaderLivelock$2.run(FileUploaderLivelock.java:78)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"thread-1" #9 prio=5 os_prio=0 tid=0x00007f4f901c0000 nid=0x41e8 in Object.wait() [0x00007f4f6dc0b000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.jmp17.FileUploaderLivelock$FileUploader.upload(FileUploaderLivelock.java:43)
	- locked <0x00000000d6e6e250> (a org.jmp17.FileUploaderLivelock$FileUploader)
	at org.jmp17.FileUploaderLivelock$1.run(FileUploaderLivelock.java:74)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None
```

As we can see both are locked to make progress, waiting for each other to continue.
Threads' progress can be seen in threads-snashot.jpeg.

Also I collected heap dump using jvisualvm. And got file heapdump-1487585037857.hprof.

And then dump file can be analized using jhat utilite:
```
jhat heapdump-1487585037857.hprof

Dump file created Mon Feb 20 13:03:57 MSK 2017
Snapshot read, resolving...
Resolving 35193 objects...
Chasing references, expect 7 dots.......
Eliminating duplicate references.......
Snapshot resolved.
Started HTTP server on port 7000
Server is ready.
```

We access localhost:7000 and get report. Sample of such report is in heap-dump-analyzed.jpeg. There we can see object 
references and its memory consumption.

For resolving resulted livelock situation I can recommend setting random time on wait statement to allow threads finish 
their work until while thread waits.

Run the jar file this way:
```
java -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -jar livelock-simulation-1.0-SNAPSHOT.jar
```
Later in the process of working app, you will see the following message:
```
Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "thread-1"
```
Which means we ran out of available 2 MB heap size.
 
Also for the more advanced and nice view of Heap dump we can pass the dump file to Eclipse Memory Analyzer. We ca see there
top memory consuming objects and there referees and referrers. So that we localize a memory leak and fix it. Example of report
is eclipse-memory-analyzer.png. There is FileStorage object which consumes more then half of available heap memory for storing
log messages.