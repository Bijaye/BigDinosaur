package com.bigdinosaur.core.fs;



import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;

import com.bigdinosaur.cluster.acl.FsPermission;


public class BdLocalFileSystem extends FileSystem {
  static final URI NAME = URI.create("file:///");
  @Override
  public void close() throws IOException
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public DataOutputStream create(Path f, FsPermission permission, boolean overwrite,
                                 int bufferSize, short replication, long blockSize, Object progress)
                                                                                                    throws IOException
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public URI getUri()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Path getWorkingDirectory()
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  

}
