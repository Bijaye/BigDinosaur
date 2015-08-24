package com.bigdinosaur.core.fs;

import java.io.IOException;


public interface PositionedReadable {
  /**
   * Read upto the specified number of bytes, from a given
   * position within a file, and return the number of bytes read. This does not
   * change the current offset of a file, and is thread-safe.
   */
  
  //position=seek position
  //seek=5=position
    //  offset=2;
  //lenght=20;
  //read starts from position 5 ,read 10 bytes and copy to buffer array starting from position 2
 
  public int read(long position, byte[] buffer, int offset, int length)
    throws IOException;
  
  /**
   * Read the specified number of bytes, from a given
   * position within a file. This does not
   * change the current offset of a file, and is thread-safe.
   */
  
  public void readFully(long position, byte[] buffer, int offset, int length)
    throws IOException;
  
  /**
   * Read number of bytes equal to the length of the buffer, from a given
   * position within a file. This does not
   * change the current offset of a file, and is thread-safe.
   */
  public void readFully(long position, byte[] buffer) throws IOException;
}
