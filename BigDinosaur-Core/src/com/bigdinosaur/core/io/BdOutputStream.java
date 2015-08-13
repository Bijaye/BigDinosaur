package com.bigdinosaur.core.io;

import java.io.ByteArrayOutputStream;

public class BdOutputStream  extends ByteArrayOutputStream
implements BdWritec
{
  BdOutputStream(){
    super();
  }

  private static BdOutputStream[] pool = new BdOutputStream[20];

  public static BdOutputStream[] getPool()
  {
    return pool;
  }

  public static void setPool(BdOutputStream[] pool)
  {
    BdOutputStream.pool = pool;
  }

  @Override
  public void writeBooleanbd(boolean paramBoolean)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void writeUnsignedIntegerbd(long paramLong)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void writeSignedIntegerbd(int paramInt1, int paramInt2)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void writeDoublebd(int paramInt, double paramDouble)
  {
    // TODO Auto-generated method stub
    
  }



  @Override
  public void writeCharacterStringbd(String paramString)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void writeEncodedValuebd(byte[] paramArrayOfByte)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void writeEncodedValuebd(int paramInt, byte[] paramArrayOfByte)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void writebd(byte[] paramArrayOfByte)
  {
    // TODO Auto-generated method stub
    
  }

  
}
