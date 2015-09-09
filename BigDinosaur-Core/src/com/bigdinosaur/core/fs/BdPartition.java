package com.bigdinosaur.core.fs;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BdPartition
{

  public byte[] read(BdSeekable seek, RandomAccessFile raf) throws IOException
  {
   
    byte[] read = seek.getBytesread();
    int byteread = seek.getNoofbytesread();
    int seekposition = seek.getSeekposition();
    raf.read(read, seekposition, byteread);
    return read;
  }

}
