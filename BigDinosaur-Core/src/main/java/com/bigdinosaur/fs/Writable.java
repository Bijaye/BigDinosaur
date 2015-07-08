package com.bigdinosaur.fs;

import java.io.DataInput;
import java.io.IOException;

public interface Writable {
  /** 
   * Serialize the fields of this object to <code>out</code>.
   * 
   
  void write(DataOutput out) throws IOException;

  /** 
   * Deserialize the fields of this object from <code>in</code>.  
   * 
   
   */
  void readFields(DataInput in) throws IOException;
}
