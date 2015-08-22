package com.bigdinosaur.core.fs;



import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.bigdinosaur.core.net.Writable;


/** This class is used to represent the capacity, free and used space on a
  * {@link FileSystem}.
  */
public class FsStatus implements Writable {
  private long capacity;
  private long used;
  private long remaining;

  /** Construct a FsStatus object, using the specified statistics */
  public FsStatus(long capacity, long used, long remaining) {
    this.capacity = capacity;
    this.used = used;
    this.remaining = remaining;
  }

  /** Return the capacity in bytes of the file system */
  public long getCapacity() {
    return capacity;
  }

  /** Return the number of bytes used on the file system */
  public long getUsed() {
    return used;
  }

  /** Return the number of remaining bytes on the file system */
  public long getRemaining() {
    return remaining;
  }

  //////////////////////////////////////////////////
  // Writable
  //////////////////////////////////////////////////
  @Override
  public void write(DataOutput out) throws IOException {
    out.writeLong(capacity);
    out.writeLong(used);
    out.writeLong(remaining);
  }

  @Override
  public void readFields(DataInput in) throws IOException {
    capacity = in.readLong();
    used = in.readLong();
    remaining = in.readLong();
  }
}
