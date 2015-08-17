package com.bigdinosaur.core.net;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public interface BdSimpleChannel
{
  public abstract Object decode(DataInput paramDataInput)
      throws IOException;

  public abstract void encode(DataOutput paramDataOutput)
      throws IOException;
}
