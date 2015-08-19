package com.bigdinosaur.core.fs;



import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.Set;
import java.util.TreeSet;

import com.bigdinosaur.config.Configuration;
import com.bigdinosaur.config.Configured;

/****************************************************************
 * An abstract base class for a fairly generic filesystem.  It
 * may be implemented as a distributed filesystem, or as a "local"
 * one that reflects the locally-connected disk.  The local version
 * exists for small Hadoop instances and for testing.
 *
 * <p>
 *
 * All user code that may potentially use the Hadoop Distributed
 * File System should be written to use a FileSystem object.  The
 * Hadoop DFS is a multi-machine system that appears as a single
 * disk.  It's useful because of its fault tolerance and potentially
 * very large capacity.
 * 
 * <p>
 * The local implementation is {@link LocalFileSystem} and distributed
 * implementation is DistributedFileSystem.
 *****************************************************************/

public abstract class FileSystem extends Configured implements Closeable {
  /**
   * A cache of files that should be deleted when filsystem is closed
   * or the JVM is exited.
   */
  private Set<Path> deleteOnExit = new TreeSet<Path>();
  
  
  public abstract URI getUri();

  public abstract Path getWorkingDirectory();
  public static FileSystem get(URI uri, Configuration conf) throws Exception{
    Key key = new Key();
    return getInternal(uri, conf, key);
  }
  
  public static FileSystem getInternal(URI uri, Configuration conf, Key key) throws IOException
  {
    return null;
  }
    
  
}
