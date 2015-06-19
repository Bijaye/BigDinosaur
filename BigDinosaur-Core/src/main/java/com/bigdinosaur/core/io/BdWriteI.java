package com.bigdinosaur.core.io;

import java.io.IOException;
import java.io.OutputStream;

public class BdWriteI implements BdWrite
{

  @Override
  public BdRead write(OutputStream stream, BdRead data)
  {
   for(BdRead value:data.getReaddata()){
    try
    {
      stream.write(value.getI());
    }
    catch (IOException e)
    {
    }
  }
  return data;
  
  }

}
