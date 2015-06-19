package com.bigdinosaur.core.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class BdWriteI implements BdWrite
{

  @Override
  public BdRead writeByte(OutputStream stream, BdRead data)
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

  
  @Override
  public BdRead writeCharacter(FileWriter stream, BdRead data)
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
  
      if (stream != null) {
        try
        {
          stream.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
     
  }
    return data;

}
}