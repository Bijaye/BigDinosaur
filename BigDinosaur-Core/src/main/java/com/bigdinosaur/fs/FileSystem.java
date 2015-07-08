package com.bigdinosaur.fs;

import java.io.Closeable;
import java.io.IOException;

import com.bigdinosaur.config.Configured;
/****************************************************************
 * An abstract base class for a fairly generic filesystem.  It
 * may be implemented as a distributed filesystem, or as a "local"
 * one that reflects the locally-connected disk.  The local version
 * exists for small bigdinosaur instances and for testing.
 *
 * 
 *
 * All user code that may potentially use the bigdinosaur Distributed
 * File System should be written to use a FileSystem object.  The
 * bigdinosaur DFS is a multi-machine system that appears as a single
 * disk.  It's useful because of its fault tolerance and potentially
 * very large capacity.
 * 
 * 
 * The local implementation is LocalFileSystem} and distributed
 * implementation is DistributedFileSystem.
 *****************************************************************/
public class FileSystem  extends Configured implements Closeable
{

  @Override
  public void close() throws IOException
  {
    // TODO Auto-generated method stub
    
  }

}
