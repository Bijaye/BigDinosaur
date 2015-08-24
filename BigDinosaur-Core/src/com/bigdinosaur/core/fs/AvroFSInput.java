package com.bigdinosaur.core.fs;



import java.io.Closeable;
import java.io.IOException;

import org.apache.avro.file.SeekableInput;

import com.bigdinosaur.base.context.FileContext;




public class AvroFSInput implements Closeable, SeekableInput {
//  private final FSDataInputStream stream;
  private final long len;

//  /** Construct given an {@link FSDataInputStream} and its length. */
//  public AvroFSInput(final FSDataInputStream in, final long len) {
//    this.stream = in;
//    this.len = len;
//  }

  /** Construct given a {@link FileContext} and a {@link Path}. */
  public AvroFSInput(final FileContext fc, final Path p) throws IOException {
    FileStatus status = fc.getFileStatus(p);
    this.len = status.getLen();
//    this.stream = fc.open(p);
  }

  @Override
  public long length() {
    return len;
  }

  @Override
  public int read(byte[] arg0, int arg1, int arg2) throws IOException
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void seek(long arg0) throws IOException
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public long tell() throws IOException
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void close() throws IOException
  {
    // TODO Auto-generated method stub
    
  }

//  @Override
//  public int read(byte[] b, int off, int len) throws IOException {
//    return stream.read(b, off, len);
//  }
//
//  @Override
//  public void seek(long p) throws IOException {
//    stream.seek(p);
//  }
//
//  @Override
//  public long tell() throws IOException {
//    return stream.getPos();
//  }
//
//  @Override
//  public void close() throws IOException {
//    stream.close();
//  }
}
