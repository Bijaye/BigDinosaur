package com.bigdinosaur.core.io;



import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.bigdinosaur.core.fs.FileSystem;
import com.bigdinosaur.core.fs.Syncable;


public class FSDataOutputStream extends DataOutputStream
    implements Syncable, CanSetDropBehind {
  private final OutputStream wrappedStream;

  private static class PositionCache extends FilterOutputStream {
    private final FileSystem.Statistics statistics;
    private long position;

    PositionCache(OutputStream out, FileSystem.Statistics stats, long pos) {
      super(out);
      statistics = stats;
      position = pos;
    }

    @Override
    public void write(int b) throws IOException {
      out.write(b);
      position++;
      if (statistics != null) {
        statistics.incrementBytesWritten(1);
      }
    }
    
    @Override
    public void write(byte b[], int off, int len) throws IOException {
      out.write(b, off, len);
      position += len;                            // update position
      if (statistics != null) {
        statistics.incrementBytesWritten(len);
      }
    }
      
    long getPos() {
      return position;                            // return cached position
    }

    @Override
    public void close() throws IOException {
      // ensure close works even if a null reference was passed in
      if (out != null) {
        out.close();
      }
    }
  }

  public FSDataOutputStream(OutputStream out, FileSystem.Statistics stats) {
    this(out, stats, 0);
  }

  public FSDataOutputStream(OutputStream out, FileSystem.Statistics stats,
                            long startPosition) {
    super(new PositionCache(out, stats, startPosition));
    wrappedStream = out;
  }
  
  /**
   * Get the current position in the output stream.
   *
   * @return the current position in the output stream
   */
  public long getPos() {
    return ((PositionCache)out).getPos();
  }

  /**
   * Close the underlying output stream.
   */
  @Override
  public void close() throws IOException {
    out.close(); // This invokes PositionCache.close()
  }

  /**
   * Get a reference to the wrapped output stream.
   *
   * @return the underlying output stream
   */
 
  public OutputStream getWrappedStream() {
    return wrappedStream;
  }

  @Override  // Syncable
  public void hflush() throws IOException {
    if (wrappedStream instanceof Syncable) {
      ((Syncable)wrappedStream).hflush();
    } else {
      wrappedStream.flush();
    }
  }
  
  @Override  // Syncable
  public void hsync() throws IOException {
    if (wrappedStream instanceof Syncable) {
      ((Syncable)wrappedStream).hsync();
    } else {
      wrappedStream.flush();
    }
  }

  @Override
  public void setDropBehind(Boolean dropBehind) throws IOException {
    try {
      ((CanSetDropBehind)wrappedStream).setDropBehind(dropBehind);
    } catch (ClassCastException e) {
      throw new UnsupportedOperationException("the wrapped stream does " +
          "not support setting the drop-behind caching setting.");
    }
  }
}
