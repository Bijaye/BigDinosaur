package com.bigdinosaur.core.fs;



import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import com.bigdinosaur.cluster.acl.FsPermission;
import com.bigdinosaur.core.io.FSDataInputStream;


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

  @Override
  public boolean mkdirs(Path f, FsPermission permission) throws IOException
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean delete(Path f, boolean recursive) throws IOException
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public FileStatus getFileStatus(Path f) throws IOException
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FileStatus[] listStatus(Path f) throws FileNotFoundException, IOException
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FSDataInputStream open(Path f, int bufferSize) throws IOException
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  

}
