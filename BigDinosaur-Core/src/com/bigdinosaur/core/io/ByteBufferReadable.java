package com.bigdinosaur.core.io;


import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Implementers of this interface provide a read API that writes to a
 * ByteBuffer, not a byte[].
 */
public interface ByteBufferReadable {
  /**
   * Reads up to buf.remaining() bytes into buf. Callers should use
   * buf.limit(..) to control the size of the desired read.
   * <p/>
   * After a successful call, buf.position() will be advanced by the number 
   * of bytes read and buf.limit() should be unchanged.
   * <p/>
   * In the case of an exception, the values of buf.position() and buf.limit()
   * are undefined, and callers should be prepared to recover from this
   * eventuality.
   * <p/>
   * Many implementations will throw {@link UnsupportedOperationException}, so
   * callers that are not confident in support for this method from the
   * underlying filesystem should be prepared to handle that exception.
   * <p/>
   * Implementations should treat 0-length requests as legitimate, and must not
   * signal an error upon their receipt.
   *
   * @param buf
   *          the ByteBuffer to receive the results of the read operation.
   * @return the number of bytes read, possibly zero, or -1 if 
   *         reach end-of-stream
   * @throws IOException
   *           if there is some error performing the read
   */
  public int read(ByteBuffer buf) throws IOException;
}
