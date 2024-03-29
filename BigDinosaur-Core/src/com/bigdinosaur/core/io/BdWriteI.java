package com.bigdinosaur.core.io;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class BdWriteI implements BdWrite
{
//TODO
 // checking is not done on the basis of data type ,for byte array case 
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
  
  
  public BdRead writeString(FileWriter stream, BdRead data)
  {
    for(BdRead value:data.getReaddata()){
      try
      {
        stream.write(value.getMapstring());
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


  @Override
  public byte[] getByteArray(ByteArrayOutputStream baos )
  {
    byte[] bytes = baos.toByteArray();
    return bytes;
  }
}